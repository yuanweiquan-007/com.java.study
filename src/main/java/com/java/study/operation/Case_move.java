package com.java.study.operation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author yuanweiquan
 * @version 1.0
 * @date 2020/12/23 4:28 下午
 */
@Slf4j
public class Case_move {

    private static final int COUNT_BITS = Integer.SIZE - 3;//29
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    private static final int RUNNING = -1 << COUNT_BITS;//111
    private static final int SHUTDOWN = 0 << COUNT_BITS;//000
    private static final int STOP = 1 << COUNT_BITS;//001
    private static final int TIDYING = 2 << COUNT_BITS;//010
    private static final int TERMINATED = 3 << COUNT_BITS;//011

    public static void main(String[] args) throws Exception {
        System.out.println("1的二进制：" + Integer.toBinaryString(1));
        System.out.println("-1的二进制：" + Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(-1 << 29));//实际操作时，使用的是补码，因此结果为11100000000000000000000000000000
        System.out.println(Integer.toBinaryString(ctlOf(RUNNING, 0)));
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

}
