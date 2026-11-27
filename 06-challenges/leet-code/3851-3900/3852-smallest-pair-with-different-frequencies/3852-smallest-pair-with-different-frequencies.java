// https://leetcode.com/problems/smallest-pair-with-different-frequencies/

class Solution {
    public int[] smallestPair(int[] nums) {
        int[] freq = new int[101];
        for (int n : nums) {
            freq[n]++;
        }
        int[] vals = java.util.Arrays.stream(nums).distinct().sorted().toArray();
        for (int i = 0; i < vals.length; i++) {
            for (int j = i + 1; j < vals.length; j++) {
                if (freq[vals[i]] != freq[vals[j]]) {
                    return new int[]{vals[i], vals[j]};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
