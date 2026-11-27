// https://leetcode.com/problems/maximum-xor-with-an-element-from-array/

// Solution: Offline Processing + Trie — O((n + q) log(max)) time, O(n) space
class Solution {
    private int[][] trie = new int[6400000][2];
    private int trieSize = 1;

    private void insert(int num) {
        int node = 0;
        for (int i = 29; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (trie[node][bit] == 0) {
                trie[node][bit] = trieSize++;
            }
            node = trie[node][bit];
        }
    }

    private int queryMax(int x) {
        int node = 0;
        int result = 0;
        for (int i = 29; i >= 0; i--) {
            int bit = (x >> i) & 1;
            int want = 1 - bit;
            if (trie[node][want] != 0) {
                result |= (1 << i);
                node = trie[node][want];
            } else {
                node = trie[node][bit];
            }
        }
        return result;
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int q = queries.length;
        Integer[] qIdx = new Integer[q];
        for (int i = 0; i < q; i++) {
            qIdx[i] = i;
        }
        Arrays.sort(qIdx, (a, b) -> queries[a][1] - queries[b][1]);
        int[] answer = new int[q];
        int ni = 0;
        for (int qi : qIdx) {
            int x = queries[qi][0];
            int m = queries[qi][1];
            while (ni < nums.length && nums[ni] <= m) {
                insert(nums[ni++]);
            }
            if (ni == 0) {
                answer[qi] = -1;
            } else {
                answer[qi] = queryMax(x);
            }
        }
        return answer;
    }
}
