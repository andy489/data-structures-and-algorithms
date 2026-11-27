// https://leetcode.com/problems/lexicographically-maximum-mex-array/
class Solution {
    public int[] findLexMaxMEXArray(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        int n = nums.length;
        while (start < n) {
            // Find maximum MEX of nums[start..start+k-1] for some k in [1, n-start]
            // Then take the longest prefix achieving that maximum MEX
            int[] freq = new int[n + 1];
            int mex = 0;
            int bestMex = 0;
            int bestEnd = start; // inclusive end
            for (int end = start; end < n; end++) {
                int v = nums[end];
                if (v <= n) {
                    freq[v]++;
                }
                // Update mex
                while (mex <= n && freq[mex] > 0) {
                    mex++;
                }
                if (mex > bestMex) {
                    bestMex = mex;
                    bestEnd = end;
                } else if (mex == bestMex) {
                    // Taking longer prefix with same MEX is better lexicographically
                    // (longer array is lexicographically greater when prefix matches)
                    bestEnd = end;
                }
            }
            result.add(bestMex);
            start = bestEnd + 1;
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
