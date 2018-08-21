package com.Utils;

import java.io.File;

/**
 * @Author : liyongjie
 * @Date : 2018/8/7 0007
 */
public class FolderUtil {

    public static int count=3;

    public static void main(String[] args){
//        String demo = "E:\\信号优化\\upload\\ohters\\2018\\08\\08\\1062\\20180808_114226/id=54943763.png";
//        File file = new File(demo);
//        System.out.println(file.getName());
//        System.out.println(new File(file.getParent()).getParent());
//
//        File file = new File("E:\\信号优化\\upload\\ohters\\2018\\08\\08\\1062\\20180808_114226");
//        System.out.println(file.mkdirs());
//        System.out.println(file.getParent());

        String url = "E:\\信号优化\\upload";
        Integer num = new Integer(3);
        File file = new File(url);
        getFile(url,num);
    }

    /**
     * 显示目录结构，level表示层级
     * @param url
     * @param level
     * @return
     */
    public static void getFile(String url,Integer level){
        File files = new File(url);
        File[] list = files.listFiles();
        for(File f : list){
            if(f.isDirectory()){
                level += 1;      //进入目录遍历，层级加1
                System.out.println(f.getAbsolutePath()+"              level:" + level);
                getFile(f.getAbsolutePath(),level);    ////递归调用遍历目录的方法
                level -= 1;     //当前文件夹遍历完成，退回到上一级，继续遍历下一个文件夹
            }
        }
    }

    /**
     * 删除路径下的空目录(不包含文件)，目录有多少级需要执行多少次（每次只能删除叶子目录）
     * @param url
     */
    public static void delEmptyFolder(String url) {
        File file = new File(url);
        if (file.isFile()) {
            return;
        }
        File[] list = file.listFiles();
        if (list != null && list.length > 0) {
            for (File f : list) {
                if (f.isDirectory()) {
                    delEmptyFolder(f.getAbsolutePath());
                }
            }
        }
        if(list == null || list.length==0){
            file.delete();
        }
    }

    /**
     * 删除目录
     * @param url
     * @return
     */
    public static boolean deleteFolder(String url){
        delAllFile(url);
        File file = new File(url);
        return file.delete();
    }

    public static boolean delAllFile(String url) {
        boolean flag = false;
        File file = new File(url);
        if(!file.exists()){
            return flag;
        }
        if (!file.isDirectory()){
            return flag;
        }
        File tempFile = null;
        String[] list = file.list();
        for(String temp : list){
            if (url.endsWith(File.separator)){
                tempFile = new File(url + temp);
            }else {
                tempFile = new File(url + File.separator + temp);
            }
            if(tempFile.isFile()){
                tempFile.delete();
            }
            if(tempFile.isDirectory()){
                delAllFile(url + "\\" + temp);
                deleteFolder(url + "\\" +temp);
                flag = true;
            }
        }
        return flag;
    }

}
