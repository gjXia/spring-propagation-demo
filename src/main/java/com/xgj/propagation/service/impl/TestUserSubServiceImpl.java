package com.xgj.propagation.service.impl;

import com.xgj.propagation.mapper.TestUserMapper;
import com.xgj.propagation.model.TestUser;
import com.xgj.propagation.service.TestUserSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gjXia
 * @date 2023/2/21 15:19
 */
@Service
public class TestUserSubServiceImpl implements TestUserSubService {

    @Autowired
    private TestUserMapper testUserMapper;

    @Override
    public void notTransaction(int divisor) {
        TestUser userB = new TestUser(2, "李四", 25, "无事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredAdd(int divisor) {
        TestUser userB = new TestUser("王五", 18, "默认事务新增");
        testUserMapper.insert(userB);

        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void required(int subDivisor) {
        TestUser userB = new TestUser(2, "李四", 25, "默认事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / subDivisor);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
    public void supports(int subDivisor) {
        TestUser userB = new TestUser(2, "李四", 25, "SUPPORTS事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / subDivisor);
    }

    @Override
    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = Exception.class)
    public void mandatory(int subDivisor) {
        TestUser userB = new TestUser(2, "李四", 25, "MANDATORY事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / subDivisor);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void requiresNew(int subDivisor) {
        TestUser userB = new TestUser(2, "李四", 25, "REQUIRES_NEW事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / subDivisor);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, rollbackFor = Exception.class)
    public void notSupported(int subDivisor) {
        TestUser userB = new TestUser(2, "李四", 25, "NOT_SUPPORTED事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / subDivisor);
    }

    @Override
    @Transactional(propagation = Propagation.NEVER, rollbackFor = Exception.class)
    public void never(int subDivisor) {
        TestUser userB = new TestUser(2, "李四", 25, "NEVER事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / subDivisor);
    }

    @Override
    @Transactional(propagation = Propagation.NESTED, rollbackFor = Exception.class)
    public void nested(int subDivisor) {
        TestUser userB = new TestUser(2, "李四", 25, "NESTED事务更新");
        testUserMapper.updateById(userB);

        System.out.println(1 / subDivisor);
    }
}
