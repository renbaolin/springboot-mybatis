package com.springbootmybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootmybatis.service.monitor.StatusEndPoint;
import com.springbootmybatis.service.monitor.StatusService;

/**
 * Created by beike on 2017/3/9.
 */
@RestController
@RequestMapping(value = "/monitor")
public class MonitorController {
    @Autowired
    StatusService statusService;

    @Bean
    public Endpoint<String> status(){
        Endpoint<String> status = new StatusEndPoint();
        return status;
    }
    @RequestMapping(value = "/change_status")
    String changeStatus(String status){
        statusService.setStatus(status);
        return "OK";
    }
}
