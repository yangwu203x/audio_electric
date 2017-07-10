package com.audio.electric.service.impl;

import com.audio.electric.domain.ExportPrivilege;
import com.audio.electric.domain.Role;
import com.audio.electric.domain.RoleAccountExample;
import com.audio.electric.domain.RoleExample;
import com.audio.electric.mapper.ExportPrivilegeMapper;
import com.audio.electric.mapper.RoleAccountMapper;
import com.audio.electric.mapper.RoleMapper;
import com.audio.electric.service.BaseService;
import com.audio.electric.service.IRoleService;
import com.audio.electric.util.annotation.UsePage;
import com.audio.electric.util.enums.RetCode;
import com.audio.electric.util.exception.PlatException;
import com.audio.electric.util.tool.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/4/26 0026 16:13
 */
@Component
public class RoleServiceImpl extends BaseService implements IRoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleAccountMapper roleAccountMapper;

    @Autowired
    private ExportPrivilegeMapper exportPrivilegeMapper;

    @UsePage
    @Override
    public List<Role> listRole(Role role) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.or();
        if (StringUtils.isNotNull(role.getRoleName()))
            criteria.andRoleNameLike('%'+role.getRoleName()+'%');
        List<Role> roleList = null;
        try {
            roleList = roleMapper.selectByExample(roleExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    @Override
    public Role getRole(Role role) {
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.or();
        try {
            role = roleMapper.selectByPrimaryKey(role.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public int addRole(Role role) {
        int result = RetCode.FAILED.getCode();
        try {
            result = roleMapper.insertSelective(role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyRole(Role role) {
        int result = RetCode.FAILED.getCode();
        try {
            RoleExample roleExample = new RoleExample();
            RoleExample.Criteria criteria = roleExample.or();
            criteria.andIdEqualTo(role.getId());
            result = roleMapper.updateByExampleSelective(role,roleExample);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteRole(String ids) {
        int result = RetCode.FAILED.getCode();
        try {
            if (StringUtils.isNull(ids))
                throw new PlatException(RetCode.PARAMETER_ERROR);
            List<Integer> idList = getIdListInt(ids);
            RoleAccountExample roleAccountExample = new RoleAccountExample();
            roleAccountExample.or().andRoleIdIn(idList);

            //判断角色是否分配给用户了
            int count = roleAccountMapper.countByExample(roleAccountExample);
            if(count > 0){
                return result;
            }else{
                RoleExample roleExample = new RoleExample();
                roleExample.or().andIdIn(idList);
                result = roleMapper.deleteByExample(roleExample);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int modifyExportPwd(ExportPrivilege exportPrivilege) {
        int result = RetCode.FAILED.getCode();
        try {
            result = exportPrivilegeMapper.insertSelective(exportPrivilege);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
