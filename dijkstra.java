import java.util.Scanner;

public class dijkstra {
    public static void main(String[] args) {
        int n, s;
        int[][] cost = new int[10][10];
        int[] dist = new int[10];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of vertices");
        n = scanner.nextInt();

        System.out.println("Enter the cost adjacency matrix (999 for infinite)");
        readMatrix(n, cost, scanner);

        System.out.println("Enter the source vertex");
        s = scanner.nextInt();

        shortestPath(n, s, cost, dist);

        for (int i = 1; i <= n; i++) {
            System.out.println("The shortest path between vertex " + s + " to " + i + " is " + dist[i]);
        }

        scanner.close();
    }

    public static void readMatrix(int n, int[][] cost, Scanner scanner) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("(" + i + "," + j + "): ");
                cost[i][j] = scanner.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = 999;
                }
            }
        }
    }

    public static int min(int a, int b) {
        return a > b ? b : a;
    }

    public static void shortestPath(int n, int s, int[][] cost, int[] dist) {
        int[] vis = new int[10];
        int c, u = -1; // Initialize u to -1

        for (int i = 1; i <= n; i++) {
            vis[i] = 0;
            dist[i] = cost[s][i];
        }
        dist[s] = 0;
        vis[s] = 1;

        for (int k = 1; k <= n; k++) {
            c = 999;
            for (int i = 1; i <= n; i++) {
                if (vis[i] == 0) {
                    if (dist[i] <= c) {
                        c = dist[i];
                        u = i;
                    }
                }
            }

            if (u == -1) break; // If no vertex was found, break the loop

            vis[u] = 1;

            for (int i = 1; i <= n; i++) {
                dist[i] = min(dist[i], dist[u] + cost[u][i]);
            }
        }
    }
}