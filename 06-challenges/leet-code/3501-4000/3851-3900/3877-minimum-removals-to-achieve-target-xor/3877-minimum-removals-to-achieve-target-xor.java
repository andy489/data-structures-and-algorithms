// https://leetcode.com/problems/minimum-removals-to-achieve-target-xor/

class Solution {
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        int half = n / 2;
        // left half: enumerate all subsets
        Map<Integer, Integer> leftMap = new HashMap<>();
        for (int mask = 0; mask < (1 << half); mask++) {
            int xor = 0, cnt = 0;
            for (int i = 0; i < half; i++) {
                if ((mask >> i & 1) == 1) {
                    xor ^= nums[i];
                    cnt++;
                }
            }
            leftMap.put(xor, Math.max(leftMap.getOrDefault(xor, -1), cnt));
        }

        int maxKept = -1;
        int rightLen = n - half;
        for (int mask = 0; mask < (1 << rightLen); mask++) {
            int xor = 0, cnt = 0;
            for (int i = 0; i < rightLen; i++) {
                if ((mask >> i & 1) == 1) {
                    xor ^= nums[half + i];
                    cnt++;
                }
            }
            int need = xor ^ target;
            if (leftMap.containsKey(need)) {
                maxKept = Math.max(maxKept, cnt + leftMap.get(need));
            }
        }

        return maxKept == -1 ? -1 : n - maxKept;
    }
}
