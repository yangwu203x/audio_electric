package com.audio.electric.controller;

import com.audio.electric.domain.Record;
import com.audio.electric.domain.Song;
import com.audio.electric.domain.User;
import com.audio.electric.service.ICountService;
import com.audio.electric.util.tool.DateStyle;
import com.audio.electric.util.tool.DateUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/4 0004 14:27
 */
@Controller
@RequestMapping("/count")
public class CountController {
    private static List<Record> records = new ArrayList<>();
    @Autowired
    private ICountService countService;

    /**
     * 从输入流中获取字节数组
     * @param inputStream
     * @return
     * @throws IOException
     */
    public static  byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    /**
     * 获取远程文件保存在本地
     * @return
     * @throws IOException
     */
    @GetMapping("/getRecord")
    public static String recordFile(Integer pageNum ,Integer refresh, Model model)  {
        if (pageNum == null)
            pageNum = 1;
        if (refresh == null)
            refresh = 0;
        List<Record> recordList;
        int rowNum = 0;
        int pageSize = 10;
        BufferedReader br = null;
        if (records.size() > 0 && refresh != 1){
        }else{
            records.clear();
            InputStream inputStream = null;
            try {
               String urlStr = "http://118.190.204.56:80/app/getRecordFile";
//               String urlStr = "http://localhost:8080/app/getRecordFile";
               String savePath = "d:\\record"+DateUtil.getCurDatePath();
               String fileName = DateUtil.DateToString(new Date(), DateStyle.HH_MM_SS2)+"_record.txt";
               URL url = new URL(urlStr);
               HttpURLConnection conn = (HttpURLConnection)url.openConnection();
               //设置超时间为3秒
               conn.setConnectTimeout(3*1000);
               //防止屏蔽程序抓取而返回403错误
               conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
               //得到输入流
               inputStream = conn.getInputStream();
               br = new BufferedReader(new InputStreamReader(inputStream));
               String msg = br.readLine();
               while(msg != null){
                   String[] msgs = msg.split("\t");
                   if (msgs == null || msgs.length <3){
                       continue;
                   }
                   Record record = new Record(msgs);
                   records.add(record);
                   msg =  br.readLine();
               }
               //倒序
                Collections.reverse(records);
           }catch (IOException e){
               e.printStackTrace();
           }finally {
               if(br!=null){
                   try {
                       br.close();
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
               }
                if (inputStream != null){
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
           }

        }
        rowNum = records.size();
        recordList = records.subList((pageNum-1)*pageSize,pageNum*pageSize > rowNum ? rowNum : pageNum*pageSize);
        PageInfo<Record> pagehelper = new PageInfo(records);
        pagehelper.setTotal(rowNum);
        pagehelper.setPageNum(pageNum);
        pagehelper.setPages( rowNum%pageSize == 0 ? rowNum/pageSize : rowNum/pageSize + 1);

        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("recordList",recordList);

        return "count/download/download_record_list";
        //获取自己数组


    }

    @RequestMapping("/songRank")
    public String songRank(Song song, Model model){
        List<Song> songList = countService.songRank(song);
        PageInfo<Song> pagehelper = new PageInfo<>(songList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("songList",songList);
        return "count/song_rank_list";
    }

    @RequestMapping("/songCollection")
    public String songCollection(Song song,Model model){
        List<Song> songList = countService.songCollection(song);
        PageInfo<Song> pagehelper = new PageInfo<>(songList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("songList",songList);
        return "count/song_collection_list";
    }

    @RequestMapping("/onlineUser")
    public String onlineUserCount(Model model){
        List<User> userList = countService.listUserOnline();
        PageInfo<User> pagehelper = new PageInfo<>(userList);
        model.addAttribute("pagehelper",pagehelper);
        model.addAttribute("userList",userList);
        return "count/online_count/online_user_list";
    }

    @RequestMapping("/saleRecord")
    public String saleRecord(){

        return "count/sale_list";
    }
}
