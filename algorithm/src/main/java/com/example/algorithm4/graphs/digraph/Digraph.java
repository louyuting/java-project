package com.example.algorithm4.graphs.digraph;

import edu.princeton.cs.algs4.Bag;

/**
 * 有向图的实现
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/7
 */
public class Digraph {
    /**
     * 节点的总个数
     */
    private final int V;
    /**
     * 边的总个数
     */
    private int E;
    /**
     * 有向图的邻接表表示法
     */
    private Bag<Integer>[] adj;

    /**
     * 创建一个含有V个节点，但是0条边的有向图
     * @param V
     */
    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[])new Bag[V];
        for (int i=0; i<this.V; i++){
            adj[V] = new Bag<>();
        }
    }


    public int E(){
        return this.E;
    }


    public int V(){
        return this.V;
    }

    /**
     * 添加一条 v-->w 的边
     * @param v 有向边的源在数组中的标识符
     * @param w 有向边的终在数组中的标识符
     */
    public void addEdge(int v, int w){
        adj[v].add(w);
        this.E++;
    }

    /**
     * 节点v 的所有出度的终顶点
     * @param v 节点v 的标识符
     * @return
     */
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    /**
     * 此有向图反转之后的副本
     * @return
     */
    public Digraph reverse(){
        Digraph reverse = new Digraph(this.V);
        for(int i=0 ;i<this.V; i++){
            for (int w : adj[i]){
                //边反转
                reverse.addEdge(w, i);
            }
        }
        return reverse;
    }
}
