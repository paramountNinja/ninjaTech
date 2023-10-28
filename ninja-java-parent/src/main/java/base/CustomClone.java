package base;

import org.springframework.beans.BeanUtils;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/10/14
 */
public class CustomClone {
    public static void main(String[] args) {
        User user1 = new User("zhangsan");
        user1.setUserInfo(new UserInfo("1", "上海"));
        User user2 = new User();
        //浅拷贝
        BeanUtils.copyProperties(user1, user2);
        System.out.println(user1);
        System.out.println(user2);
        user2.setName("lisi");
        user2.getUserInfo().setAddress("北京");
        System.out.println(user1);
        System.out.println(user2);
    }

}

class User {
    String name;

    UserInfo userInfo;

    public User() {

    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", userInfo=").append(userInfo.id).append(" ").append(userInfo.address);
        sb.append('}');
        return sb.toString();
    }
}

class UserInfo {
    String id;
    String address;


    public UserInfo(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
