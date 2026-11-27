// https://leetcode.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/

// Solution: Next Permutation × k + Adjacent Swap Count — O(k·n + n^2) time, O(n) space
class Solution {
    public int getMinSwaps(String num, int k) {
        char[] target = num.toCharArray();
        for (int i = 0; i < k; i++) {
            nextPermutation(target);
        }
        char[] curr = num.toCharArray();
        int swaps = 0;
        int n = curr.length;
        for (int i = 0; i < n; i++) {
            if (curr[i] != target[i]) {
                int j = i + 1;
                while (curr[j] != target[i]) {
                    j++;
                }
                while (j > i) {
                    char tmp = curr[j];
                    curr[j] = curr[j - 1];
                    curr[j - 1] = tmp;
                    j--;
                    swaps++;
                }
            }
        }
        return swaps;
    }

    private void nextPermutation(char[] arr) {
        int n = arr.length, i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        // reverse from i+1 to end
        int lo = i + 1, hi = n - 1;
        while (lo < hi) {
            char tmp = arr[lo];
            arr[lo] = arr[hi];
            arr[hi] = tmp;
            lo++;
            hi--;
        }
    }
}
