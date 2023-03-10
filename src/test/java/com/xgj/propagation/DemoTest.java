package com.xgj.propagation;

import com.xgj.propagation.service.TestUserService;
import com.xgj.propagation.service.impl.TestFailureService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author gjXia
 * @date 2023/2/10 16:09
 */
@SpringBootTest
public class DemoTest {

    @Autowired
    private TestUserService userService;

    @Autowired
    private TestFailureService failureService;

    @Test
    public void allNotTransaction() {
        // 外层、内层均不开启事务
        userService.allNotTransaction(1,0);
    }

    @Test
    public void onlySubTransaction() {
        // 外层无事务、内层开启默认事务
        userService.onlySubTransaction(0,0);
    }

    @Test
    public void onlySubNotTransaction() {
        // 外层开启默认事务、内层无设置事务
        userService.onlySubNotTransaction(0, 1);
    }

    @Test
    public void allRequired() {
        // 外层、内层均设置默认事务
        userService.allRequired(0, -1);
    }

    @Test
    public void onlySubSupports() {
        // 外层无事务、内层设置SUPPORTS事务
        userService.onlySubSupports(1, 0);
    }

    @Test
    public void onlySubMandatory() {
        // 外层无事务、内层设置MANDATORY事务
        userService.onlySubMandatory(1, 0);
    }

    @Test
    public void onlySubRequiresNew() {
        // 外层无事务、内层设置REQUIRES_NEW事务
        userService.onlySubRequiresNew(1, 0);
    }

    @Test
    public void onlySubNotSupported() {
        // 外层无事务、内层设置NOT_SUPPORTED事务
        userService.onlySubNotSupported(1, 0);
    }

    @Test
    public void onlySubNever() {
        // 外层无事务、内层设置NEVER事务
        userService.onlySubNever(1, 0);
    }

    @Test
    public void onlySubNested() {
        // 外层无事务、内层设置NESTED事务
        userService.onlySubNested(1, 0);
    }

    @Test
    public void allRequiredSubTry() {
        // 外层、内层均设置默认事务（捕获内层异常）
        userService.allRequiredSubTry(1, 0);
    }

    @Test
    public void requiredSupports() {
        // 外层设置默认事务、内层设置SUPPORTS事务
        userService.requiredSupports(0, 1);
    }

    @Test
    public void requiredMandatory() {
        // 外层设置默认事务、内层设置MANDATORY事务
        userService.requiredMandatory(1, 0);
    }

    @Test
    public void requiredRequiresNew() {
        // 外层设置默认事务、内层设置REQUIRES_NEW事务
        userService.requiredRequiresNew(0, 1);
    }

    @Test
    public void requiredNotSupported() {
        // 外层设置默认事务、内层设置NOT_SUPPORTED事务
        userService.requiredNotSupported(0, 0);
    }

    @Test
    public void requiredNever() {
        // 外层设置默认事务、内层设置NEVER事务
        userService.requiredNever(1, 0);
    }

    @Test
    public void requiredNested() {
        // 外层设置默认事务、内层设置NESTED事务
        userService.requiredNested(0, 1);
    }

    @Test
    public void requiredNestedSubTry() {
        // 外层设置默认事务、内层设置NESTED事务
        userService.requiredNestedSubTry(1, 0);
    }

    // -------------------- 测试事务失效场景 -----------------------

    @Test
    public void testFailureDefault() {
        // 访问权限问题-default
        userService.testFailureDefault();
    }

    @Test
    public void testFailureProtected() {
        // 访问权限问题-protected
        userService.testFailureProtected();
    }

    @Test
    public void testFailureInternal() {
        // 同一类中方法调用
        userService.testFailureInternal();
    }

    @Test
    public void testFailureTry() {
        // 异常被try-catch捕获
        userService.testFailureTry();
    }

    @Test
    public void testFailureOtherException() throws Exception {
        // 错误的标注异常类型
        userService.testFailureOtherException();
    }

}
