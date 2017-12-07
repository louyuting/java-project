package com.example.algorithm4.graphs;

import java.util.Stack;

/**
 * <p>使用深度优先搜索查找图中的路径</p>
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/12/1
 */
public class DepthFirstPaths {

    private boolean[] marked;//标记这个顶点调用过DFS嘛？
    private int[] edgeTo;//从起点到一个顶点的已知路劲上的最后一个顶点
    private final int s;//起点

    public DepthFirstPaths(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.s = s;
        dfs(graph, s);
    }

    /**
     * 图graph 从顶点 V 开始进行DFS
     * @param graph 图
     * @param v 起始顶点
     */
    private void dfs(Graph graph, int v){
        marked[v] = true;
        for(int w : graph.adj(v)){
            if( !marked[w] ){
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v){
        if( !hasPathTo(v) ){
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for(int x=v; x!=s; x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }

}
