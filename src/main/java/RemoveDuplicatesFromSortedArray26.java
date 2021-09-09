/**
 * O(1) extra memory usage.
 *
 * @author ZHUANG Yiwei on 2021/9/9
 */
public class RemoveDuplicatesFromSortedArray26 {

    public static int removeDuplicates(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            int j;
            for (j = i + 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    break;
                }
            }
            nums[k] = nums[i];
            i = j - 1;
            k++;
        }

        return k;
    }

    public static int removeDuplicatesOp(int[] nums) {
        int temp = 0;

        if (nums.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[temp] != nums[i]) {
                nums[++temp] = nums[i];
            }
        }
        return temp + 1;
    }

    public static void printIntArray(int[] ar) {
        StringBuilder sb = new StringBuilder();
        for (int i : ar) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        int[] a = new int[]{
                5, 6, 7, 7, 8, 8, 9, 999, 1000
        };
        printIntArray(a);
        System.out.println(removeDuplicates(a));
        printIntArray(a);
    }

}
