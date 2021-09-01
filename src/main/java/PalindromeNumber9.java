/**
 * @author ZHUANG Yiwei on 2021/8/30
 */
public class PalindromeNumber9 {

    public static boolean isPalindrome(int x) {
        int origin = x;
        int reversed = 0;
        int temp;
        if (x < 0) {
            return false;
        }
        while (x != 0) {
            temp = x % 10;
            reversed = reversed * 10 + temp;
            x = x / 10;
        }
        return origin == reversed;
    }

    public static void main(String[] args) {
        int x = 0;
        System.out.println(isPalindrome(x));
    }
}
