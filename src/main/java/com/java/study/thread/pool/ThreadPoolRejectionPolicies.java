package com.java.study.thread.pool;

/**
 * 拒绝策略
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 3:30 下午
 */
public interface ThreadPoolRejectionPolicies {

    void reject(ThreadPoolTask threadPoolTask) throws RejectionPoliciesException;

}
