package com.audio.electric.service;

import java.io.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/6/21 0021 9:55
 */
public class ExportExcelTest {
    public static void main(String[] args){
        String path = "d:/test.xlsx";
        try {
//            BufferedWriter buff = new BufferedWriter(new FileWriter(path));
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
            OutputStream os = new FileOutputStream(path);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter buff = new BufferedWriter(osw);
            buff.write("部门名称\t用户\t电话");//代表3列
            buff.write("\r\n");//换行
            //插入5万条记录
            for (int i = 0; i < 150000; i++) {
                buff.write("短信营业厅\t小吴\t123456");
                buff.write("\r\n");
            }
            buff.close(); //关闭文件操作
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
