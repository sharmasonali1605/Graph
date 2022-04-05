//https://practice.geeksforgeeks.org/problems/bfs-traversal-of-graph/1#


// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class BFS {
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
                // adj.get(v).add(u);
            }
            SolutionBFS obj = new SolutionBFS();
            ArrayList<Integer> ans = obj.bfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class SolutionBFS {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> result = new ArrayList<>();
        int vis[] = new int[V+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        BFS(adj, vis,result, q);
        return result;
    }

    public static void BFS(ArrayList<ArrayList<Integer>> adj,int vis[],ArrayList<Integer> result
            ,Queue<Integer> q){
        if(q.size()==0){
            return;
        }
        while(q.size()!=0){
            int size = q.size();
            for(int i=0;i<size;i++){
                int temp = q.remove();
                if(vis[temp]!=1){
                    vis[temp]=1;
                    result.add(temp);
                    ArrayList<Integer> list = adj.get(temp);
                    for(int j=0;j<list.size();j++){
                        q.add(list.get(j));
                    }
                }
            }
            BFS(adj,vis,result,q);
        }

    }
}