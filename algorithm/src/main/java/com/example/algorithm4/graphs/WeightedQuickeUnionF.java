package com.example.algorithm4.graphs;

/**
 * 加权 quick-union算法的实现
 *
 * @author 惜暮
 * @email chris.lyt@cainiao.com
 * @date 2017/12/4
 */
public class WeightedQuickeUnionF {

    private int[] id; //父链接数组
    private int[] sz; //各个根节点对应的连通分量的大小
    private int count; //连通分量的数量

    /**
     *
     * @param N 图中节点的数量
     */
    public WeightedQuickeUnionF(int N) {
        count = N;
        id = new int[N];
        // 初始化每个节点父链接指向自己
        for(int i=0; i<N; i++){
            id[i] = i;
        }
        sz = new int[N];
        // 初始化每个节点都是单独的连通分量，所以分量的大小都是1
        for (int i=0; i<N; i++){
            sz[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    /**
     * 找到节点p 所在连通分量的根节点
     *
     * @param p
     * @return p 所在连通分量的根节点标识符
     */
    private int find(int p){
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }

    /**
     * 判断两个结点是否是连通的
     * @param p 节点
     * @param q 节点
     * @return
     */
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    /**
     * 连通节点p和节点q
     * @param p
     * @param q
     */
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot){
            return;
        }
        if(sz[pRoot] < sz[qRoot]){
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }else {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
        count--;
    }
}
