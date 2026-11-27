// https://leetcode.com/problems/binary-trees-with-factors/

// Solution: DP on Sorted Array — O(n²) time, O(n) space
class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        final int MOD = 1_000_000_007;
        Arrays.sort(arr);
        Map<Integer, Long> dp = new HashMap<>();
        for (int x : arr) {
            dp.put(x, 1L);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {
                        dp.merge(arr[i], dp.get(arr[j]) * dp.get(right) % MOD, (a, b) -> (a + b) % MOD);
                    }
                }
            }
        }
        long total = 0;
        for (long v : dp.values()) {
            total = (total + v) % MOD;
        }
        return (int) total;
    }
}
