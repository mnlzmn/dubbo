package com.dubbo.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.dubbo.api.DemoService;

/**
 * Created by Administrator on 2018/8/9.
 */
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public int demo() {
        System.out.println("/******************/消费成功");
        return 1;
    }
}
