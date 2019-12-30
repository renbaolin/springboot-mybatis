package com.springbootmybatis.service.monitor;

import org.springframework.beans.BeansException;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by beike on 2017/3/9.
 */
@ConfigurationProperties(prefix = "endpoints.status", ignoreInvalidFields = false)
public class StatusEndPoint extends AbstractEndpoint<String> implements ApplicationContextAware{
    ApplicationContext context;

    public StatusEndPoint(){
        super("status");
    }

    @Override
    public String invoke(){
        StatusService statusService = context.getBean(StatusService.class);
        return "Status is:"+statusService.getStatus();
    }

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException{
        this.context = arg0;
    }
}
