package com.springbootmybatis.service.monitor;

import org.springframework.stereotype.Service;

/**
 * Created by beike on 2017/3/9.
 */
@Service
public class StatusService {
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
