package com.example.algorithm4.graphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 图的基本API以及物理存储：邻接表实现
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/11/29
 */
public class Graph {

    /** 图的顶点数目 */
    private final int V;
    /** 图的边的数目 */
    private int E;
    /** 图的邻接表表示形式， Bag是对链表的一个封装 */
    private Bag<Integer>[] adj;

    /**
     * 创建有V各节点，0条边的无向图
     *
     * @param V 图中的节点数
     */
    public Graph(int V) {
        this.V = V;
        this.E = 0;
        /* 创建邻接表 */
        adj = (Bag<Integer>[])new Bag[V];
        for (int i=0; i<V; i++){
            adj[i] = new Bag<>();
        }
    }

    /**
     * 读取文件里面的数据构造一个图
     *
     * @param in 图的数据源
     */
    public Graph(In in){
        this(in.readInt());//第一行是节点数
        int E = in.readInt();//第二行是边的数量
        for(int i=0; i<E; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);// 连接一条边
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    /**
     * 在节点v 和 节点w之间建立一条边
     *
     * @param v 节点v
     * @param w 节点w
     */
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    /**
     * 返回和节点v相邻的所有节点
     *
     * @param v 节点v
     * @return 与节点v相邻的节点的List
     */
    public Iterable<Integer> adj(int v){
        return adj[v];
    }


}
