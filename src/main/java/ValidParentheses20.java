import java.util.Stack;

/**
 * @author ZHUANG Yiwei on 2021/9/5
 */
public class ValidParentheses20 {
    static final char leftS = '(';
    static final char rightS = ')';
    static final char leftM = '[';
    static final char rightM = ']';
    static final char leftL = '{';
    static final char rightL = '}';


    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        if (s.length() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if (curChar == leftS || curChar == leftM || curChar == leftL) {
                stack.push(curChar);
            } else {
                if(stack.isEmpty()) {
                    return false; // Situation: ){
                }
                Character prevChar = stack.pop();
                if (curChar == rightS && prevChar != leftS || curChar == rightM && prevChar != leftM
                        || curChar == rightL && prevChar != leftL) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = "){";
        System.out.println(isValid(s));
    }
}
