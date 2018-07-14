package com.example.algorithm4.graphs.digraph;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

/**
 * 符号有向图的实现
 *
 * @author 惜暮
 * @email chris.lyt@alibaba-inc.com
 * @date 2017/12/7
 */
public class SymbolDiGraph {
    private ST<String, Integer> st; // 顶点符号名 -> 数组索引
    private String[] keys; // 数组索引 -> 顶点符号名
    private Digraph G; // 图

    /**
     * 构造一颗符号有向图
     * @param stream 顶点边的数据源
     * @param sp 顶点分隔符
     */
    public SymbolDiGraph(String stream, String sp) {
        st = new ST<>();
        In in = new In(stream); // First pass
        while (in.hasNextLine()) {// builds the index
            String[] a = in.readLine().split(sp); // by reading strings
            for (int i = 0; i < a.length; i++) {// to associate each
                if (!st.contains(a[i])) {// distinct string
                	st.put(a[i], st.size()); // with an index.
                }
            }
        }
        keys = new String[st.size()]; //建立索引 --> 结点符号
        for (String name : st.keys()) {// to get string keys
          	keys[st.get(name)] = name; // is an array.
        }
        G = new Digraph(st.size());
        in = new In(stream); // Second pass
        while (in.hasNextLine()) {// builds the graph
            String[] a = in.readLine().split(sp); // by connecting the
            int v = st.get(a[0]); // source vertex
            for (int i = 1; i < a.length; i++) {// on each line
            	G.addEdge(v, st.get(a[i])); // to all the others.
            }
        }
    }

  	public boolean contains(String s) {
      	return st.contains(s);
    }

  	public int index(String s) {
      	return st.get(s);
    }

	public String name(int v) {
      	return keys[v];
    }

	public Digraph G() {
      	return G;
    }
}