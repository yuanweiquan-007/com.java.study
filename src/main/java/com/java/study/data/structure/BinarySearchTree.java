package com.java.study.data.structure;

/**
 * 二叉搜索树
 */
public class BinarySearchTree {

    Node root;//根节点

    /**
     * 查找节点
     *
     * @param key
     * @return
     */
    public Node find(int key) {
        if (emptyRoot()) return null;

        Node current = root;
        Node parentNode = null;
        while (null != current) {
            parentNode = current;
            if (key < parentNode.data) {
                current = parentNode.leftNode;
                if (null == current) {
                    return null;
                }
            } else if (key > parentNode.data) {
                current = parentNode.rightNode;
                if (null == current) {
                    return null;
                }
            } else {
                return current;
            }
        }
        return null;
    }

    /**
     * 插入节点
     *
     * @param data
     * @return
     */
    public boolean insert(int data) {
        if (emptyRoot()) {
            root = new Node(data);
            return true;
        }

        Node current = root;
        Node parentNode = null;
        while (null != current) {
            parentNode = current;
            if (data < current.data) {
                current = parentNode.leftNode;
                if (null == current) {
                    parentNode.leftNode = new Node(data);
                    return true;
                }
            } else {
                current = parentNode.rightNode;
                if (null == current) {
                    parentNode.rightNode = new Node(data);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 查找最大值
     *
     * @return
     */
    public Node findMax() {
        if (emptyRoot()) return new Node(-1);
        Node current = root;
        while (null != current) {
            if (null != current.rightNode) {
                current = current.rightNode;
            } else {
                return current;
            }
        }
        return current;
    }

    /**
     * 查找最小值
     *
     * @return
     */
    public Node findMin() {
        if (emptyRoot()) return new Node(-9999);
        Node current = root;
        while (null != current) {
            if (null != current.leftNode) {
                current = current.leftNode;
            } else {
                return current;
            }
        }
        return current;
    }

    /**
     * 删除
     * 只标记Node的isDeleted属性
     *
     * @param key
     * @return
     */
    public boolean delete(int key) {
        if (emptyRoot()) return false;
        Node current = root;
        Node parentNode = null;
        while (null != current) {
            parentNode = current;
            if (key < current.data) {
                current = current.leftNode;
                if (null == current) {
                    return false;
                }
            } else if (key > current.data) {
                current = current.rightNode;
                if (null == current) {
                    return false;
                }
            } else {
                current.isDeleted = true;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(100);
        tree.insert(1);
        tree.insert(10);
        tree.insert(5);
        tree.insert(8);
        tree.insert(20);
        System.out.println(tree.findMax().data);
        System.out.println(tree.findMin().data);
        System.out.println(tree.delete(5));
        System.out.println(tree.delete(8));
        System.out.println(tree.find(5));

    }

    private boolean emptyRoot() {
        return null == root;
    }

}
