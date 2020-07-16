package com.neusiri.model;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * @author zhangdj
 * @date 2020-07-02 13:40
 */
@Document(indexName = "index_test",type = "user")
public class UserDO implements Serializable {

    private Long id;

    private String name;

    private String userAddress;

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserDO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public UserDO(Long id, String name, String userAddress) {
        this.id = id;
        this.name = name;
        this.userAddress = userAddress;
    }

    public UserDO() {
    }
}
