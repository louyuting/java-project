package com.example.algorithm4.graphs;

/**
 * 使用DFS找出图中的所有连通分量：
 * <li>这里的实现是基于一个由顶点索引的数组id[], 如果v属于第i个连通分量，则id[v]的值为i，也就是说如果一个图只有一个连通分量，那么id[]里面数据均为0；
 * 如果一个图两个连通分量，那么连通分量0对应的节点在id[v]中均为0，连通分量1对应的节点在id[v]中均为1。</li>
 * <li>构造函数会找出第一个未被标记的顶点并调用递归函数dfs()来标记并区分出所有和它连通的顶点，如此重复直到所有的顶点都被标记并区分</li>
 *
 *
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/12/3
 */
public class CC {
    private boolean[] marked;//寻找一个顶点作为每个连通分量中深度优先搜索的起点
    private int[] id; // 保存每个顶点所属于哪一个连通分量。
    private int count; //保存图存在的连通分量的数量

    public CC(Graph graph) {
        this.marked = new boolean[graph.V()];
        id = new int[graph.V()];
        for (int s=0; s<graph.V(); s++){
            if ( !marked[s]){
                dfs(graph, s);
                count++;
            }
        }
    }

    /**
     * 对于图g 以 节点v开始做DFS
     * @param graph 无向图
     * @param v DFS起点
     */
    private void dfs(Graph graph, int v){
        marked[v] = true;
        id[v] = count;
        for (int w : graph.adj(v)){
            if (!marked[w]){
                dfs(graph, w);
            }
        }
    }

    /**
     * 节点v和节点w是否是连通的，换句话说也就是节点v和w是否在一个连通分量里面
     *
     * @param v 节点
     * @param w 节点
     * @return true：如果节点v和w属于同一个连通分量
     */
    public boolean connected(int v, int w){
        return id[v] == id[w];
    }

    /**
     * 求节点v所属于的连通分量
     *
     * @param v 节点
     * @return 节点v所属于的连通分量的序号
     */
    public int id(int v){
        return id[v];
    }

    /**
     * 当前图存在多少个连通分量
     * @return 返回当前图所存在的连通分量的数目
     */
    public int count(){
        return count;
    }
}
