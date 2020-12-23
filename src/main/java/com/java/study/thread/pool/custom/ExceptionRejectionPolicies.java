package com.java.study.thread.pool.custom;

/**
 * 拒绝策略，直接抛出异常
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 3:41 下午
 */
public class ExceptionRejectionPolicies implements ThreadPoolRejectionPolicies {
    @Override
    public void reject(ThreadPoolTask threadPoolTask) throws RejectionPoliciesException {
        throw new RejectionPoliciesException("拒绝策略异常");
    }
}
