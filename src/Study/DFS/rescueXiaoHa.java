package Study.DFS;

import java.util.Scanner;

/**
 * https://www.acoj.com/problems/12032
 * 有一天，小哈一个去玩迷宫。但是方向感很不好的小哈很快就迷路了。
 * 小哼得知后便立即去解救无助的小哈。小哼当然是有备而来，已经弄清楚了迷宫地图，现在小哼要以最快速度去解救小哈。
 * 问题就此开始了……
 * 迷宫由n行m列的单元格组成，每个单元格要么是空地，要么是障碍物。
 * 你的任务是帮助小哼找到一条从迷宫的起点到小哈所在位置的最短路径，注意障碍物是不能走的，当然也不能走到迷宫之外。n和m都小于等于100。
 */
public class rescueXiaoHa {
    //地图数组
    static int[][] map;
    //book数组用来标记该点是否已经走过
    static int[][] book;
    static int min = Integer.MAX_VALUE, endX, endY, n, m;
    //使用一个方向数组可以简化向上向下向左向右行动的代码
    static int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startX, startY;
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new int[n + 1][m + 1];
        book = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        startX = scanner.nextInt();
        startY = scanner.nextInt();
        endX = scanner.nextInt();
        endY = scanner.nextInt();
        book[startX][startY] = 1;
        dfs(startX, startY, 0);
        if (min == Integer.MAX_VALUE) {
            System.out.println("No Way!");
        } else {
            System.out.println(min);
        }
    }

    static void dfs(int x, int y, int step) {
        //递归结束条件
        if (x == endX && y == endY) {
            if (step < min) {
                min = step;
            }
            return;
        }
        for (int k = 0; k <= 3; k++) {
            int tx = x + next[k][0];
            int ty = y + next[k][1];
            if (judge(tx, ty)) {
                book[tx][ty] = 1;
                dfs(tx, ty, step + 1);
                //递归回溯，记得将该点标记为未走过
                book[tx][ty] = 0;
            }
        }
    }

    static Boolean judge(int x, int y) {
        if (x < 1 || x > n || y < 1 || y > m) {
            return false;
        }
        return map[x][y] == 0 && book[x][y] == 0;
    }
}
