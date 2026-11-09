# 1000. Minimum Cost to Merge Stones — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-to-merge-stones/

---

## Feasibility Check

Every single merge operation takes `k` piles and turns them into `1` pile. So the pile count drops by exactly `k - 1` each time.

Starting from `n` piles, you want to reach `1` pile. That means you need to reduce the count by exactly `n - 1`.

Since each merge reduces by `k - 1`, after `t` merges the total reduction is `t * (k - 1)`. So you need:

```
t * (k - 1) = n - 1
```

This has an integer solution for `t` only when `(n - 1)` is exactly divisible by `(k - 1)`:

```
(n - 1) % (k - 1) == 0  →  possible
otherwise               →  return -1
```

**Example:** `n = 4, k = 3` → each merge reduces count by 2. Start: 4 piles → after 1 merge: 2 piles → stuck, cannot merge 2 piles when `k = 3`. Formally: `(4-1) % (3-1) = 3 % 2 = 1 ≠ 0` → `-1`.

---

## Solution: Interval DP with Prefix Sums — O(n³/k) time, O(n²) space

### Core Insight

We use **interval DP**: `dp[i][j]` = minimum cost to reduce the subarray `stones[i..j]` to as few piles as possible.

How many piles can `stones[i..j]` be reduced to? A segment of length `len = j - i + 1` can be reduced to `m` piles where `m = (len - 1) % (k - 1) + 1`. This is the irreducible minimum — you cannot do better without violating the k-merge rule.

In particular, `dp[i][j]` represents the cost to reduce `stones[i..j]` down to exactly that minimum number of piles. When that minimum is 1 (i.e. `(j - i) % (k - 1) == 0`), we add an extra `sum(i..j)` because the final merge that creates that one pile has a cost.

### Prefix Sums

To get `sum(i..j)` in O(1), precompute a prefix sum array:
```
prefix[0] = 0
prefix[i] = stones[0] + stones[1] + ... + stones[i-1]
sum(i..j) = prefix[j+1] - prefix[i]
```

### DP Recurrence

For every subarray `stones[i..j]`, try every split point `m` that steps by `k-1` (each left part `stones[i..m]` can be fully reduced to 1 pile):

```
dp[i][j] = min over m in {i, i+(k-1), i+2(k-1), ..., j-1} of:
               dp[i][m] + dp[m+1][j]
```

After trying all splits, if the entire segment `stones[i..j]` can itself be merged into 1 pile (i.e. `(j - i) % (k - 1) == 0`), add `sum(i..j)` to account for the final merge:

```
if (j - i) % (k - 1) == 0:
    dp[i][j] += sum(i..j)
```

### Why step by `k-1`?

The left part `stones[i..m]` must be reducible to exactly 1 pile (so it can participate in a k-merge with what's to its right). A segment of length `len` reduces to 1 pile iff `(len - 1) % (k - 1) == 0`, i.e. `len = 1 + t*(k-1)` for some integer `t`. So valid split points `m` satisfy `(m - i) % (k - 1) == 0`, which means `m` steps from `i` in increments of `k - 1`.

---

## Worked Example — `stones = [3,5,1,2,6], k = 3`

**Prefix sums:** `[0, 3, 8, 9, 11, 17]`

**Feasibility:** `(5 - 1) % (3 - 1) = 4 % 2 = 0` → possible ✓

**Base cases:** all `dp[i][i] = 0` (a single pile costs nothing).

**Fill by length:**

- Length 2: `dp[i][i+1]` — step size is `k-1=2`, no valid split within length 2 that keeps left part at length ≥1 and steps by 2 → stays 0. `(1) % 2 ≠ 0` so no extra sum added.

- Length 3 (segments of length 3, reducible to 1 pile since `(3-1)%2=0`):
  - `dp[0][2]` (stones `[3,5,1]`): split at `m=0`: `dp[0][0] + dp[1][2] = 0 + 0 = 0`. Add `sum(0..2) = 9`. → `dp[0][2] = 9`
  - `dp[1][3]` (stones `[5,1,2]`): split at `m=1`: `0 + 0 = 0`. Add `sum(1..3) = 8`. → `dp[1][3] = 8`
  - `dp[2][4]` (stones `[1,2,6]`): split at `m=2`: `0 + 0 = 0`. Add `sum(2..4) = 9`. → `dp[2][4] = 9`

- Length 5 (full array, reducible to 1 pile since `(5-1)%2=0`):
  - `dp[0][4]` (stones `[3,5,1,2,6]`): try splits at `m=0` and `m=2`:
    - `m=0`: `dp[0][0] + dp[1][4]`
      - `dp[1][4]` (stones `[5,1,2,6]`, length 4, `(3)%2≠0` → reduces to 2 piles): split at `m=1` and `m=3`:
        - `m=1`: `dp[1][1] + dp[2][4] = 0 + 9 = 9`
        - `m=3`: `dp[1][3] + dp[4][4] = 8 + 0 = 8`
        - `dp[1][4] = 8` (no extra sum since not reducible to 1)
      - So `m=0` gives `0 + 8 = 8`
    - `m=2`: `dp[0][2] + dp[3][4] = 9 + 0 = 9`
    - Best: `8`. Add `sum(0..4) = 17`. → `dp[0][4] = 8 + 17 = 25` ✓

**Answer: 25** ✓

---

**Complexity:**

| | |
|---|---|
| Time  | O(n³ / k) — O(n²) states, each with O(n/k) split points |
| Space | O(n²) — the DP table |
