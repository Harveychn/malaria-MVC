package com.malaria.ssm.module.login.service.impl;

import com.malaria.ssm.module.login.service.UserService;
import org.springframework.stereotype.Service;


/**
 * Created by R丶sJournal on 2016/11/6.
 */
//@Service("UserService")
@Service
public class UserServiceImpl implements UserService {
//    @Autowired
//    UserMapper userMapper;
//    @Resource
//    private UserMapper userMapper;
//    @Resource
//    private UserExpandMapper userExpandMapper;
//
//    //登陆方法的实现，从jsp页面获取useremail与password与user中的password比较
//    public User checkLogin(String userEmail, String password) throws Exception {
//        User user = userMapper.selectByPrimaryKey(userEmail);
//        if (null == user) {
//            return null;
//        }
//        //注册被拒绝
//        if (!user.getReviewstatus().equals("1")) {
//            //未审核
//            if (user.getUserpassword().equals(password) && !user.getReviewstatus().equals("0")) {
//                return user;
//            }
//            return null;
//        }
//        return null;
//
//    }
//
////    @Autowired
////    UserMapper UserMapper;
////    @Autowired
////    UserExpandMapper userExpandMapper;
//
//    //判断是否已被注册方法的实现，从jsp页面获取useremail与user中的usermail比较
//    public boolean checkRegister(String userEmail) throws Exception {
//        User User = userExpandMapper.selectByPrimaryKeyInUser(userEmail);
//        if (User == null)
//            return true;
//        else
//            return false;
//    }
//
//    //注册方法的实现
//    public void saveRegister(User user) throws Exception {
//        Date date = new Date();
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String time = df.format(date);
//        Date d = df.parse(time);
//        user.setReviewstatus("0");
//        user.setPerissioninformation("0");
//        user.setJoindate(d);
//        userMapper.insert(user);
//    }
//
//    //审核页面获取user表中的待审核用户信息
//    public List<User> selectCheckUser() throws Exception {
////        List<User> User = userExpandMapper.selectCheckUser();
////        return User;
//        return userExpandMapper.selectCheckUser();
//    }
//
//    //更新check_user中的reviewStatus和permissionInformation
//    public void updateUser(String userEmail) throws Exception {
//        userExpandMapper.updateCheckUser(userEmail);
//    }
}
