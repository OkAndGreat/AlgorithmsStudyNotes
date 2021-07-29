import java.util.*;

//[9]
//[1,9,9,9,9,9,9,9,9,9]
public class test {
    public static void main(String[] args) {
        Solution solution = new Solution();
    }

}
class Solution {
    int[][] vis;
    int res = 0;
    boolean isOriDot;
    public int numIslands(char[][] grid) {
        vis = new int[grid.length][grid[0].length];
        Stack stack = new Stack<dot>();
        vis[0][0] = 1;
        stack.push(new dot(0,0));
        while(!stack.isEmpty()){
            isOriDot = true;
            dot curDot = (dot)stack.pop();
            int curX = curDot.x;
            int curY = curDot.y;
            if(curX-1>=0){
                if(vis[curX-1][curY] == 0){
                    stack.push(grid[curX-1][curY]);
                    vis[curX-1][curY] = 1;
                }
                if(grid[curX-1][curY] == 2) isOriDot=false;
            }
            if(curX+1<grid[0].length){
                if(vis[curX+1][curY] == 0){
                    stack.push(grid[curX+1][curY]);
                    vis[curX+1][curY] = 1;
                }
                if(grid[curX+1][curY] == 2) isOriDot=false;
            }
            if(curY-1>=0){
                if(vis[curX][curY-1] == 0){
                    stack.push(grid[curX][curY-1]);
                    vis[curX][curY-1] = 1;
                }
                if(grid[curX][curY-1] == 2) isOriDot=false;
            }
            if(curY+1<grid.length){
                if(vis[curX][curY+1] == 0){
                    stack.push(grid[curX][curY+1]);
                    vis[curX][curY+1] = 1;
                }
                if(grid[curX][curY+1] == 2) isOriDot=false;
            }
            if(grid[curX][curY] == 1){
                grid[curX][curY] = 2;
                if(isOriDot == true) res++;
            }
        }
        return res;
    }
}

class dot {
    int x;
    int y;
    dot(int x , int y){
        this.x = x;
        this.y = y;
    }
}



