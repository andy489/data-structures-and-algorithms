// https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/

// Solution: Linear Scan — O(n) time, O(1) space
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for (int v : arr) {
            total += v;
        }
        if (total % 3 != 0) {
            return false;
        }
        int target = total / 3, parts = 0, cur = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            cur += arr[i];
            if (cur == target * (parts + 1)) {
                parts++;
                if (parts == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
