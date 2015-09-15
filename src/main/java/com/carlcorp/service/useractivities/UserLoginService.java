package com.carlcorp.service.useractivities;

import com.carlcorp.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class UserLoginService {

    private Map<String, User> userMapFromDB = mockUserMap();

    //Mock getting user datas from DB/Session
    private static Map<String, User> mockUserMap(){
        Map<String, User> userMap = new HashMap<String, User>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("Carl-" + i);
            user.setId(i);
            userMap.put(user.getName(), user);
        }
        return userMap;
    }

    public User verifyCurrentUser(User currentUser) {

        Map<String, User> userMap = this.userMapFromDB;

        if (userMap.containsKey(currentUser.getName())) {
            return userMap.get(currentUser.getName());
        } else {
            return null;
        }
    }


}
