package com.example.algorithm4.graphs.graph;

/**
 * DFS判断无向图是否是双色环
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/5
 */
public class TwoColor {
    /**
     * 标记节点是否已经被访问过了
     */
    private boolean[] marked;
    /**
     * 标记每个结点的颜色
     */
    private boolean[] color;
    /**
     * 标记此无向图是否是双色图
     */
    private boolean isTwoColorable = true;

    public TwoColor(Graph graph) {
        this.marked = new boolean[graph.V()];
        this.color = new boolean[graph.V()];
        for (int s = 0; s<graph.V(); s++){
            if(!marked[s]){
                dfs(graph, s);
            }
        }
    }


    /**
     * 对图G进行深度优先遍历
     *
     * @param graph 无向图
     * @param v dfs开始遍历的结点
     */
    private void dfs(Graph graph, int v){
        this.marked[v] = true;
        for(int w:graph.adj(v)){
            if (!marked[w]){
                color[w] = !color[v];
                dfs(graph, w);
            } else if (color[w] == color[v]){
                this.isTwoColorable = false;
            }
        }
    }


    /**
     * 判断当前无向图是否是双色环
     *
     * @return true 如果是双色环。
     */
    public boolean isTwoColorable(){
        return this.isTwoColorable;
    }
}
