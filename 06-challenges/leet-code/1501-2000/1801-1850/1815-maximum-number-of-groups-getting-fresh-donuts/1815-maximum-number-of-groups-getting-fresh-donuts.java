// https://leetcode.com/problems/maximum-number-of-groups-getting-fresh-donuts/

// Solution: Greedy + Bitmask DP — O(2^b * b) time, O(2^b) space
class Solution {
    private int batchSize;
    private int[] freq;
    private Map<Long, Integer> memo;

    private long encode() {
        long key = 0;
        for (int i = 0; i < batchSize; i++) {
            key = key * 100 + freq[i];
        }
        return key;
    }

    private int dp(int cur) {
        long key = encode();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int best = 0;
        for (int i = 1; i < batchSize; i++) {
            if (freq[i] > 0) {
                freq[i]--;
                int next = (cur + i) % batchSize;
                int happy = (next == 0 ? 1 : 0);
                best = Math.max(best, happy + dp(next));
                freq[i]++;
            }
        }
        memo.put(key, best);
        return best;
    }

    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        this.freq = new int[batchSize];
        this.memo = new HashMap<>();
        int happy = 0;
        for (int g : groups) {
            freq[g % batchSize]++;
        }
        happy += freq[0];
        freq[0] = 0;
        for (int i = 1; i <= batchSize / 2; i++) {
            int j = batchSize - i;
            if (i == j) {
                happy += freq[i] / 2;
                freq[i] %= 2;
            } else {
                int pairs = Math.min(freq[i], freq[j]);
                happy += pairs;
                freq[i] -= pairs;
                freq[j] -= pairs;
            }
        }
        return happy + dp(0);
    }
}
