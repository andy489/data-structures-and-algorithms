// https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/

// Solution: Bitwise Trie — O(n) time, O(n) space
class Solution {
    private static final int BITS = 31;
    private int[][] trie;
    private int trieSize;

    private void insert(int num) {
        int node = 0;
        for (int bit = BITS; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            if (trie[node][b] == 0) {
                trie[node][b] = ++trieSize;
            }
            node = trie[node][b];
        }
    }

    private int maxXorWith(int num) {
        int node = 0;
        int result = 0;
        for (int bit = BITS; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            int want = 1 - b;
            if (trie[node][want] != 0) {
                result |= (1 << bit);
                node = trie[node][want];
            } else {
                node = trie[node][b];
            }
        }
        return result;
    }

    public int findMaximumXOR(int[] nums) {
        int maxNodes = nums.length * (BITS + 1) + 1;
        trie = new int[maxNodes][2];
        trieSize = 0;
        for (int num : nums) {
            insert(num);
        }
        int maxXor = 0;
        for (int num : nums) {
            maxXor = Math.max(maxXor, maxXorWith(num));
        }
        return maxXor;
    }
}

// Solution 2: Bit Masking with HashSet — O(32n) time, O(n) space
class Solution2 {
    public int findMaximumXOR(int[] nums) {
        int maxXor = 0;
        int mask = 0;
        for (int bit = 31; bit >= 0; bit--) {
            mask |= (1 << bit);
            Set<Integer> prefixes = new HashSet<>();
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            int candidate = maxXor | (1 << bit);
            for (int prefix : prefixes) {
                if (prefixes.contains(candidate ^ prefix)) {
                    maxXor = candidate;
                    break;
                }
            }
        }
        return maxXor;
    }
}
