package com.audio.electric.controller;

import com.audio.electric.domain.Menu;
import com.audio.electric.domain.Role;
import com.audio.electric.service.IMenuService;
import com.audio.electric.util.protocol.BodyUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/26 0026 16:16
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private IMenuService menuService;

    /**
     * 获取父级菜单
     * @return
     */
    @ResponseBody
    @RequestMapping("/parentMenu")
    public Object obtainParentMenu() throws Exception{
        List<Menu> menuList = menuService.obtainAllMenu();
        for (int i = 0; i <menuList.size(); i++) {
            menuList.get(i).setSubMenuList(null);
        }
        return menuList;
    }

    @GetMapping("/listMenu")
    public String listMenu(Menu menu, Model model){
        List<Menu> menuList = menuService.listMenu(menu);
        PageInfo pagehelper = new PageInfo(menuList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("menuList",menuList);
        return "menu/menu_list";
    }

    @RequestMapping("/obtainAllMenu")
    @ResponseBody
    public Object obtainAllMenu(){
        List<Menu> menuList = menuService.obtainAllMenu();

        return menuList;
    }


    @RequestMapping("/obtainMenuIdByRole")
    @ResponseBody
    public Object obtainMenuIdByRole(Role role){
        List<Integer> idsList = menuService.listMenuIdByRole(role);
        return idsList;
    }

    /**
     * 控制layer弹出层的视图显示
     * @return
     */
    @RequestMapping("/showAddMenu")
    public String showView(Menu menu,Model model,String operateType) throws Exception{
        String viewName = "menu/menu_edit";
        //获取要访问的视图
        if(("1").equals(operateType)){
            //添加
            model.addAttribute("requestUrl","/menu/addMenu");
            return viewName;
        }else if(("2").equals(operateType)){
            //修改
            menu = menuService.getMenu(menu);
            model.addAttribute("menu",menu);
            model.addAttribute("requestUrl","/menu/modifyMenu");
            return viewName;
        }
        //设置视图
        return "404";
    }

    /**
     * 增加菜单
     * @param menu
     * @return
     */
    @PostMapping("/addMenu")
    @ResponseBody
    public String addMenu(Menu menu){
        int result = menuService.addMenu(menu);
        return result+"";
    }

    /**
     * 修改菜单
     * @param menu
     * @return
     */
    @RequestMapping("/modifyMenu")
    @ResponseBody
    public String modifyMenu(Menu menu,HttpServletRequest request){

        int result = menuService.modifyMenu(menu);
        return result+"";
    }

    /**
     * 删除/批量菜单
     * @param ids
     * @return
     */
    @PostMapping("/deleteMenu")
    @ResponseBody
    public Object deleteMenu(String ids){
        int result = menuService.deleteMenu(ids);
        return BodyUtil.result(result);
    }

}
