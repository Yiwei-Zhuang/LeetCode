/**
 * @author ZHUANG Yiwei on 2021/9/13
 */
public class strStr28 {


    public static int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        }
        int needleIndex = 0;
        int oldPos = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(needleIndex)) {
                if (oldPos == -1) {
                    oldPos = i;
                }
                needleIndex++;
                if (needleIndex == needle.length()) {
                    return i - needle.length() + 1;
                }
            } else {
                needleIndex = 0;
                if (oldPos != -1) {
                    i = oldPos;
                    oldPos = -1;
                }
            }
        }
        return -1;
    }

    // Optimize by reverse check.
    public static int strStrOp(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }

        char end = needle.charAt(needle.length()-1);

        int i = 0;
        for(int j = needle.length()-1; j < haystack.length(); j++ ){
            if(haystack.charAt(j) == end){
                i = j - (needle.length()-1);
                if(haystack.substring(i,j+1).equals(needle)){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "mississippi";
        String needle = "issip";
        System.out.println(strStr(haystack, needle));

    }
}
