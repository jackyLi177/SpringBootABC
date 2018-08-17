package com.Utils;

import java.io.File;

/**
 * @Author : liyongjie
 * @Date : 2018/8/7 0007
 */
public class FolderUtil {

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
        File file = new File(url);
        Integer levle = 3;
        getFile(url,3);
        for (int i=1;i<=5;i++){
            delEmptyFolder(url);
        }
        System.out.println("================================================================");
        getFile(url,3);
    }

    /**
     * 显示目录结构，level表示层级
     * @param url
     * @param level
     * @return
     */
    public static void getFile(String url,Integer level){
        level = level + 1;
        File files = new File(url);
        File[] list = files.listFiles();
        for(File f : list){
            System.out.println(f.getAbsolutePath()+"              level:" + level);
            if(f.isDirectory()){
                getFile(f.getAbsolutePath(),level);
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
