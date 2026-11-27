// https://leetcode.com/problems/count-indices-with-opposite-parity/
class Solution {
    public int[] countIndices(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int oddCount = 0, evenCount = 0;
        for (int v : nums) {
            if (v % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        int seenOdd = 0, seenEven = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                seenEven++;
            } else {
                seenOdd++;
            }
            int remainingOdd = oddCount - seenOdd;
            int remainingEven = evenCount - seenEven;
            if (nums[i] % 2 == 0) {
                answer[i] = remainingOdd;
            } else {
                answer[i] = remainingEven;
            }
        }
        return answer;
    }
}
