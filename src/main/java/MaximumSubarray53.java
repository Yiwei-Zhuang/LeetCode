import sun.rmi.server.InactiveGroupException;

/**
 * @author ZHUANG Yiwei on 2021/9/19
 */
public class MaximumSubarray53 {

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            max = Math.max(cur, max);
            for(int j = i+1; j < nums.length; j++) {
                cur += nums[j];
                max = Math.max(max, cur);
            }
        }
        return max;
    }


    // Optimized with dynamic programming.
    public static int maxSubArrayOp(int[] nums) {
        int max = nums[0];
        int currentMax = 0;
        for(int i = 0; i < nums.length; i++) {
            currentMax = Math.max(nums[i], nums[i] + currentMax);
            max = Math.max(max, currentMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = new int[]{-2, -1};
        System.out.println(maxSubArrayOp(nums));
    }
}
