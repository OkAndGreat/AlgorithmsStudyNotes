package Study.BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://www.acoj.com/problems/12034
 * 小哼最近爱上了“炸弹人”游戏。你还记得在小霸王游戏机上的炸弹人吗？用放置炸弹的方法来消灭敌人。需将画面上的敌人全部消灭后，并找到隐藏在墙里的暗门才能过关。
 *现在有一个特殊的关卡如下。你只有一枚炸弹，但是这枚炸弹威力超强（杀伤距离超长，可以消灭杀伤范围内所有的敌人）。请问在哪里放置炸弹才可以消灭最多的敌人呢。
 *我们先将这个地图模型化。墙用 # 表示。这里有两种墙，一种是可以被炸掉的，另外一种是不能被炸掉的。但是由于现在只有一枚炸弹，所以都用 # 表示，炸弹是不能穿墙的。
 * 敌人用 G 表示，空地用 . 表示，当然炸弹只能放在空地上。
 *必须由小人能够走到的地方才能放置炸弹。比如下面这个例子小人默认站在(3,3)这个位置。请问放在何处最多可以消灭多个敌人。
 */
public class Boomer {
    //地图数组
    static char[][] map;
    //book数组用来标记该点是否已经走过
    static int[][] book;
    static int[][] next={{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int n,m;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<note> notes = new LinkedList<>();
        n=scanner.nextInt();
        m=scanner.nextInt();
        book=new int[n][m];
        map = new char[n][];
        int startX=scanner.nextInt();
        int startY=scanner.nextInt();
        int max=-1;
        for (int i = 0; i < n; i++) {
            map[i] = scanner.next().toCharArray();
        }
        book[startX][startY]=1;
        notes.add(new note(startX,startY));
        while(!notes.isEmpty()){
            note poll = notes.poll();
            int num = getNum(poll.x, poll.y);
            if(num>max){
                max=num;
            }
            for(int k=0;k<=3;k++){
                int tx= poll.x+next[k][0];
                int ty= poll.y+next[k][1];
                if(judge(tx,ty)){
                    notes.add(new note(tx,ty));
                    book[tx][ty]=1;
                }
            }
        }
        System.out.println(max);
    }

    //统计放在（i，j）这一点能消灭的敌人数
    static int getNum(int i,int j){
        int sum=0;

        for(int k=0;k<=3;k++){
            int x=i;
            int y=j;
            while(map[x][y]!='#'){
                x+=next[k][0];
                y+=next[k][1];
                if(map[x][y]=='G'){
                    sum++;
                }
            }
        }
        return sum;
    }
    //判断（x,y）是否可以放炸弹
    static Boolean judge(int x,int y){
        if(x<0||x>n-1||y<0||y>m-1){
            return false;
        }
        return map[x][y]=='.'&&book[x][y]==0;
    }
}

class note{
    int x;
    int y;

    public note(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
