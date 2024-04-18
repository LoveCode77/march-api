package com.xiong.back.controller;

import com.xiong.back.entity.March;
import com.xiong.back.mapper.MarchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class demo {
    @Autowired
    private MarchMapper dataMapper;
    @RequestMapping("test")
    public String test(){
        return "hello";
    }
    @GetMapping("all")
    public List getAllData(){
        List<March> data = dataMapper.selectList(null);

        for (March datum : data) {
            if(datum.getPlace().equals(null)){
                data.remove(datum);
            }
        }
        return data;
    }
}
