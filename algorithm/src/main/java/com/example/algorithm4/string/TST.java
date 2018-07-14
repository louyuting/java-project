package com.example.algorithm4.string;

/**
 * 三向单词查找树的实现
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/17
 */
public class TST<Value> {
    /**
     * 根节点
     */
    private Node root;

    /**
     * 树的结点，可见域仅仅在于类内部
     */
    private class Node{
        /**
         * 当前结点代表的字符
         */
        char c;
        /**
         * 当前结点的左、右、中链接
         */
        Node left, mid, right;
        /**
         * 当前结点代表的键的值
         */
        Value value;
    }

    public Value get(String key){
        Node node = get(root, key, 0);
        if (node == null){
            return null;
        }else {
            return node.value;
        }
    }

    /**
     *
     * @param x
     * @param key
     * @param d
     * @return 如果key为null返回null ，否则返回查询到的结点。
     */
    private Node get(Node x, String key, int d){
        if(x == null){
            return null;
        }
        char c = key.charAt(d);
        if(c < x.c){
            return get(x.left, key, d);
        } else if (c > x.c){
            return get(x.right, key, d);
        } else if (d < key.length()-1){
            return get(x.mid, key, d+1);
        } else {
            return x;
        }
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }


    private Node put(Node x, String key, Value val, int d) {
        char c = key.charAt(d);
        if (x == null) {
           x = new Node();
           x.c = c;
        }
        if (c < x.c) {
           x.left  = put(x.left,  key, val, d);
        } else if (c > x.c) {
           x.right = put(x.right, key, val, d);
        } else if (d < key.length() - 1){
           x.mid   = put(x.mid, key, val, d+1);
        } else {
           x.value = val;
        }
        return x;
    }
}
