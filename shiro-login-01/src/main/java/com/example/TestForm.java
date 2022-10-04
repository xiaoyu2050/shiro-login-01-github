package com.example;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TestForm {

    @PostMapping("/test")
    public String test(User user, MultipartFile avatar) {
        System.out.println("测试git提交");
        System.out.println("hello fix commit1");
        System.out.println("hello fix commit2");
        System.out.println("hello fix commit2-hot-fix");
        System.out.println("hello fix commit2-gitee");
        System.out.println("user = " + user);
        System.out.println("avatar = " + avatar.getName());
        return "收到了";
    }

    @Data
    static class  User{
        String username;
        String password;
        String sex;
        List<String> fav;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        LocalDate birthday;
        int id;
    }
}
