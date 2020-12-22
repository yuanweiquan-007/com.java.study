package com.java.study.data.structure;

import lombok.ToString;

/**
 * 节点信息
 */
@ToString
public class Node {
    int data;//数据内容，暂时以数字为例
    Node leftNode;//左节点
    Node rightNode;//右节点
    Boolean isDeleted = Boolean.FALSE;//是否删除

    /**
     * 构造函数
     *
     * @param data
     */
    public Node(int data) {
        this.data = data;
    }

}

