//https://practice.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1#


// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFGDFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj =
                    new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            SolutionDFS obj = new SolutionDFS();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class SolutionDFS {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[] = new int[V+1];
        ArrayList<Integer> result = new ArrayList<>();
        if (vis[V]!=1){
            dfs(vis,0,adj, result);
        }
        return result;
    }
    public void dfs(int vis[],int s,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> result){
        vis[s]=1;
        result.add(s);
        ArrayList<Integer> list = adj.get(s);
        for(int i=0;i<list.size();i++){
            if(vis[list.get(i)]!=1){
                dfs(vis,list.get(i),adj,result);
            }
        }
    }
}