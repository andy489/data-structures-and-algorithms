// https://leetcode.com/problems/count-pairs-with-xor-in-a-range/

// Solution: Trie + Prefix Count — O(n * log(max)) time, O(n * log(max)) space
class Solution {
    private int[][] trie;
    private int[] count;
    private int idx;

    private void init(int n) {
        trie = new int[n * 15][2];
        count = new int[n * 15];
        idx = 1;
    }

    private void insert(int num) {
        int node = 0;
        for (int i = 14; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (trie[node][bit] == 0) {
                trie[node][bit] = idx++;
            }
            node = trie[node][bit];
            count[node]++;
        }
    }

    private int countLess(int num, int limit) {
        int node = 0, res = 0;
        for (int i = 14; i >= 0; i--) {
            int nb = (num >> i) & 1;
            int lb = (limit >> i) & 1;
            if (lb == 1) {
                if (trie[node][nb] != 0) {
                    res += count[trie[node][nb]];
                }
                node = trie[node][nb ^ 1];
            } else {
                node = trie[node][nb];
            }
            if (node == 0) {
                break;
            }
        }
        return res;
    }

    public int countPairs(int[] nums, int low, int high) {
        init(nums.length);
        int ans = 0;
        for (int num : nums) {
            ans += countLess(num, high + 1) - countLess(num, low);
            insert(num);
        }
        return ans;
    }
}
