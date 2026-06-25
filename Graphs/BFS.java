import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static List<Integer> bfsIterative(int start, List<Integer>[] adj, boolean[] visited, List<Integer> result) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();

           // System.out.print(node + " ");
            result.add(node);

            for (int x : adj[node]) {
                if (!visited[x]) {
                    visited[x] = true;
                    queue.add(x);
                }
            }
        }
        return result;
    }
    public static void bfsRecursive(Queue<Integer> queue, List<Integer>[] adj, boolean[] visited) {
    if(queue.isEmpty())
        return;

    int node = queue.poll();

    System.out.print(node + " ");

    for(int neighbour : adj[node])
    {
        if(!visited[neighbour])
        {
            visited[neighbour] = true;
            queue.add(neighbour);
        }
    }

    bfsRecursive(queue, adj, visited);
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
        adj[4].addAll(Arrays.asList(1, 10, 11));
        adj[5].addAll(Arrays.asList(1, 11, 12));
        adj[6].addAll(Arrays.asList(1, 12, 13));
        adj[7].addAll(Arrays.asList(2, 13, 14));
        adj[8].addAll(Arrays.asList(3, 14, 15));
        adj[9].addAll(Arrays.asList(3, 15, 16));
        adj[10].addAll(Arrays.asList(4, 17));
        adj[11].addAll(Arrays.asList(4, 5, 17));
        adj[12].addAll(Arrays.asList(5, 6, 18));
        adj[13].addAll(Arrays.asList(6, 7, 18));
        adj[14].addAll(Arrays.asList(7, 8, 19));
        adj[15].addAll(Arrays.asList(8, 9, 19));
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
        bfsIterative(26, adj, visited, result);

        boolean[] visited1 = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(26);
        bfsRecursive(queue, adj, visited1);

        // for (int x : result) {
        //     System.out.print(x + " ");
        // }
        // System.out.println();
    }
}
