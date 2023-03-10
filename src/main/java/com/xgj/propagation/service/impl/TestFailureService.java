package com.xgj.propagation.service.impl;

import com.xgj.propagation.mapper.TestUserMapper;
import com.xgj.propagation.model.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gjXia
 * @date 2023/2/28 17:03
 */
@Service
public class TestFailureService {

    @Autowired
    private TestUserMapper testUserMapper;

    /**
     * 测试事务失效场景一，访问权限问题 (只有public方法会生效)
     */
    @Transactional(rollbackFor = Exception.class)
    void testFailureDefault() {
        TestUser userA = new TestUser(1, "张三", 30, "default访问权限");
        testUserMapper.updateById(userA);

        System.out.println(1 / 0);
    }

    /**
     * 测试事务失效场景一，访问权限问题 (只有public方法会生效)
     */
    @Transactional(rollbackFor = Exception.class)
    protected void testFailureProtected() {
        TestUser userB = new TestUser(2, "李四", 25, "protected访问权限");
        testUserMapper.updateById(userB);

        System.out.println(1 / 0);
    }

    /**
     * 测试事务失效场景一，访问权限问题 (只有public方法会生效)
     */
    @Transactional(rollbackFor = Exception.class)
    public final void test() {
        TestUser userB = new TestUser(2, "李四", 25, "protected访问权限");
        testUserMapper.updateById(userB);

        System.out.println(1 / 0);
    }
}
