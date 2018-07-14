package com.example.algorithm4.graphs.shortestpath;

/**
 * 加权有向图的边的数据结构
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2018/1/10
 */
public class DirectedEdge {
    /**
     * 边的起点
     */
    private final int v;
    /**
     * 边的终点
     */
    private final int w;
    /**
     * 边的权重
     */
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的起点
     * @return
     */
    public int from(){
        return v;
    }

    public int to(){
        return w;
    }

    public double weight(){
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }
}
