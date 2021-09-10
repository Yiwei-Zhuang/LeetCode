/**
 * @author ZHUANG Yiwei on 2021/9/10
 */
public class RemoveElementInPlace27 {


    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            while (i < nums.length && val == nums[i]) {
                i++;
            }
            if (i < nums.length) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
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
                2, 3, 2, 2, 3,3,2,3,4,4,56,4,32,1,4,23,4,5,2,3,2
        };
        int val = 2;
        printIntArray(a);
        System.out.println(removeElement(a, val));
        printIntArray(a);
    }

}
