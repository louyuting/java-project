package com.example.demo.test.aware;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * 测试Spring 的Aware
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/10/1
 */
@Service
public class AwareService implements BeanNameAware, ResourceLoaderAware{

    private String beanName;
    private ResourceLoader loader;


    public void outputResult(){
        System.out.println("Bean的名称为：" + beanName);

        Resource resource =
                loader.getResource("classpath:text.properties");
        try{
            System.out.println("ResourceLoader加载的文件内容为: " + IOUtils.toString(resource.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.loader = resourceLoader;
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
    }
}
