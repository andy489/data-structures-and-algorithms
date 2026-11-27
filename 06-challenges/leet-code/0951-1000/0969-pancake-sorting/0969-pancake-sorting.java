// https://leetcode.com/problems/pancake-sorting/

// Solution: Selection Sort with Flips — O(n²) time, O(n) space
class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int size = arr.length; size > 1; size--) {
            int maxIdx = 0;
            for (int i = 1; i < size; i++) {
                if (arr[i] > arr[maxIdx]) { maxIdx = i; }
            }
            if (maxIdx == size - 1) { continue; }
            if (maxIdx != 0) {
                flip(arr, maxIdx);
                res.add(maxIdx + 1);
            }
            flip(arr, size - 1);
            res.add(size);
        }
        return res;
    }

    private void flip(int[] arr, int k) {
        int lo = 0, hi = k;
        while (lo < hi) {
            int tmp = arr[lo];
            arr[lo++] = arr[hi];
            arr[hi--] = tmp;
        }
    }
}
