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

// Solution2: Pascal's rule decomposition — O(C(n,k)·k) time, O(k) recursion depth
// C(n,k) = C(n-1,k-1) + C(n-1,k): either include n or don't.
class Solution2 {
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

// Solution3: Memoized Pascal decomposition — O(C(n,k)·k) time, O(n·k·C(n,k)·k) space
// Same recurrence as Solution2 but caches results for overlapping subproblems:
// combine(n-2,k-1) is needed by both combine(n-1,k) and combine(n-1,k-1).
class Solution3 {
    private Map<Integer, List<List<Integer>>> memo = new HashMap<>();

    public List<List<Integer>> combine(int n, int k) {
        int key = n * 21 + k; // n,k <= 20: unique key fits in one int
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        List<List<Integer>> result;
        if (k == 0) {
            result = new ArrayList<>();
            result.add(new ArrayList<>());
        } else if (n == k) {
            List<Integer> all = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                all.add(i);
            }
            result = new ArrayList<>();
            result.add(all);
        } else {
            // deep-copy withN so cached lists are not mutated when n is appended
            result = new ArrayList<>();
            for (List<Integer> combo : combine(n - 1, k - 1)) {
                List<Integer> copy = new ArrayList<>(combo);
                copy.add(n);
                result.add(copy);
            }
            result.addAll(combine(n - 1, k));
        }
        memo.put(key, result);
        return result;
    }
}

// Solution4: Bottom-up DP table — O(n·k·C(n,k)·k) time, O(n·k·C(n,k)·k) space
// Build dp[i][j] = all combinations of j numbers from {1..i}, row by row.
// dp[i][j] = (dp[i-1][j-1] with i appended) + dp[i-1][j]  (Pascal identity)
class Solution4 {
    public List<List<Integer>> combine(int n, int k) {
        @SuppressWarnings("unchecked")
        List<List<Integer>>[][] dp = new List[n + 1][k + 1];
        // base: dp[i][0] = {[]} for all i (one way to choose 0 numbers)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new ArrayList<>();
            dp[i][0].add(new ArrayList<>());
        }
        // base: dp[i][j] = {} for j > i (can't choose more than available)
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= k; j++) {
                dp[i][j] = new ArrayList<>();
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                dp[i][j] = new ArrayList<>();
                // include i: take dp[i-1][j-1] and append i to each
                for (List<Integer> combo : dp[i - 1][j - 1]) {
                    List<Integer> copy = new ArrayList<>(combo);
                    copy.add(i);
                    dp[i][j].add(copy);
                }
                // exclude i: copy dp[i-1][j] as-is
                dp[i][j].addAll(dp[i - 1][j]);
            }
        }
        return dp[n][k];
    }
}

// Solution5: BFS queue — O(C(n,k)·k) time, O(C(n,k)·k) space
// Backtracking converted to iterative BFS: each queue entry is a partial
// combination; dequeue, extend by one number, re-enqueue or collect.
class Solution5 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.add(new ArrayList<>());
        while (!queue.isEmpty()) {
            List<Integer> partial = queue.poll();
            int size = partial.size();
            if (size == k) {
                result.add(partial);
                continue;
            }
            int start = partial.isEmpty() ? 1 : partial.get(size - 1) + 1;
            int need = k - size;
            for (int i = start; i <= n - need + 1; i++) { // same pruning as Solution
                List<Integer> next = new ArrayList<>(partial);
                next.add(i);
                queue.add(next);
            }
        }
        return result;
    }
}

// Solution6: Next-combination iteration — O(C(n,k)·k) time, O(k) space
// Maintain a k-element array and advance it lexicographically, like next_permutation.
class Solution6 {
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

// Solution7: Bitmask enumeration — O(2^n·n) time, O(k) space
// Enumerate all 2^n subsets of {1..n} via bitmasks; collect those with exactly k bits set.
class Solution7 {
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

// Solution8: Gosper's Hack — O(C(n,k)·k) time, O(k) space
// Enumerate only the C(n,k) masks with exactly k bits set, skipping all others.
// Given a valid mask, the next mask with the same popcount is computed in O(1).
class Solution8 {
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

// Solution9: Combinatorial number system — O(C(n,k)·k·n) time, O(k) space
// Decode each rank m in [0, C(n,k)) directly into its combination using the
// combinatorial number system: the m-th combination is found by greedily
// choosing the largest c such that C(c, remaining) <= remaining rank.
class Solution9 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int total = comb(n, k);
        for (int m = 0; m < total; m++) {
            result.add(decode(m, n, k));
        }
        return result;
    }

    private List<Integer> decode(int m, int n, int k) {
        List<Integer> combo = new ArrayList<>();
        int remaining = m;
        for (int i = k; i >= 1; i--) {
            // find largest c in [i..n] such that C(c-1, i) <= remaining
            int c = i;
            while (c < n && comb(c, i) <= remaining) {
                c++;
            }
            remaining -= comb(c - 1, i); // subtract C(c-1, i) — combinations skipped
            combo.add(c);
        }
        return combo;
    }

    private int comb(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        k = Math.min(k, n - k);
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }
}

// Solution10: Knuth's Algorithm T (TAOCP 7.2.1.3) — O(C(n,k)·k) time, O(k) space
// Uses a (k+2)-element array with sentinels c[0]=0 and c[k+1]=n+1.
// T1: initialize c[j]=j. T2: visit. T3: find leftmost j where c[j]+1 < c[j+1],
// resetting c[j]=j along the way. T4: if j>k done. T5: c[j]++, goto T2.
class Solution10 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int[] c = new int[k + 2];
        // T1: initialize
        for (int j = 1; j <= k; j++) {
            c[j] = j;
        }
        c[k + 1] = n + 1; // upper sentinel
        while (true) {
            // T2: visit — record current combination
            List<Integer> combo = new ArrayList<>();
            for (int j = 1; j <= k; j++) {
                combo.add(c[j]);
            }
            result.add(combo);
            // T3: find leftmost j where c[j]+1 < c[j+1]; reset c[j]=j as we go
            int j = 1;
            while (j <= k && c[j] + 1 == c[j + 1]) {
                c[j] = j;
                j++;
            }
            // T4: done?
            if (j > k) {
                break;
            }
            // T5: increase
            c[j]++;
        }
        return result;
    }
}
