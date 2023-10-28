package com.ninja.dto;

/**
 * @Desc
 * @Author ninja
 * @Date Created on 2023/10/25
 */
public class SchoolInfo {

    private String address;

    private String name;

    private String age; //类比业务上maxOfUser


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
