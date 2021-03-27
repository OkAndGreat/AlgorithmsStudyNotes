import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.movingCount(3,2,17));
    }
}

class Solution {
    //使用一个方向数组可以简化向上向下向左向右行动的代码
    int[][] next = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //book数组用来标记该点是否已经走过
    int[][] book;
    int k;
    Stack<location> stack = new Stack<location>();

    public int movingCount(int m, int n, int k) {
        this.k = k;
        book=new int[m][n];
        int result = 0;
        stack.push(new location(0, 0));
        book[0][0]=1;
        while (!stack.isEmpty()) {
            location temp = stack.pop();
            if (judge(temp.x,temp.y)) {
                result++;
                for (int l = 0; l <= 3; l++) {
                    int tx=temp.x + next[l][0];
                    int ty=temp.y + next[l][1];
                    if(tx>=m||ty>=n||tx<0||ty<0){
                        continue;
                    }
                    if(book[tx][ty]==0){
                        book[tx][ty]=1;
                        stack.push(new location(tx,ty));
                    }
                }
            }
        }
        return result;
    }

    boolean judge(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum <= k;
    }
}

class location {
    int x;
    int y;

    public location(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
