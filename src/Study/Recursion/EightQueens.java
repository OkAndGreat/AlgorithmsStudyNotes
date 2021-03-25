package Study.Recursion;

/**
 * 问题描述:在8×8格的国际象棋上摆放8个皇后，使其不能互相攻击，即任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 */
public class EightQueens {
    //数组的下标表示行标 对应的值表示列标 Queen[4]=4 表示第四个皇后在第4列上
    static int[] Queen = new int[8];
    static int cnt = 0;


    public static void main(String[] args) {
        startGame(0);
        System.out.println("共有" + cnt + "种解法");
    }

    public static void startGame(int n) {

        for (int i = 0; i < 8; i++) {
            Queen[n] = i;
            if (judge(n)) {
                if (n != 7) {
                    startGame(n + 1);
                } else {
                    cnt();
                }
            }
        }
    }

    //如果符合条件返回true 不符合条件返回false
    public static boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            //第一个条件判断是否在同一列,第二个条件判断是否在同一斜线(要用绝对值,因为可能45度角,可能135度角)
            if (Queen[i] == Queen[n] || Math.abs(n - i) == Math.abs(Queen[n] - Queen[i])) {
                return false;
            }
        }
        return true;
    }

    //每调用一次cnt()则说明找到一种解法
    private static void cnt() {
        cnt++;
        for (int i = 7; i > -1; i--) {
            StringBuilder s = new StringBuilder();
            for (int j = 0; j < Queen.length; j++) {
                if (j == Queen[i]) {
                    s.append("Q");
                } else {
                    s.append(".");
                }
            }
            System.out.println(s + "\n");
        }
        System.out.println("===============================\n");

    }
}
