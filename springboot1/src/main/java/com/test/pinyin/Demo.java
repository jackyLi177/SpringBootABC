package com.test.pinyin;


import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;

/**
 * @Author : lyj
 * @Date : 2018/7/13 0013
 */
public class Demo {

    public <T> void sss(T t){
        String name = t.getClass().getName();
        System.out.println(name);
    }

    public static void main(String[] args){
        StringBuffer pybf = new StringBuffer();
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.UPPERCASE);   //大小写
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);   //带不带音标
        String str = "领拉开c纪cc念馆";
        char[] chars = str.toCharArray();
        for (char c : chars){
            if (c > 128) {
                try {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat);
                    Arrays.stream(temp).forEach(System.out::println);
                    if (temp != null) {
                        pybf.append(temp[0].charAt(0));
                    }
                } catch (BadHanyuPinyinOutputFormatCombination e) {
                    e.printStackTrace();
                }
            } else {
                pybf.append(c);
            }
        }

        System.out.println(pybf.toString());
    }

}
