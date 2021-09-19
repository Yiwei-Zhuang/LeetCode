import java.lang.reflect.Array;

/**
 * @author ZHUANG Yiwei on 2021/9/15
 */
public class SearchInsertPosition35 {


    public static int searchInert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        while (tail - head >= 0) {
            int mid = (tail - head) / 2 + head;
            if (nums[mid] > target) {
                tail = mid - 1;
            } else if (nums[mid] < target) {
                head = mid + 1;
            } else {
                return mid;
            }
        }
        return tail + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 5};
        System.out.println(searchInert(nums, 3));

    }
}
