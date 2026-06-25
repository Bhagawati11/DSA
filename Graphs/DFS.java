import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static void recursiveDFS(int v, List<Integer>[] adj, boolean[] visited, List<Integer> result) {
        visited[v] = true;
        result.add(v);
        for (int u : adj[v]) {
            if (!visited[u])// --!false ---> true
                recursiveDFS(u, adj, visited, result);
        }
    }

    public static void dfsIterative(int start, List<Integer>[] adj, boolean[] visited) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                visited[node] = true;
                System.out.print(node + " ");
                // Push all neighbours
                for (int neighbour : adj[node]) {
                    if (!visited[neighbour]) {
                        stack.push(neighbour);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        int v = 27;
        List<Integer>[] adj = new ArrayList[v];

        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
        adj[0].addAll(Arrays.asList(1, 2, 3));
        adj[1].addAll(Arrays.asList(0, 4, 5, 6));
        adj[2].addAll(Arrays.asList(0, 7));
        adj[3].addAll(Arrays.asList(0, 8, 9));
        adj[4].addAll(Arrays.asList(1,10,11));
        adj[5].addAll(Arrays.asList(1,11,12));
        adj[6].addAll(Arrays.asList(1,12,13));
        adj[7].addAll(Arrays.asList(2,13,14));
        adj[8].addAll(Arrays.asList(3,14,15));
        adj[9].addAll(Arrays.asList(3,15,16));
        adj[10].addAll(Arrays.asList(4,17));
        adj[11].addAll(Arrays.asList(4,5,17));
        adj[12].addAll(Arrays.asList(5,6,18));
        adj[13].addAll(Arrays.asList(6,7,18));
        adj[14].addAll(Arrays.asList(7,8,19));
        adj[15].addAll(Arrays.asList(8,9,19));
        adj[16].addAll(Arrays.asList(9, 20));
        adj[17].addAll(Arrays.asList(10, 11, 18, 21, 24));
        adj[18].addAll(Arrays.asList(12, 13, 17, 19, 21, 22));
        adj[19].addAll(Arrays.asList(14, 15, 18, 20, 22, 23));
        adj[20].addAll(Arrays.asList(16, 19, 23, 26));
        adj[21].addAll(Arrays.asList(17, 18, 22, 24));
        adj[22].addAll(Arrays.asList(18, 19, 21, 23, 25));
        adj[23].addAll(Arrays.asList(19, 20, 22, 26));
        adj[24].addAll(Arrays.asList(17, 21, 25));
        adj[25].addAll(Arrays.asList(24, 22, 26));
        adj[26].addAll(Arrays.asList(20, 23, 25));

        boolean[] visited = new boolean[v];
        List<Integer> result = new ArrayList<>();

        recursiveDFS(0, adj, visited, result);

        for (int x : result) {
            System.out.print(x + " ");
        }
        System.out.println();
        boolean[] visited1 = new boolean[v];
        dfsIterative(0, adj, visited1);
        //iterative and recursive dfs will give the same output but the order of nodes may differ based on the order of neighbors in the adjacency list.
        //tc O(V + E) for both recursive and iterative DFS, where V is the number of vertices and E is the number of edges in the graph.
        //sc O(V) for both recursive and iterative DFS, as we need to keep track of visited nodes and the recursion stack (in the case of recursive DFS) or the explicit stack (in the case of iterative DFS).
    }
}
