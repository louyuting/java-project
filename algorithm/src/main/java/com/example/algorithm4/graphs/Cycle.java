package com.example.algorithm4.graphs;

/**
 * 利用DFS判断无向图是否有环
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/5
 */
public class Cycle {
    /**
     * 标记节点是否已经被访问过了
     */
    private boolean[] marked;
    /**
     * 标记此无向图是否有环
     */
    private boolean hasCycle;

    public Cycle(Graph graph) {
        this.marked = new boolean[graph.V()];
        for (int s = 0; s<graph.V(); s++){
            if(!marked[s]){
                dfs(graph, s, s);
            }
        }
    }


    /**
     * 对图G进行深度优先遍历
     *
     * @param graph 无向图
     * @param v dfs开始遍历的结点
     * @param p w结点的父链接结点
     */
    private void dfs(Graph graph, int v, int p){
        this.marked[v] = true;
        for(int w:graph.adj(v)){
            if (!marked[w]){
                dfs(graph, w, v);
            } else if (w != p){
                // 当前遍历的节点已经访问过得时候，判断当前节点和当前结点回溯两次的节点是否相同，如果不同，就代表存在环。
                this.hasCycle = true;
            }
        }
    }


    /**
     * 判断当前无向图是否存在无向环
     *
     * @return true 如果存在无向环。
     */
    public boolean hasCycle(){
        return this.hasCycle;
    }
}
