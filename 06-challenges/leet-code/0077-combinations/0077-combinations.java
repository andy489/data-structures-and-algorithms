// https://leetcode.com/problems/combinations/

// Solution: Backtracking — O(C(n,k)·k) time, O(k) space
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, 1, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        // prune: need at least (k - current.size()) more numbers from [i, n]
        int need = k - current.size();
        for (int i = start; i <= n - need + 1; i++) {
            current.add(i);
            backtrack(n, k, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

// Solution2: Bitmask enumeration — O(2^n·n) time, O(k) space
// Enumerate all 2^n subsets of {1..n} via bitmasks; collect those with exactly k bits set.
class Solution2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != k) {
                continue;
            }
            List<Integer> combo = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    combo.add(i + 1); // bit i represents number (i+1)
                }
            }
            result.add(combo);
        }
        return result;
    }
}

// Solution3: Gosper's Hack — O(C(n,k)·k) time, O(k) space
// Enumerate only the C(n,k) masks with exactly k bits set, skipping all others.
// Given a valid mask, the next mask with the same popcount is computed in O(1).
class Solution3 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int mask = (1 << k) - 1; // lowest k bits set: 00..0111..1
        int limit = 1 << n;
        while (mask < limit) {
            List<Integer> combo = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    combo.add(i + 1);
                }
            }
            result.add(combo);
            // Gosper's Hack: next permutation of bits with same popcount
            int c = mask & -mask;           // lowest set bit
            int r = mask + c;               // clear the trailing block, set next bit
            mask = (((r ^ mask) >> 2) / c) | r;
        }
        return result;
    }
}
