package com.example.algorithm4.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 有向图中基于深度优先搜索的顶点排序
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/7
 */
public class DepthFirstOrder {
    /**
     * 从起点开始DFS访问过的路径标记
     */
    private boolean[] marked;
    /**
     * 所有顶点的前序排列
     */
    private Queue<Integer> pre;
    /**
     * 所有顶点的后序排列
     */
    private Queue<Integer> post;
    /**
     * 所有顶点的逆后序排列
     */
    private Stack<Integer> reversePost;

    public DepthFirstOrder(Digraph digraph) {
        marked = new boolean[digraph.V()];
        pre = new LinkedList<>();
        post = new LinkedList<>();
        reversePost = new Stack<>();

        for (int v=0; v<digraph.V(); v++){
            if ( !marked[v] ) {
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
        pre.add(v);
        this.marked[v] = true;
        for (int w : digraph.adj(v)){
            if(!this.marked[w]){
                dfs(digraph, w);
            }
        }
        post.add(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre(){
        return pre;
    }

    public Iterable<Integer> post(){
        return post;
    }

    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}
