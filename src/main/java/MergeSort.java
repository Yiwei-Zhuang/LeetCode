/**
 * @author ZHUANG Yiwei on 2021/8/31
 */
public class MergeSort {

    private void sort(int[] array, int l, int m, int r) {
        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];
        // Hard copy
        for (int i = 0; i < left.length; i++) {
            left[i] = array[l + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = array[m + i + 1];
        }
        int i = 0; // left part index
        int j = 0; // right part index
        int k = l; // start index of array[]
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        // Complement
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }
    }

    // Divide until only one element left.
    private void merge(int[] array, int l, int r) {
        if (l < r) {
            merge(array, l, l + (r - l) / 2);
            merge(array, l + (r - l) / 2 + 1, r);
            sort(array, l, l + (r - l) / 2, r);
        }
    }

    private static void printIntArray(int[] array) {
        String ret = "";
        for (int i : array) {
            ret = ret + i + " ";
        }
        ret = ret.substring(0, ret.length() - 1);
        System.out.println(ret);
    }

    public static void main(String[] args) {
        MergeSort mg = new MergeSort();
        int[] array = new int[]{0, 10, 3, 5, 23, 123, 546, 3425, 34521, 4, 523, 1, 2, 4, 2412, 41, 24, 532, 35, 35, 1, 5, 35, 24, -124, 12, -24};
        printIntArray(array);
        mg.merge(array, 0, array.length - 1);
        printIntArray(array);

    }
}
