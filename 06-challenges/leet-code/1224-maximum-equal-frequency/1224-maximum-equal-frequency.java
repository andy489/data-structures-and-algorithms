// https://leetcode.com/problems/maximum-equal-frequency/

// Solution: Frequency Tracking — O(n) time, O(n) space
// Solution: Frequency Tracking — O(n) time, O(n) space
class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>(), cntCnt = new HashMap<>();
        int maxFreq = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int old = count.getOrDefault(x, 0);
            if (old > 0) cntCnt.merge(old, -1, Integer::sum);
            count.put(x, old + 1);
            cntCnt.merge(old + 1, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, old + 1);
            int len = i + 1;
            if (maxFreq == 1 ||
                maxFreq * cntCnt.get(maxFreq) == len - 1 ||
                (maxFreq + 1) * 1 == len ||
                maxFreq * cntCnt.get(maxFreq) == len && cntCnt.get(maxFreq) == 1) {
                res = len;
            }
        }
        return res;
    }
}
