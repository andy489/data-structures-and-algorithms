// https://leetcode.com/problems/mean-of-array-after-removing-some-elements/

// Solution: Sort and Trim — O(n log n) time, O(1) space
class Solution {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int trim = n / 20;
        double sum = 0;
        for (int i = trim; i < n - trim; i++) {
            sum += arr[i];
        }
        return sum / (n - 2 * trim);
    }
}
