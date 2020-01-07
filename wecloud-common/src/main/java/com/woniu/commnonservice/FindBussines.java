package com.woniu.commnonservice;

import com.woniu.entity.Bussiness;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "woniu58-business")
public interface FindBussines {
    @GetMapping("/a/b")
    Bussiness findbuss(@RequestParam("account") String account);
}
