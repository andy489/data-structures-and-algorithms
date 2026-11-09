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

**Feasibility:** `(5 - 1) % (3 - 1) = 4 % 2 = 0` → possible ✓

**Prefix sums:** `prefix = [0, 3, 8, 9, 11, 17]`

Each entry is a running total: `prefix[i] = stones[0] + ... + stones[i-1]`.
The cost of the final merge over a segment `stones[i..j]` equals the total stones in it — computed instantly as `prefix[j+1] - prefix[i]`:

```
sum(0..2) = prefix[3] - prefix[0] = 9  - 0  = 9   (stones [3,5,1])
sum(1..3) = prefix[4] - prefix[1] = 11 - 3  = 8   (stones [5,1,2])
sum(2..4) = prefix[5] - prefix[2] = 17 - 8  = 9   (stones [1,2,6])
sum(0..4) = prefix[5] - prefix[0] = 17 - 0  = 17  (stones [3,5,1,2,6])
```

These sums are added to `dp[i][j]` whenever a segment can be collapsed to 1 pile — they represent the cost of that final k-way merge.

**Base cases:** all `dp[i][i] = 0` (a single pile costs nothing to "merge").

**Fill by length** (the outer loop iterates `len` from `k` up to `n`; we precompute every subarray from shortest to longest so that when we need `dp[i][m]` or `dp[m+1][j]` for a longer segment they are already ready):

---

**Length 2** — 4 segments: `[0,1]`, `[1,2]`, `[2,3]`, `[3,4]`

With `k=3` you need 3 piles to merge, so a 2-pile segment cannot be reduced further on its own. The only split `m=i` gives `dp[i][i] + dp[i+1][i+1] = 0+0 = 0` — no merge happened, the two piles just sit waiting to be part of a larger merge later. `(j-i) % (k-1) = 1 % 2 ≠ 0` confirms the segment cannot reach 1 pile, so no sum is added.

```
dp[0][1] = 0    dp[1][2] = 0    dp[2][3] = 0    dp[3][4] = 0
```

---

**Length 3** — 3 segments: `[0,2]`, `[1,3]`, `[2,4]`

Length 3 with `k=3`: `(3-1) % (3-1) = 0` → this segment CAN be collapsed to 1 pile. The only split is `m=i` (left side is 1 pile, right side is 2 piles that together come to `k=3` total). After minimising splits, we add the full segment sum as the cost of the final 3-way merge.

- `dp[0][2]` (stones `[3,5,1]`):
  - split `m=0`: `dp[0][0] + dp[1][2] = 0 + 0 = 0`
  - `(2-0) % 2 = 0` → add `sum(0..2) = prefix[3]-prefix[0] = 9`
  - **`dp[0][2] = 9`**

- `dp[1][3]` (stones `[5,1,2]`):
  - split `m=1`: `dp[1][1] + dp[2][3] = 0 + 0 = 0`
  - add `sum(1..3) = prefix[4]-prefix[1] = 8`
  - **`dp[1][3] = 8`**

- `dp[2][4]` (stones `[1,2,6]`):
  - split `m=2`: `dp[2][2] + dp[3][4] = 0 + 0 = 0`
  - add `sum(2..4) = prefix[5]-prefix[2] = 9`
  - **`dp[2][4] = 9`**

---

**Length 4** — 2 segments: `[0,3]`, `[1,4]`

Length 4 with `k=3`: `(4-1) % (3-1) = 3 % 2 = 1 ≠ 0` → this segment can only be reduced to 2 piles (not 1). No sum is added. Splits step by `k-1=2`, so `m ∈ {i, i+2}`.

- `dp[0][3]` (stones `[3,5,1,2]`):
  - split `m=0`: `dp[0][0] + dp[1][3] = 0 + 8 = 8`
  - split `m=2`: `dp[0][2] + dp[3][3] = 9 + 0 = 9`
  - min = 8, `(3-0) % 2 ≠ 0` → no sum added
  - **`dp[0][3] = 8`**

- `dp[1][4]` (stones `[5,1,2,6]`):
  - split `m=1`: `dp[1][1] + dp[2][4] = 0 + 9 = 9`
  - split `m=3`: `dp[1][3] + dp[4][4] = 8 + 0 = 8`
  - min = 8, `(4-1) % 2 ≠ 0` → no sum added
  - **`dp[1][4] = 8`**

---

**Length 5** — 1 segment: `[0,4]` (the full array)

`(5-1) % (3-1) = 0` → can be collapsed to 1 pile. Splits: `m ∈ {0, 2}`.

- `dp[0][4]` (stones `[3,5,1,2,6]`):
  - split `m=0`: `dp[0][0] + dp[1][4] = 0 + 8 = 8`
  - split `m=2`: `dp[0][2] + dp[3][4] = 9 + 0 = 9`
  - min = 8, `(4-0) % 2 = 0` → add `sum(0..4) = prefix[5]-prefix[0] = 17`
  - **`dp[0][4] = 8 + 17 = 25`** ✓

**Answer: 25** ✓

---

**Complexity:**

| | |
|---|---|
| Time  | O(n³ / k) |
| Space | O(n²) |

**Time complexity breakdown:**

The three nested loops:

1. **Outer loop** — `len` from `k` to `n`: at most `n` iterations.
2. **Middle loop** — starting index `i` from `0` to `n - len`: at most `n` iterations.
3. **Inner loop** — split point `m` from `i` to `j - 1` stepping by `k - 1`:

   For a segment of length `len`, the number of valid split points is:
   ```
   floor((len - 1) / (k - 1))
   ```
   Averaged over all segment lengths (from `k` to `n`), this is approximately `n / k`.

Multiplying: `n` (lengths) × `n` (start positions) × `n/k` (splits) = **O(n³ / k)**.

When `k = 2` (binary merge) this is O(n³) — the classic interval DP. When `k` is large the inner loop has fewer valid split points, so the algorithm speeds up proportionally.

**Space complexity:** The DP table is `n × n` entries → **O(n²)**. The prefix array is O(n) and is dominated by the table.
