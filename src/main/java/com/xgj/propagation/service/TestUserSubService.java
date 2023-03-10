package com.xgj.propagation.service;

/**
 * @author gjXia
 * @date 2023/2/21 15:18
 */
public interface TestUserSubService {


    /**
     * 无事务执行
     *
     * @param divisor 除数
     */
    void notTransaction(int divisor);

    /**
     * 以默认事务执行
     *
     * @param divisor 除数
     */
    void requiredAdd(int divisor);

    /**
     * 以默认事务执行
     *
     * @param subDivisor 除数
     */
    void required(int subDivisor);

    /**
     * 以SUPPORTS事务执行
     *
     * @param subDivisor 除数
     */
    void supports(int subDivisor);

    /**
     * 以MANDATORY事务执行
     *
     * @param subDivisor 除数
     */
    void mandatory(int subDivisor);

    /**
     * 以REQUIRES_NEW事务执行
     *
     * @param subDivisor 除数
     */
    void requiresNew(int subDivisor);

    /**
     * 以NOT_SUPPORTED事务执行
     *
     * @param subDivisor 除数
     */
    void notSupported(int subDivisor);

    /**
     * 以NEVER事务执行
     *
     * @param subDivisor 除数
     */
    void never(int subDivisor);

    /**
     * 以NESTED事务执行
     *
     * @param subDivisor 除数
     */
    void nested(int subDivisor);
}
