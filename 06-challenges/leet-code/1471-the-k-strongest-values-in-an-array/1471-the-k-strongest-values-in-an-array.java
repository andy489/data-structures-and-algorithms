// https://leetcode.com/problems/the-k-strongest-values-in-an-array/

// Solution: Sort + Two Pointers — O(n log n) time, O(n) space
class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length, m = arr[(n-1)/2];
        int[] res = new int[k];
        int l = 0, r = n - 1;
        for (int i = 0; i < k; i++) {
            if (arr[r] - m >= m - arr[l]) res[i] = arr[r--];
            else res[i] = arr[l++];
        }
        return res;
    }
}
