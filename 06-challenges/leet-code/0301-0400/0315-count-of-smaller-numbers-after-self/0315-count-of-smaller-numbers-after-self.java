// https://leetcode.com/problems/count-of-smaller-numbers-after-self/

// Solution: Merge Sort — O(n log n) time, O(n) space
class Solution {
    private int[] counts;
    private int[][] indexed;

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        counts = new int[n];
        indexed = new int[n][2];
        for (int i = 0; i < n; i++) {
            indexed[i][0] = nums[i];
            indexed[i][1] = i;
        }
        mergeSort(0, n - 1);
        List<Integer> result = new ArrayList<>();
        for (int c : counts) {
            result.add(c);
        }
        return result;
    }

    private void mergeSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(left, mid);
        mergeSort(mid + 1, right);
        merge(left, mid, right);
    }

    private void merge(int left, int mid, int right) {
        int[][] temp = new int[right - left + 1][2];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            if (indexed[i][0] <= indexed[j][0]) {
                counts[indexed[i][1]] += j - (mid + 1);
                temp[k++] = indexed[i++];
            } else {
                temp[k++] = indexed[j++];
            }
        }
        while (i <= mid) {
            counts[indexed[i][1]] += j - (mid + 1);
            temp[k++] = indexed[i++];
        }
        while (j <= right) {
            temp[k++] = indexed[j++];
        }
        for (int t = 0; t < temp.length; t++) {
            indexed[left + t] = temp[t];
        }
    }
}
