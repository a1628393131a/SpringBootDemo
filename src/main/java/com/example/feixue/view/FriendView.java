package com.example.feixue.view;

import com.example.feixue.bean.Friend;
import com.example.feixue.bean.FriendGroup;
import com.example.feixue.bean.User;
import com.example.feixue.controller.friend.FriendController;
import com.example.feixue.controller.ridsGetSet.RidsGetSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * 需求号码：
 * 需求名称：
 * 功能描述：好友视图
 *
 * @author 创建人 zrkwangye
 * @version 1.0
 * @Date 创建时间 2020/5/30 18:59
 */
@Controller
@RequestMapping(value = "/friendView")
public class FriendView {

    @Autowired
    private FriendController friendController;
    @Autowired
    private RidsGetSet ridsGetSet;

    @RequestMapping(value = "/getInFriendList")
    public String getIndex(ModelMap model){
        User user = ridsGetSet.getUser();
        List<FriendGroup> friendGroupList = friendController.getFriendGroup(user.getUserid());
        List<Friend> friendList = new ArrayList<>();
        List<User> friendUserList = new ArrayList<>();
        for (FriendGroup friendGroup:friendGroupList){
            List<Friend> friends = friendController.getFriendList(friendGroup.getGroupid());
            for (Friend friend:friends){
                User friendUser = friendController.getUserList(friend.getFriendid());
                friendUserList.add(friendUser);
            }
            friendList.addAll(friends);
        }
        model.addAttribute("user",user);
        model.addAttribute("friendList",friendList);
        model.addAttribute("friendGroupList",friendGroupList);
        model.addAttribute("friendUserList",friendUserList);
        return "friend";
    }

    @RequestMapping(value = "/addFriendGroup")
    public String setInfo(ModelMap model, String name){
        User user = ridsGetSet.getUser();
        friendController.addFriendFroup(name,user.getUserid());
        return "friendIndex";
    }

    @RequestMapping(value = "/deleteFriend")
    public String deleteFriend(ModelMap model, String userid, String groupid){
        friendController.deleteFriend(userid, groupid);
        return "friendIndex";
    }
}
