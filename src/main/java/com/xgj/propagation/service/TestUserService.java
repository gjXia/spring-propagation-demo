package com.xgj.propagation.service;

/**
 * @author gjXia
 * @date 2023/2/21 15:10
 */
public interface TestUserService {

    /**
     * 外层、内层均无事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void allNotTransaction(int divisor, int subDivisor);

    /**
     * 外层无事务、内层开启默认事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubTransaction(int divisor, int subDivisor);

    /**
     * 外层开启默认事务、内层无设置事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubNotTransaction(int divisor, int subDivisor);

    /**
     * 外层、内层均设置默认事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void allRequired(int divisor, int subDivisor);

    /**
     * 外层无事务、内层设置SUPPORTS事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubSupports(int divisor, int subDivisor);

    /**
     * 外层无事务、内层设置MANDATORY事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubMandatory(int divisor, int subDivisor);

    /**
     * 外层无事务、内层设置REQUIRES_NEW事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubRequiresNew(int divisor, int subDivisor);

    /**
     * 外层无事务、内层设置NOT_SUPPORTED事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubNotSupported(int divisor, int subDivisor);

    /**
     * 外层无事务、内层设置NEVER事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubNever(int divisor, int subDivisor);

    /**
     * 外层无事务、内层设置NESTED事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void onlySubNested(int divisor, int subDivisor);

    /**
     * 外层、内层均设置默认事务（捕获内层异常）
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void allRequiredSubTry(int divisor, int subDivisor);

    /**
     * 外层设置默认事务、内层设置SUPPORTS事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void requiredSupports(int divisor, int subDivisor);

    /**
     * 外层设置默认事务、内层设置MANDATORY事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void requiredMandatory(int divisor, int subDivisor);

    /**
     * 外层设置默认事务、内层设置REQUIRES_NEW事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void requiredRequiresNew(int divisor, int subDivisor);

    /**
     * 外层设置默认事务、内层设置NOT_SUPPORTED事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void requiredNotSupported(int divisor, int subDivisor);

    /**
     * 外层设置默认事务、内层设置NEVER事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void requiredNever(int divisor, int subDivisor);

    /**
     * 外层设置默认事务、内层设置NESTED事务
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void requiredNested(int divisor, int subDivisor);

    /**
     * 外层设置默认事务、内层设置NESTED事务（捕获内层异常）
     *
     * @param divisor    除数-外层
     * @param subDivisor 除数-内层
     */
    void requiredNestedSubTry(int divisor, int subDivisor);


    // -------------------- 测试事务失效场景 -----------------------

    /**
     * 测试事务失效场景-访问权限问题-default (只有public方法会生效)
     */
    void testFailureDefault();

    /**
     * 测试事务失效场景-访问权限问题-protected (只有public方法会生效)
     */
    void testFailureProtected();

    /**
     * 测试事务失效场景-同一类中方法调用
     */
    void testFailureInternal();

    /**
     * 测试事务失效场景-异常被try-catch捕获
     */
    void testFailureTry();

    /**
     * 测试事务失效场景-错误的标注异常类型
     *
     * @throws Exception 异常
     */
    void testFailureOtherException() throws Exception;
}
