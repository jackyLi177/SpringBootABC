package com.Utils.json;

/**
 * @author Ian
 * @date 2018/3/30 重写各类Model的toString进行格式化
 */
public class JsonReadable {

    @Override
    public String toString() {
        return ObjectMapperUtil.toString(this);
    }
}
