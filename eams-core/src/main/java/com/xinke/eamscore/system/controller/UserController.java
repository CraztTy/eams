package com.xinke.eamscore.system.controller;

import com.xinke.eamscore.base.BaseController.BaseController;
import com.xinke.eamscore.base.Constants;
import com.xinke.eamscore.base.Result;
import com.xinke.eamscore.enums.BaseEnums;
import com.xinke.eamscore.system.entity.User;
import com.xinke.eamscore.system.mapper.UserMapper;
import com.xinke.eamscore.utils.Dates;
import com.xinke.eamscore.utils.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/sys/user")
@RestController
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users=userMapper.getAll();
        return users;
    }

    @RequestMapping("/getUser")
    public User getUser(Long id) {
        User user=userMapper.getOne(id);
        return user;
    }

    @RequestMapping("/add")
    public void save(User user) {
        userMapper.insert(user);
    }

    @RequestMapping(value="update")
    public void update(User user) {
        userMapper.update(user);
    }

    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userMapper.delete(id);
    }

    private static List<User> userList = new ArrayList<>();

    // 先静态模拟数据
    static {
        User user1 = new User();
        user1.setUserId(1L);
        user1.setUsername("lufei");
        user1.setNickname("蒙奇D路飞");
        user1.setBirthday(Dates.parseDate("2000-05-05"));
        user1.setSex(Constants.Sex.MALE);
        user1.setEnabled(Constants.Flag.YES);
        userList.add(user1);

        User user2 = new User();
        user2.setUserId(2L);
        user2.setUsername("nami");
        user2.setNickname("娜美");
        user2.setBirthday(Dates.parseDate("2000/7/3"));
        user2.setSex(Constants.Sex.FEMALE);
        user2.setEnabled(Constants.Flag.YES);
        userList.add(user2);
    }

    @RequestMapping("/queryAll")
    public Result queryAll(){
        return Results.successWithData(userList, BaseEnums.SUCCESS.code(), BaseEnums.SUCCESS.desc());
    }

    @RequestMapping("/queryOne/{userId}")
    public Result queryOne(@PathVariable Long userId){
        User user = null;
        for(User u : userList){
            if(u.getUserId().longValue() == userId){
                user = u;
            }
        }
        return Results.successWithData(user);
    }
}
