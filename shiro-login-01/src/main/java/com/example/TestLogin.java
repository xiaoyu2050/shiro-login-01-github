package com.example;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class TestLogin {
    public static void main(String[] args) {
        //1.获取securityManager对象
        IniSecurityManagerFactory factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //2.获取subject对象
        Subject subject = SecurityUtils.getSubject();
//        AuthenticationToken token = new UsernamePasswordToken("lisi", "l4", true);
        AuthenticationToken token = new UsernamePasswordToken("zhangsan", "z3", true);
        try {
            subject.login(token);
            System.out.println("登录成功!");
            boolean hasRole = subject.hasRole("role1");
            System.out.println("是否拥有此角色:" + hasRole);
            boolean permitted = subject.isPermitted("user:insert");
            System.out.println("是否拥有此权限:" + permitted);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户不存在");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        } catch (AuthenticationException e) {
            System.out.println("登录失败!" + e.getMessage());
        }
    }
}
