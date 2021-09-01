import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author ZHUANG Yiwei on 2021/8/30
 */
public class RomanToInteger13 {

    public static int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer> romanMap = new HashMap<String, Integer>() {
            {
                this.put("I", 1);
                this.put("IV", 4);
                this.put("V", 5);
                this.put("IX", 9);
                this.put("X", 10);
                this.put("XL", 40);
                this.put("L", 50);
                this.put("XC", 90);
                this.put("C", 100);
                this.put("CD", 400);
                this.put("D", 500);
                this.put("CM", 900);
                this.put("M", 1000);
            }
        };
        ArrayList<String> romanOrder = new ArrayList<String>() {
            {
                this.add("M");
                this.add("CM");
                this.add("D");
                this.add("CD");
                this.add("C");
                this.add("XC");
                this.add("L");
                this.add("XL");
                this.add("X");
                this.add("IX");
                this.add("V");
                this.add("IV");
                this.add("I");
            }
        };
        for (String element : romanOrder) {
            if (s.length() == 0) {
                break;
            }
            while (s.startsWith(element)) {
                result = result + romanMap.get(element);
                s = s.substring(element.length());
            }
        }
        return result;
    }

    // Optimize it with Hash and Stack.
    public static int romanToIntOp(String s) {
        int add = 0;
        int diff = 0;
        HashMap<Character, Integer> romanMap = new HashMap<Character, Integer>() {
            {
                this.put('I', 1);
                this.put('V', 5);
                this.put('X', 10);
                this.put('L', 50);
                this.put('C', 100);
                this.put('D', 500);
                this.put('M', 1000);
            }
        };
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        for (char c : charArray) {
            if (!stack.isEmpty() && romanMap.get(stack.peek()) < romanMap.get(c)) {
                diff += romanMap.get(stack.pop());
            }
            stack.push(c);
        }
        Iterator<Character> it = stack.iterator();
        while (it.hasNext()) {
            add += romanMap.get(it.next());
        }
        return add - diff;
    }

    public static void main(String[] args) {
        String roman = "XXXIX";
        System.out.println(romanToIntOp(roman));
    }
}
