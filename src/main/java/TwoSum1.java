import java.util.HashMap;

/**
 * @author ZHUANG Yiwei on 2021/8/29
 */
public class TwoSum1 {
    public static int[] twoSum(int[] nums, int target) {
        int[] ret = new int[]{0, 0};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }
        return ret;
    }

    // Optimized with hash
    public static int[] twoSumOp(int nums[], int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer temp = target - nums[i];
            if (hash.containsKey(temp)) {
                return new int[]{i, hash.get(temp)};
            } else {
                hash.put(nums[i], i);
            }
        }
        return new int[2];
    }


    public static void main(String[] args) {
        int[] sums = new int[]{3, 2, 4};

        int[] ret = twoSumOp(sums, 6);
        System.out.println(ret[0] + " " + ret[1]);
    }
}
