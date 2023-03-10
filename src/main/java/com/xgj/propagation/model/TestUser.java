package com.xgj.propagation.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author gjXia
 * @date 2023/2/10 15:55
 */
@TableName("test_user")
public class TestUser implements Serializable {
    private static final long serialVersionUID = -5203773327358932402L;

    /**
     * 指定自增策略
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private Integer age;

    private String remake;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public TestUser() {
    }

    public TestUser(String name, Integer age, String remake) {
        this.name = name;
        this.age = age;
        this.remake = remake;
    }

    public TestUser(Integer id, String name, Integer age, String remake) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remake = remake;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", remake='" + remake + '\'' +
                '}';
    }
}
