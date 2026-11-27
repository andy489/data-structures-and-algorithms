// https://leetcode.com/problems/minimum-cost-to-make-arrays-identical/

class Solution {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;
        // Cost without rearranging
        long costNoSort = 0;
        for (int i = 0; i < n; i++) {
            costNoSort += Math.abs(arr[i] - brr[i]);
        }
        // Cost with sorting arr (rearranging costs k)
        int[] sortedArr = arr.clone();
        int[] sortedBrr = brr.clone();
        Arrays.sort(sortedArr);
        Arrays.sort(sortedBrr);
        long costWithSort = k;
        for (int i = 0; i < n; i++) {
            costWithSort += Math.abs(sortedArr[i] - sortedBrr[i]);
        }
        return Math.min(costNoSort, costWithSort);
    }
}
