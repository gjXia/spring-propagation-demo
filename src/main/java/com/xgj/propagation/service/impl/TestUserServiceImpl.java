package com.xgj.propagation.service.impl;

import com.xgj.propagation.mapper.TestUserMapper;
import com.xgj.propagation.model.TestUser;
import com.xgj.propagation.service.TestUserService;
import com.xgj.propagation.service.TestUserSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

/**
 * @author gjXia
 * @date 2023/2/21 15:11
 */
@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private TestUserSubService testUserSubService;

    @Autowired
    private TestFailureService failureService;

    @Override
    public void allNotTransaction(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 27, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.notTransaction(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    public void onlySubTransaction(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 27, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.required(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void onlySubNotTransaction(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.notTransaction(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allRequired(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.required(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    public void onlySubSupports(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.supports(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    public void onlySubMandatory(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.mandatory(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    public void onlySubRequiresNew(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.requiresNew(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    public void onlySubNotSupported(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.notSupported(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    public void onlySubNever(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.never(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    public void onlySubNested(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "无事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.nested(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void allRequiredSubTry(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        try {
            testUserSubService.required(subDivisor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredSupports(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.supports(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredMandatory(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.mandatory(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredRequiresNew(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.requiresNew(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredNotSupported(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.notSupported(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredNever(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.never(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredNested(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        testUserSubService.nested(subDivisor);
        System.out.println(1 / divisor);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void requiredNestedSubTry(int divisor, int subDivisor) {
        TestUser userA = new TestUser(1, "张三", 30, "默认事务更新");
        testUserMapper.updateById(userA);

        try {
            testUserSubService.nested(subDivisor);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(1 / divisor);
    }

    @Override
    public void testFailureDefault() {
        failureService.testFailureDefault();
    }

    @Override
    public void testFailureProtected() {
        failureService.testFailureProtected();
    }

    @Override
    public void testFailureInternal() {
        TestUser userA = new TestUser(1, "张三", 30, "同一个类调用方法A");
        testUserMapper.updateById(userA);

        testFailureInternalSub();
    }

    @Transactional(rollbackFor = Exception.class)
    public void testFailureInternalSub() {
        TestUser userB = new TestUser(2, "李四", 25, "同一个类调用方法B");
        testUserMapper.updateById(userB);

        System.out.println(1 / 0);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testFailureTry() {
        try {
            TestUser userA = new TestUser(1, "张三", 30, "捕获异常");
            testUserMapper.updateById(userA);

            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional(rollbackFor = IOException.class)
    public void testFailureOtherException() throws Exception {
        TestUser userA = new TestUser(1, "张三", 30, "不匹配的异常类型");
        int rows = testUserMapper.updateById(userA);

        if (rows > 0) {
            throw new Exception("不匹配的异常类型");
        }
    }
}
