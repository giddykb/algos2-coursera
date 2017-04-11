package com.peace.undirected.graph.implementation;

public class ConnectedComponents {
	
	private int id[];
	private int count;
	private int size[];
	private boolean marked[];
	
	public ConnectedComponents(Graph G) {
		// TODO Auto-generated constructor stub
		marked  = new boolean [G.getV()];
		id = new int[G.getV()];
		size = new int [G.getV()];
		
		for(int v= 0;v<G.getV();v++){
			if(!marked[v]){
				dfs(G,v);
				count++;
			}
		}
	}

	private void dfs(Graph g, int v) {
		// TODO Auto-generated method stub
		marked[v]=true;
		id[v]=count;
		size[count]++;
		
		for(int w: g.adj(v)){
			if(!marked[w]){
				dfs(g,w);
			}
		}
		
	}

	public boolean connected(int v,int w){
			return id[v]==id[w];
	}
	
	public int id(int v){
		return id[v];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
