package com.audio.electric.service;

import com.audio.electric.domain.Singer;
import com.audio.electric.service.impl.SingerServiceImpl;
import com.audio.electric.service.impl.SongServiceImpl;
import com.audio.electric.util.tool.ReadExcel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/7/11 0011 17:05
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ImportSingerTest {

    @Autowired
    private SingerServiceImpl singerService;

    @Test
    public void importSinger() throws FileNotFoundException, ParseException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\singer.xlsx");
        List<Map<Integer,Object>> dataList = ReadExcel.parseSuccexx(new FileInputStream(file),"singer.xlsx",-1);
        int pageSize = 10;


        int total = dataList.size();

        int pageCount = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;

        Map<Integer,List<Map<Integer,Object>>> tmpMap = new ConcurrentHashMap<>();
        for (int i = 0 ; i< pageCount ;i++){
            int start = i * pageSize;
            int end = start + pageSize > total ? total : start + pageSize;
            List<Map<Integer,Object>> subList = dataList.subList(start, end);
            tmpMap.put(i, subList);
        }

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(8);

        for (int i = 0; i < pageCount; i++) {
             List<Map<Integer,Object>> tempList = tmpMap.get(i);
            Runnable r = new InSertThread(tempList,singerService);
             fixedThreadPool.execute(r);
        }

    }
    public static void main(String[] args){

    }



}
