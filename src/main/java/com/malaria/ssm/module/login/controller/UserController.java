package com.malaria.ssm.module.login.controller;


import com.malaria.ssm.module.login.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;


/**
 * Created by R丶sJournal on 2016/11/6.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/exitToUserUI")
    public String exitToUserUI() throws Exception {
        return "common/exitedTip";
    }

    @RequestMapping(value = "/loginView", method = RequestMethod.GET)
    public String loginView(String errorMessage,String userCount) throws Exception {
        System.out.println(errorMessage);
        System.out.println(userCount);
        return "common/login";
    }

    @RequestMapping(value = "/registerView", method = RequestMethod.GET)
    public String registerView() throws Exception {
        return "common/register";
    }

    @RequestMapping(value = "/{authorizationStatus}")
    public String getAdminView(@PathVariable("authorizationStatus") int authorizationStatus) throws Exception {
        return "common/AdminUI";
    }

//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ModelAndView userLogin(User user) throws Exception {
//        User userChecked = userService.checkLogin(user.getUseremail(), user.getUserpassword());
//        ModelAndView modelAndView = new ModelAndView();
//        if (null != userChecked) {
//            modelAndView.addObject("user", user);
//            //系统管理员页面
//            if (userChecked.getPerissioninformation().equals("3")) {
//                modelAndView.setViewName("common/systemAdminUI");
//            }
//            //管理员
//            if (userChecked.getPerissioninformation().equals("2")) {
//                modelAndView.setViewName("common/AdminUI");
//            }
//            return modelAndView;
//        } else {
//            modelAndView.addObject("errorMessage", "用户名或密码错误");
//            if (null != user.getUseremail() && !"".equals(user.getUseremail())) {
//                modelAndView.addObject("userCount", user.getUseremail());
//            }
//            modelAndView.setViewName("redirect:/user/loginView");
//            return modelAndView;
//        }
//    }
//
//    @RequestMapping("/register")
//    public ModelAndView userRegister(User user) throws Exception {
//        boolean registerType = userService.checkRegister(user.getUseremail());
//        ModelAndView modelAndView = new ModelAndView();
//        if (registerType) {
//            userService.saveRegister(user);
//            modelAndView.setViewName("common/login");
//        }
//        return modelAndView;
//    }
//
//    @RequestMapping("/showCheckUser")
//    public ModelAndView showCheckUser() throws Exception {
//        List<User> User = userService.selectCheckUser();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.addObject("checkUser", User);
//        modelAndView.setViewName("common/checkUser");
//        return modelAndView;
//    }

    @RequestMapping("/checkUserAgree")
    public ModelAndView checkUserAgree() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

}
