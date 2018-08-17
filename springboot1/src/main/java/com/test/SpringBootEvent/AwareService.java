package com.test.SpringBootEvent;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * @Author : liyongjie
 * @Date : 2018/8/2 0002
 */
@Service
public class AwareService implements BeanNameAware,ResourceLoaderAware {
    private String name;
    private ResourceLoader loader;

    @Override
    public void setBeanName(String name) {
        this.name = name;
    }
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    public void outPutResult(){
        System.out.println(name+"\n"+loader.getResource("classpath:a.txt").getFilename());
    }
}
