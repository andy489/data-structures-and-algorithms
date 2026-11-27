// https://leetcode.com/problems/previous-permutation-with-one-swap/

// Solution: Greedy — O(n) time, O(1) space
class Solution {
    public int[] prevPermOpt1(int[] arr) {
        int n = arr.length;
        int i = n - 2;
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }
        if (i < 0) {
            return arr;
        }
        int j = n - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }
        while (j > 0 && arr[j] == arr[j - 1]) {
            j--;
        }
        int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        return arr;
    }
}
