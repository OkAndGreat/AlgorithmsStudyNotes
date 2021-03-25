package Study.DFS;

import java.util.Scanner;

/**
 * https://www.acoj.com/problems/12035
 * 小哼通过秘密方法得到一张不完整的钓鱼岛航拍地图。钓鱼岛由一个主岛和一些附属岛屿组成，小哼决定去钓鱼岛探险。下面这个10*10的二维矩阵就是钓鱼岛的航拍地图。
 * 图中数字表示海拔，0表示海洋，1~9都表示陆地。小哼的飞机将会降落在(6,8)处，现在需要计算出小哼降落所在岛的面积（即有多少个格子）。
 * 注意此处我们把与小哼降落点上下左右相链接的陆地均视为同一岛屿。
 * 输入格式:
 * <p>
 * 一行4个整数，前两个整数表示n行m列，后两个整数表示降落的坐标x行y列
 * 接下来n行，每行m列，整数之间用空格隔开表示地图。
 * 输出格式:
 * <p>
 * 一个整数表示岛屿的面积
 * 限制:
 * <p>
 * n<=100
 * m<=100
 * 样例 1 :
 * <p>
 * 输入:
 * 10 10 6 8
 * 1 2 1 0 0 0 0 0 2 3
 * 3 0 2 0 1 2 1 0 1 2
 * 4 0 1 0 1 2 3 2 0 1
 * 3 2 0 0 0 1 2 4 0 0
 * 0 0 0 0 0 0 1 5 3 0
 * 0 1 2 1 0 1 5 4 3 0
 * 0 1 2 3 1 3 6 2 1 0
 * 0 0 3 4 8 9 7 5 0 0
 * 0 0 0 3 7 8 6 0 1 2
 * 0 0 0 0 0 0 0 0 1 0
 * 输出:
 * 38
 */
public class IslandAdventure {
    static int n;
    static int m;
    static int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int[][] map;
    static int[][] book;
    static int max = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n=scanner.nextInt();
        m=scanner.nextInt();
        book=new int[n][m];
        map=new int[n][m];
        int startX=scanner.nextInt();
        int startY=scanner.nextInt();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i][j]=scanner.nextInt();
            }
        }
        dfs(startX-1,startY-1);
        System.out.println(max);
    }

    static void dfs(int x, int y) {
        //递归结束条件
        if(!judge(x,y)){
            return;
        }
        max++;
        book[x][y]=1;
        for(int k=0;k<=3;k++){
            dfs(x+next[k][0],y+next[k][1]);
        }
    }

    static Boolean judge(int x, int y) {
        //首先判断是否越界
        if (x < 0 || x > n - 1 || y < 0 || y > m - 1) {
            return false;
        }
        //再判断是否是陆地和是否已经到达过
        return map[x][y] > 0 && book[x][y] == 0;
    }
}
