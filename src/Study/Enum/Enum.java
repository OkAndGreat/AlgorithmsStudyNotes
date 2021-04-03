package Study.Enum;

//Please give me 6 pairs of positive integers (x,y,z) satisfying the equation `x/(y+z) + y/(z+x) + z/(x+y) = 6`
public class Enum {
    public static void main(String[] args) {
        int i = 0;
        float x = 1;
        float y = 1;
        float z = 1;
        int cnt = 0;
        while (i < 6) {
            if (cnt % 30 == 0) {
                x++;
            } else if (cnt % 30 == 1) {
                y++;
            } else {
                z++;
            }
            if (x / (y + z) + y / (z + x) + z / (x + y) == 6f) {
                System.out.println("x==" + x + "  " + "y==" + y + "  " + "z==" + z);
                i++;
            }
            cnt++;
        }
    }
}
