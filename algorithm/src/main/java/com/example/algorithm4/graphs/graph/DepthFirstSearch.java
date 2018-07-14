package com.example.algorithm4.graphs.graph;

/**
 * <p>DFS 深度优先遍历</p>
 * <p>此算法有个缺点：对于有E条边的图，算法需要需要遍历2E次边。也就是每条边被访问两次，比如：
 * 对于v-w的边，第一次访问时，v已被标记，w被标记已访问，当从w-v时，也要访问一次，只不过会判断v已经被
 * 访问过了，所以return.
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/11/30
 */
public class DepthFirstSearch {
    /**
     * 节点是否被访问过，比如从v-w 这个，如果w已经被访问过了，那么marked[w]就是true
     */
    private boolean[] marked;
    /**
     * 访问的节点数
     */
    private int count;

    /**
     * DFS的构造器
     *
     * @param graph 进行深度优先遍历的图
     * @param s 深度优先遍历的起始节点
     */
    public DepthFirstSearch(Graph graph, int s) {
        this.marked = new boolean[graph.V()];
        dfs(graph, s);
    }

    /**
     * 从图的节点 v 开始进行DFS
     *
     * @param graph 图
     * @param v 开始DFS的起点
     */
    private void dfs(Graph graph, int v){
        marked[v] = true;
        count++;
        for (int w : graph.adj(v)){
            //遍历节点V的所有未访问过的相邻节点
            if(!marked[w]){
                dfs(graph, w);
            }
        }
    }

    /**
     * 判断节点w是否已经被标记
     *
     * @param w 图的节点
     * @return 节点w已经被标记，返回true，否则返回false。
     */
    public boolean marked(int w){
        return marked[w];
    }

    /**
     * 返回总的路径长度
     * @return
     */
    public int count(){
        return count;
    }
}
