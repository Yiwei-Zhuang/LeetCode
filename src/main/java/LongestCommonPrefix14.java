/**
 * @author ZHUANG Yiwei on 2021/8/31
 */
public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; i < strs[0].length(); i++) {
            int start = 0;
            int end = i + 1;
            String newOne = strs[0].substring(start, end);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() < end || !newOne.equals(strs[j].substring(start, end))) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // Optimized by finding the shortest string in the string array.
    public static String longestCommonPrefixOp1(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int shortest = Integer.MAX_VALUE;
        for (String str : strs) {
            if (str.length() < shortest) {
                shortest = str.length();
                if (shortest == 0) {
                    return "";
                }
            }
        }
        String base = strs[0];
        for (int i = 0; i < shortest; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (!base.substring(0, i + 1).equals(strs[j].substring(0, i + 1))) {
                    return base.substring(0, i);
                }
            }
        }
        return base.substring(0, shortest);
    }

    // Optimized by horizontal comparision.
    public static String longestCommonPrefixOp2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.equals("")) {
                    return "";
                }
            }
        }
        return prefix;
    }

    // Optimized by divide and conquer.
    public static String longestCommonPrefixOp3(String[] strs) {
        int l = 0;
        int r = strs.length;
        int m = (r - l) / 2;


        return "";
    }

    private static String divide(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 2) {
            return commonPrefix(strs[0], strs[1]);
        } else {
            int l = 0;
            int r = strs.length;
            int m = (r - l) / 2;
            String[] left = new String[m - l];
            String[] right = new String[r - m];
            for (int i = 0; i < m - l; i++) {
                left[i] = strs[i];
            }
            for (int i = 0; i < r - m + 1; i++) {
                right[i] = strs[m];
            }
            return commonPrefix(divide(left), divide(right)); // TODO:

        }

    }

    private static String commonPrefix(String first, String second) {
        String shortest;
        if (first.length() <= second.length()) {
            shortest = first;
        } else {
            shortest = second;
        }
        for (int i = 0; i < shortest.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        String[] strs = new String[3];
        strs[0] = "abcd";
        strs[1] = "ab";
        strs[2] = "abasdasf";
        System.out.println(longestCommonPrefixOp2(strs));
    }
}
