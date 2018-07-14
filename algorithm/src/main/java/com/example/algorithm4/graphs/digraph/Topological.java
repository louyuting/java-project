package com.example.algorithm4.graphs.digraph;

/**
 * 有向无环图的 拓扑排序
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/7
 */
public class Topological {
    /**
     * 顶点的拓扑排序
     */
    private Iterable<Integer> order;

    public Topological(Digraph digraph){
        DirectedCycle cycleFinder = new DirectedCycle(digraph);
        if( !cycleFinder.hasCycle() ) {
            DepthFirstOrder dfs = new DepthFirstOrder(digraph);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG(){
        return order!=null;
    }
}
