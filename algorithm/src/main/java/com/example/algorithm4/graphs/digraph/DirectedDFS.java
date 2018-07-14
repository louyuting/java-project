package com.example.algorithm4.graphs.digraph;

/**
 * 有向图的深度优先遍历
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/7
 */
public class DirectedDFS {
    /**
     * 从起点开始DFS访问过的路径标记
     */
    private boolean[] marked;

    public DirectedDFS(Digraph digraph, int s) {
        this.marked = new boolean[digraph.V()];
        dfs(digraph, s);
    }

    public DirectedDFS(Digraph digraph, Iterable<Integer> sources) {
        this.marked = new boolean[digraph.V()];
        for(int s : sources){
            if (!marked[s]){
                dfs(digraph, s);
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
        this.marked[v] = true;
        for (int w : digraph.adj(v)){
            if(!this.marked[w]){
                dfs(digraph, w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }
}
