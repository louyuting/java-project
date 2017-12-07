package com.example.algorithm4.graphs;

import java.util.Stack;

/**
 * 有向图环的检测：DFS算法
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/7
 */
public class DirectedCycle {
    /**
     * 从起点开始DFS访问过的路径标记
     */
    private boolean[] marked;
    /**
     * 从起点到一个顶点v的已知路径上的最后一个顶点
     */
    private int[] edgeTo;
    /**
     * 有向环中的所有顶点
     */
    private Stack<Integer> cycle;
    /**
     * 递归调用栈上的所有顶点
     */
    private boolean[] onStack;

    /**
     * 构造器
     *
     * @param digraph 有向图
     */
    public DirectedCycle(Digraph digraph) {
        this.marked = new boolean[digraph.V()];
        this.edgeTo = new int[digraph.V()];
        this.onStack = new boolean[digraph.V()];
        for (int v=0; v<digraph.V(); v++) {
            if( !marked[v] ) {
                dfs(digraph, v);
            }
        }
    }

    /**
     * 从节点v 开始有向图的DFS
     *
     * @param digraph 有向图
     * @param v 结点
     */
    private void dfs(Digraph digraph, int v){
        // 标记当前结点在堆栈路径上
        this.onStack[v] = true;
        this.marked[v] = true;
        for (int w : digraph.adj(v)){
            // 如果当前图已经有环就直接返回
            if (this.hasCycle()){
                return;
            } else if(!this.marked[w]){
                // 如果当前结点没有被标记过，递归dfs
                edgeTo[w] = v;
                dfs(digraph, w);
            } else if (onStack[w]){
                // 如果当前结点被标记过来了，而且在已经访问过得堆栈上，存在环
                cycle = new Stack<>();
                for(int x = v; x!=w; x = this.edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        // 递归回溯时，当前结点重置为不在环的堆栈上。
        this.onStack[v] = false;
    }

    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }
}