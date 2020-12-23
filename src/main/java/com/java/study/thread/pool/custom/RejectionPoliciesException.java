package com.java.study.thread.pool.custom;

/**
 * 拒绝策略异常
 *
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/22 3:43 下午
 */
public class RejectionPoliciesException extends RuntimeException {

    public RejectionPoliciesException(String message) {
        super(message);
    }
}
