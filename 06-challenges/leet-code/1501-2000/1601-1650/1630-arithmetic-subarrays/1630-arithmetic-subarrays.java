// https://leetcode.com/problems/arithmetic-subarrays/

// Solution: Sort + Check per Query — O(m * k log k) time, O(k) space
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        for (int q = 0; q < l.length; q++) {
            int[] sub = Arrays.copyOfRange(nums, l[q], r[q] + 1);
            Arrays.sort(sub);
            boolean ok = true;
            int diff = sub[1] - sub[0];
            for (int i = 2; i < sub.length; i++) {
                if (sub[i] - sub[i - 1] != diff) {
                    ok = false;
                    break;
                }
            }
            ans.add(ok);
        }
        return ans;
    }
}
