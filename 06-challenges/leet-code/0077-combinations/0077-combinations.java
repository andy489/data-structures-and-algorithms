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

// Solution4: Next-combination iteration — O(C(n,k)·k) time, O(k) space
// Maintain a k-element array and advance it lexicographically, like next_permutation.
class Solution4 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] combo = new int[k];
        for (int i = 0; i < k; i++) {
            combo[i] = i + 1; // start: [1, 2, ..., k]
        }
        while (true) {
            List<Integer> current = new ArrayList<>();
            for (int v : combo) {
                current.add(v);
            }
            result.add(current);
            // find rightmost index that can still be incremented
            int i = k - 1;
            while (i >= 0 && combo[i] == n - (k - 1 - i)) {
                i--;
            }
            if (i < 0) {
                break; // all combinations exhausted
            }
            combo[i]++;
            for (int j = i + 1; j < k; j++) {
                combo[j] = combo[j - 1] + 1; // reset suffix to smallest valid values
            }
        }
        return result;
    }
}

// Solution5: Pascal's rule decomposition — O(C(n,k)·k) time, O(k) recursion depth
// C(n,k) = C(n-1,k-1) + C(n-1,k): either include n or don't.
class Solution5 {
    public List<List<Integer>> combine(int n, int k) {
        if (k == 0) {
            List<List<Integer>> base = new ArrayList<>();
            base.add(new ArrayList<>());
            return base; // one combination: the empty set
        }
        if (n == k) {
            List<Integer> all = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                all.add(i);
            }
            List<List<Integer>> base = new ArrayList<>();
            base.add(all);
            return base; // one combination: take everything
        }
        // combinations that include n: combine(n-1, k-1) with n appended
        List<List<Integer>> withN = combine(n - 1, k - 1);
        for (List<Integer> combo : withN) {
            combo.add(n);
        }
        // combinations that exclude n: combine(n-1, k)
        List<List<Integer>> withoutN = combine(n - 1, k);
        withN.addAll(withoutN);
        return withN;
    }
}
