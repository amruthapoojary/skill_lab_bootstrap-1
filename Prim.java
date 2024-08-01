import java.util.Scanner;

public class Prim {
    static final int MAX = 10;
    static final int INF = 999;
    static int[] visited = new int[MAX];
    static int[][] cost = new int[MAX][MAX];
    static int n, mincost = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i, j, u = 0, v = 0, a = 0, b = 0, min, ne = 1;

        System.out.println("Enter the number of vertices and graph data");
        n = scanner.nextInt();

        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                System.out.printf("(%d,%d):", i, j);
                cost[i][j] = scanner.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = INF;
                }
            }
        }

        for (i = 1; i <= n; i++) {
            visited[i] = 0;
        }

        System.out.println("The edges of the spanning tree are");
        visited[1] = 1;

        while (ne < n) {
            min = INF;
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        if (visited[i] == 0) {
                            continue;
                        } else {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;
                        }
                    }
                }
            }

            if (visited[u] == 0 || visited[v] == 0) {
                System.out.printf("%d: edge(%d,%d) = %d\t", ne++, a, b, min);
                mincost += min;
                visited[b] = 1;
            }
            cost[a][b] = cost[b][a] = INF;
        }

        System.out.printf("\nMinimum cost is %d\n", mincost);
        scanner.close();
    }
}