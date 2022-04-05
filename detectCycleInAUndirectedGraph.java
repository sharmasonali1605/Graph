//https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/#


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis []= new int[V+1];
        //boolean result = true;
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                if(isCyclicUtil(vis,i,adj,-1)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCyclicUtil(int vis[],int s,ArrayList<ArrayList<Integer>> adj,int parent){
        vis[s]=1;
        ArrayList<Integer> list = adj.get(s);
        for(int i=0;i<list.size();i++){
            if(vis[list.get(i)]!=1){
                if(isCyclicUtil(vis,list.get(i),adj,s)){
                    return true;
                }
            }else if(list.get(i)!=parent){
                return true;
            }
        }
        return false;

    }
}