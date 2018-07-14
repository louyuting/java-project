package com.example.algorithm4.graphs.shortestpath;

import edu.princeton.cs.algs4.Bag;

/**
 * 加权有向图的数据类型
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/1/12
 */
public class EdgeWeightedDigraph {
    /**
     * 顶点总数
     */
    private final int V;
    /**
     * 边的总数
     */
    private int E;
    /**
     * 邻接表
     */
    private Bag<DirectedEdge>[] adj;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;

        adj = (Bag<DirectedEdge>[])new Bag[V];
        for (int v=0; v<V; v++) {
            adj[v] = new Bag<>();
        }
    }


    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    /**
     * 向加权有向图中添加一条边
     * @param edge
     */
    public void addEdge(DirectedEdge edge) {
        adj[edge.from()].add(edge);
        this.E++;
    }

    /**
     * 获取从顶点v出发的节点
     * @param v
     * @return
     */
    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权有向图的所有的边
     * @return
     * */
    public Iterable<DirectedEdge> edges() {

        Bag<DirectedEdge> bag = new Bag<>();
        for (int v=0; v<V; v++){
            for (DirectedEdge edge : adj[v]) {
                bag.add(edge);
            }
        }

        return bag;
    }
}
