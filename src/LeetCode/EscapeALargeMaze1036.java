package LeetCode;

import java.util.ArrayList;

/**
 * 在一个 10^6 x 10^6 的网格中，每个网格块的坐标为(x, y)，其中0 <= x, y < 10^6。
 * 我们从源方块source开始出发，意图赶往目标方格target。每次移动，我们都可以走到网格中在四个方向上相邻的方格，只要该方格不在给出的封锁列表blocked上。
 * 只有在可以通过一系列的移动到达目标方格时才返回true。否则，返回 false。
 * 示例 1：
 * 输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
 * 输出：false
 * 解释：
 * 从源方格无法到达目标方格，因为我们无法在网格中移动。
 * 示例 2：
 * 输入：blocked = [], source = [0,0], target = [999999,999999]
 * 输出：true
 * 解释：
 * 因为没有方格被封锁，所以一定可以到达目标方格。
 * 提示：
 * 0 <= blocked.length <= 200
 * blocked[i].length == 2
 * 0 <= blocked[i][j] < 10^6
 * source.length == target.length == 2
 * 0 <= source[i][j], target[i][j] < 10^6
 * source != target
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/escape-a-large-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 000
 * 000
 * 000
 */
public class EscapeALargeMaze1036 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[][] blocked = new int[1][2];
        blocked[0] = new int[]{0, 26};
        // blocked[1] = new int[]{2, 0};
        //blocked[2] = new int[]{2, 1};
        //blocked[3] = new int[]{2, 2};
        // blocked[4] = new int[]{1, 2};
        int[] source = new int[]{0, 0};
        int[] target = new int[]{24, 45};
        System.out.println(solution1.isEscapePossible(blocked, source, target));
    }
}

//该方法理论上可行
//但当迷宫的size为Large时使用递归回溯会导致栈溢出
//迷宫大小在50*50的时候比较稳定,不会栈溢出
//此时已经可能创建上千个栈!isEscapePossible函数会被调用四千多次!
class Solution1 {
    ArrayList<Integer[]> list = new ArrayList<>();
    int cnt=0;

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        cnt++;
        if (source[0] == target[0] && source[1] == target[1]) {
            System.out.println("函数被调用了"+cnt+"次");
            return true;
        } else {
            //判断当前点是否走过
            if (isWalked(source[0], source[1])) {
                return false;
            }
            //判断是否越过边界
            if (source[0] < 0 || source[1] < 0 || source[0] > 50 || source[1] > 50) {
                return false;
            }
            //判断是否到达封锁点
            for (int[] ints : blocked) {
                if (source[0] == ints[0] && source[1] == ints[1]) {
                    return false;
                }
            }
            //如果当前点没有走过,则将当前点划分到走过的点中去
            Integer[] walkedNum = new Integer[2];
            walkedNum[0] = source[0];
            walkedNum[1] = source[1];
            list.add(walkedNum);
            //表示向左行动
            source[0]--;
            if (isEscapePossible(blocked, source, target)) {
                return true;
            }
            source[0]++;
            source[1]--;
            //表示向上行动
            if (isEscapePossible(blocked, source, target)) {
                return true;
            }
            source[1]++;
            source[0]++;
            //表示向右行动
            if (isEscapePossible(blocked, source, target)) {
                return true;
            }
            source[0]--;
            source[1]++;
            //表示向下行动
            return isEscapePossible(blocked, source, target);
        }
    }

    //判断当前点是否已经走过
    public boolean isWalked(int j, int k) {
        boolean flag = false;
        for (Integer[] integers : list) {
            if (j == integers[0] && k == integers[1]) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}


