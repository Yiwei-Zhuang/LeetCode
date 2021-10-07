import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHUANG Yiwei on 2021/10/7
 */
public class LengthOfLastWord58 {

    public static int lengthOfLastWord(String s) {
        Pattern pattern = Pattern.compile("([A-Za-z]+)");
        Matcher matcher = pattern.matcher(s);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list.get(list.size() - 1).length();
    }

    public static int lengthOfLastWordOp(String s) {
        s = s.trim();
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        String str = "This order was placed for QT3000! OK?";

        System.out.println(lengthOfLastWord(str));
        System.out.println(lengthOfLastWordOp(str));
    }
}
