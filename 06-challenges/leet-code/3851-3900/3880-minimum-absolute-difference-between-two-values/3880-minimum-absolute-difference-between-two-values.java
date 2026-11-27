// https://leetcode.com/problems/minimum-absolute-difference-between-two-values/

class Solution {
    public int minAbsDiff(int[] nums) {
        List<Integer> ones = new ArrayList<>();
        List<Integer> twos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones.add(i);
            } else if (nums[i] == 2) {
                twos.add(i);
            }
        }
        if (ones.isEmpty() || twos.isEmpty()) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < ones.size() && j < twos.size()) {
            ans = Math.min(ans, Math.abs(ones.get(i) - twos.get(j)));
            if (ones.get(i) < twos.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}
