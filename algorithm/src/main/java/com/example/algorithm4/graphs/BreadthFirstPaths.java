package com.example.algorithm4.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 使用广度优先搜索查找图中的路径
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/12/3
 */
public class BreadthFirstPaths {

    private boolean[]  marked; // 到达该顶点的最短路径是否已经算出
    private int[]      edgeTo; // 到达该顶点的已知路径上的最后一个顶点。
    private final int  s;      //起点

    /**
     * 构造器
     *
     * @param graph 一个用存储好了的无向图
     * @param s 起点
     */
    public BreadthFirstPaths(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        this.edgeTo = new int[graph.V()];
        this.s = s;
        bfs(graph, s);
    }

    /**
     * BFS
     *
     * @param graph 无向图
     * @param s 图的起点
     */
    private void bfs(Graph graph, int s){
        Queue<Integer> queue = new LinkedList<>();
        marked[s] = true;
        queue.add(s);//起点入队列
        while (!queue.isEmpty()){
            int v = queue.remove();//从队列中删除一个节点
            for(int w : graph.adj(v)){
                //遍历节点v的所有邻接点
                if(!marked[w]){
                    edgeTo[w] = v;//设置节点w的父节点是v
                    marked[w] = true;//标记节点w已经访问
                    queue.add(w);//将节点w入队
                }
            }
        }
    }

    /**
     * 是否有从起点s到节点v的路径
     *
     * @param v 目标节点
     * @return true 如果存在路径
     */
    public boolean hasPathTo(int v){
        return marked[v];
    }

    /**
     * 求起点s到节点v的路径
     *
     * @param v 节点v
     * @return
     */
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)){
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        for (int x=v; x!=s; x=edgeTo[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }
}
