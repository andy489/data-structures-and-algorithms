// https://leetcode.com/problems/maximum-strong-pair-xor-ii/

// Solution: Trie with Sliding Window — O(n log C) time, O(n log C) space
class Solution {
    private static final int BITS = 20;
    private int[][] children;
    private int[] cnt;
    private int trieSize;

    private void init(int maxNodes) {
        children = new int[maxNodes][2];
        cnt = new int[maxNodes];
        trieSize = 1;
    }

    private void update(int num, int delta) {
        int node = 0;
        for (int i = BITS - 1; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (children[node][bit] == 0) {
                children[node][bit] = trieSize++;
            }
            node = children[node][bit];
            cnt[node] += delta;
        }
    }

    private int query(int num) {
        int node = 0;
        int result = 0;
        for (int i = BITS - 1; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int want = 1 - bit;
            if (children[node][want] != 0 && cnt[children[node][want]] > 0) {
                result |= (1 << i);
                node = children[node][want];
            } else {
                node = children[node][bit];
            }
        }
        return result;
    }

    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        init(n * (BITS + 1) + 5);
        int ans = 0;
        int l = 0;
        for (int r = 0; r < n; r++) {
            update(nums[r], 1);
            while (nums[l] * 2 < nums[r]) {
                update(nums[l], -1);
                l++;
            }
            ans = Math.max(ans, query(nums[r]));
        }
        return ans;
    }
}
