package com.audio.electric;

import java.io.*;

/**
 * @Author leo_Yang【音特】
 * @Date 2017/9/23 0023 18:30
 */
public class ObjectStream {
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO自动生成的方法存根
        ObjectOutputStream objectwriter=null;
        ObjectInputStream objectreader=null;

        try {
            objectwriter=new ObjectOutputStream(new FileOutputStream("D:/David/Java/files/student.txt"));
            objectwriter.writeObject(new Student("gg", 22));
            objectwriter.writeObject(new Student("tt", 18));
            objectwriter.writeObject(new Student("rr", 17));
            objectreader=new ObjectInputStream(new FileInputStream("D:/David/Java/files/student.txt"));
            for (int i = 0; i < 3; i++) {
                System.out.println(objectreader.readObject());
                objectreader.notifyAll();
            }
        } catch (IOException | ClassNotFoundException e) {
            // TODO自动生成的 catch 块
            e.printStackTrace();
        }finally{
            try {
                objectreader.close();
                objectwriter.close();
            } catch (IOException e) {
                // TODO自动生成的 catch 块
                e.printStackTrace();
            }

        }

    }

}
class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}
