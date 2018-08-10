package com.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dubbo.api.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2018/8/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DemoTest {
    @Reference
    private DemoService demoService;

    @Test
    public void test(){
        int demo = demoService.demo();
        System.out.println(demo);
    }

}
