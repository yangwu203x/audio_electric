package com.audio.electric.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/5/9 0009 10:29
 */
@Controller
@RequestMapping("/file")
public class FileController {

        @RequestMapping("/getFileByPath")
        public void getFileByPath(String path, HttpServletResponse response){
            InputStream in = null;
            OutputStream out = null;
            try {
                in = new FileInputStream(path);
                int len = 0;
                byte[] buffer = new byte[1024];
                out = response.getOutputStream();
                while((len = in.read(buffer)) > 0) {
                    out.write(buffer,0,len);
                }

            }catch(Exception e) {
                throw new RuntimeException(e);
            }finally {
                if(in != null) {
                    try {
                        in.close();
                    }catch(Exception e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }

        public static Vector<String> getPicturesOfDir(String path){
            //get all the picture-files name from dir(path)
            Vector<String> pictures = new Vector<>();
            Path dir = Paths.get(path);
            assert Files.exists(dir) && Files.isDirectory(dir);

            try(DirectoryStream<Path> files = Files.newDirectoryStream(dir,new DirectoryStream.Filter<Path>(){
                public boolean accept(Path file){
                    return Files.isRegularFile(file) && file.getFileName().toString().matches("^.*[.](?i:jpg|png|bmg|gif|img)$");
                }
            })){
                for(Path file : files){
                    pictures.add(file.getFileName().toString());
                }
            }catch(IOException e){
                e.printStackTrace();
                System.exit(1);
            }


            return pictures;
        }
}
