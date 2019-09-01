package com.tck.imservertrain.service.impl;

import com.tck.imservertrain.netty.ChatMessage;
import com.tck.imservertrain.pojo.ChatMsg;
import com.tck.imservertrain.pojo.Users;
import com.tck.imservertrain.pojo.vo.FriendRequestVO;
import com.tck.imservertrain.pojo.vo.MyFriendsVO;
import com.tck.imservertrain.repository.UsersRepository;
import com.tck.imservertrain.service.UserService;
import org.apache.catalina.User;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * description:</br>
 * created on: 2019/8/30 8:40</br>
 *
 * @author tck
 * @version 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private Sid sid;

    @Override
    public boolean queryUsernameIsExist(String username) {
        Users user = new Users();
        user.setUsername(username);
        Example<Users> usersExample = Example.of(user);
        Optional<Users> result = usersRepository.findOne(usersExample);
        return result.isPresent();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserForLogin(String username, String pwd) {
        Users user = new Users();
        user.setUsername(username);
        user.setPassword(pwd);
        Example<Users> usersExample = Example.of(user);
        Optional<Users> result = usersRepository.findOne(usersExample);
        return result.get();
    }

    @Override
    public Users saveUser(Users user) {
        String nextShort = sid.nextShort();
        user.setQrcode("");
        user.setId(nextShort);
        return usersRepository.save(user);
    }

    @Override
    public Users updateUserInfo(Users user) {
        return null;
    }

    @Override
    public Integer preconditionSearchFriends(String myUserId, String friendUsername) {
        return null;
    }

    @Override
    public Users queryUserInfoByUsername(String username) {
        return null;
    }

    @Override
    public void sendFriendRequest(String myUserId, String friendUsername) {

    }

    @Override
    public List<FriendRequestVO> queryFriendRequestList(String acceptUserId) {
        return null;
    }

    @Override
    public void deleteFriendRequest(String sendUserId, String acceptUserId) {

    }

    @Override
    public void passFriendRequest(String sendUserId, String acceptUserId) {

    }

    @Override
    public List<MyFriendsVO> queryMyFriends(String userId) {
        return null;
    }

    @Override
    public String saveMsg(ChatMessage chatMsg) {
        return null;
    }

    @Override
    public void updateMsgSigned(List<String> msgIdList) {

    }

    @Override
    public List<ChatMsg> getUnReadMsgList(String acceptUserId) {
        return null;
    }
}
