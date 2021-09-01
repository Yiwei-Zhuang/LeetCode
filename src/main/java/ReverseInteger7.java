/**
 * @author ZHUANG Yiwei on 2021/8/29
 */
public class ReverseInteger7 {

    public static int reverse(int x) {
        int temp = 0;
        int ret = 0;
        boolean pos = true;
        if (x < 0) {
            pos = false;
            x = x * -1;
        }

        // Remove last 0
        while (x % 10 == 0 && x != 0) {
            x = x / 10;
        }
        while (true) {
            if (x == 0) {
                break;
            }
            if (ret * 10 / 10 - ret != 0) { // Exceed max value
                return 0;
            }
            ret = ret * 10;
            temp = x % 10;
            x = x / 10;
            if (ret + temp < 0) { // Exceed max value
                return 0;
            }
            ret = ret + temp;
        }
        return pos ? ret : ret * -1;
    }

    // TODO: Optimize


    public static void main(String[] args) {
        int test = 153423646;
        System.out.println(reverse(test));
    }
}
