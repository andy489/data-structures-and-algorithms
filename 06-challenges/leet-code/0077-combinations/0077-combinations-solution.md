# 77. Combinations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/combinations/

---

## Solution: Backtracking — O(C(n,k)·k) time, O(k) space

**Idea:**

Build each combination one number at a time. At each recursive call we have a `start` value — the smallest number we're still allowed to pick — and we try every number from `start` to `n`. When the current combination reaches size `k` we record it and return.

Because we only ever pick numbers ≥ `start`, we never revisit a number we already placed, so we get combinations (unordered, no repeats) naturally without any extra deduplication.

**Pruning:** there's no point trying `start` values where fewer than `k - current size` numbers remain in `[start, n]`. So the loop runs only while `n - i + 1 >= k - current.size()`, i.e. `i <= n - (k - current.size()) + 1`.

**Algorithm:**
1. Start backtracking from `start = 1` with an empty `current` list.
2. If `current.size() == k`: add a copy to `result` and return.
3. For `i` from `start` to `n - (k - current.size()) + 1`:
   - Add `i` to `current`.
   - Recurse with `start = i + 1`.
   - Remove the last element (backtrack).

**Example trace:** `n = 4, k = 2`

```
backtrack(1, [])
  add 1 → backtrack(2, [1])
    add 2 → [1,2] ✓  add 3 → [1,3] ✓  add 4 → [1,4] ✓
  add 2 → backtrack(3, [2])
    add 3 → [2,3] ✓  add 4 → [2,4] ✓
  add 3 → backtrack(4, [3])
    add 4 → [3,4] ✓
  add 4 → pruned (n - 4 + 1 = 1 < k - 1 = 1, so loop ends at 3)
```

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k) — C(n,k) combinations, each copied in O(k) |
| Space | O(k) recursion depth + O(C(n,k)·k) for the output |

---

## Solution 2: Bitmask enumeration — O(2^n·n) time, O(k) space

**Idea:**

Each subset of `{1..n}` can be represented as an `n`-bit integer. Bit `i` being set means number `i+1` is included. We iterate all `2^n` masks and keep only those with exactly `k` bits set — those are the valid combinations.

For `n = 4, k = 2`, the masks with 2 bits set are:

```
0011 → {1,2}   0101 → {1,3}   0110 → {2,3}
1001 → {1,4}   1010 → {2,4}   1100 → {3,4}
```

**Algorithm:**
1. For each `mask` from `0` to `2^n - 1`:
   - If `Integer.bitCount(mask) != k`: skip.
   - Otherwise collect all set-bit positions into a combination (bit `i` → number `i+1`).
2. Return all collected combinations.

**Complexity:**

| | |
|---|---|
| Time | O(2^n·n) — check all subsets, scan n bits each |
| Space | O(k) per combination (output excluded) |
