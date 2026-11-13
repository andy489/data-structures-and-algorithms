# 77. Combinations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/combinations/

---

## Solution: Backtracking — O(C(n,k)·k) time, O(k) space

**Idea:**

Build each combination one number at a time. At each recursive call we have a `start` value — the smallest number we're still allowed to pick — and we try every number from `start` to `n`. When the current combination reaches size `k` we record it and return.

Because we only ever pick numbers ≥ `start`, we never revisit a number we already placed, so we get combinations (unordered, no repeats) naturally without any extra deduplication.

**Pruning:** there's no point trying `start` values where fewer than `k - current size` numbers remain in `[start, n]`. So the loop runs only while `i <= n - (k - current.size()) + 1`.

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
  add 4 → pruned (loop ends at 3)
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

---

## Solution 4: Next-combination iteration — O(C(n,k)·k) time, O(k) space

**Idea:**

Maintain a `k`-element array initialized to `[1, 2, …, k]` and advance it to the next combination in lexicographic order, exactly like `std::next_permutation` — but for combinations. No recursion, no bitmasks.

To advance: find the rightmost index `i` where `combo[i]` can still increase (i.e. `combo[i] < n - (k-1-i)`), increment it, then reset every position to its right to the smallest valid values.

**Example trace:** `n = 4, k = 2`

```
[1,2] → [1,3] → [1,4] → [2,3] → [2,4] → [3,4] → done
```

**Algorithm:**
1. Initialize `combo = [1, 2, …, k]`.
2. Record `combo` as a combination.
3. Find rightmost `i` where `combo[i] < n - (k-1-i)`. If none: stop.
4. `combo[i]++`; for each `j > i`: `combo[j] = combo[j-1] + 1`. Go to 2.

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k) — advance and copy each combination |
| Space | O(k) — one working array, no recursion stack |

---

## Solution 5: Pascal's rule decomposition — O(C(n,k)·k) time, O(k) recursion depth

**Idea:**

Use the Pascal's triangle identity: C(n,k) = C(n-1,k-1) + C(n-1,k).

Every combination of `k` numbers from `{1..n}` either includes `n` or doesn't:
- **Includes `n`**: take all combinations of `k-1` numbers from `{1..n-1}` and append `n`.
- **Excludes `n`**: take all combinations of `k` numbers from `{1..n-1}`.

Base cases: `k == 0` → one result (empty list); `n == k` → one result (take all).

**Example:** `n = 4, k = 2`

```
combine(4,2) = combine(3,1) with 4 appended  +  combine(3,2)
             = {[1,4],[2,4],[3,4]}             +  {[1,2],[1,3],[2,3]}
```

**Algorithm:**
1. Base: if `k == 0` return `[[]]`; if `n == k` return `[[1..n]]`.
2. `withN = combine(n-1, k-1)`, append `n` to each.
3. `withoutN = combine(n-1, k)`.
4. Return `withN + withoutN`.

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k) — same output size, each element touched a constant number of times |
| Space | O(k) recursion depth (output excluded) |

---

## Solution 6: Combinatorial number system — O(C(n,k)·k·n) time, O(k) space

**Idea:**

Every integer `m` in `[0, C(n,k))` uniquely identifies a combination via the **combinatorial number system**: the `m`-th combination (0-indexed, lexicographic) is decoded by greedily finding, for each position from left to right, the largest value `c` such that `C(c-1, remaining_slots) ≤ remaining_rank`.

This lets you jump to any combination by rank, without generating all predecessors.

**Decoding rank `m` for `k = 2, n = 4`:**

| rank m | decode | combo |
|---|---|---|
| 0 | C(0,2)=0 ≤ 0, c=1; C(0,1)=0 ≤ 0, c=1 | [1,2] |
| 1 | c=1; C(1,1)=1 > 0 → c=2; rem=0 → c=1 | [1,3] wait... |

More concretely for m=3 (combo [2,3]):
```
i=2: find c where C(c-1,2) <= 3 → c=3 (C(2,2)=1≤3, C(3,2)=3≤3, C(4,2)=6>3); rem=3-3=0; pick 3... 
```
*(The exact arithmetic follows the standard combinatorial number system.)*

**Algorithm:**
1. For each rank `m` from `0` to `C(n,k) - 1`:
   - Decode `m`: for `i` from `k` down to `1`, find the largest `c` in `[i..n]` with `C(c-1, i) ≤ remaining`; subtract `C(c-1, i)` from `remaining`; record `c`.
2. Collect all decoded combinations.

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k·n) — decode each rank in O(k·n) |
| Space | O(k) per combination (output excluded) |

---

## Solution 7: BFS queue — O(C(n,k)·k) time, O(C(n,k)·k) space

**Idea:**

Backtracking rewritten as iterative BFS. A queue holds partial combinations. Each iteration: dequeue a partial, and if it has size `k` collect it; otherwise extend it by one more number and enqueue each extension. The same pruning applies — only extend with values up to `n - (k - size) + 1`.

**Example:** `n = 4, k = 2`

```
Queue: [[]]
Dequeue []: enqueue [1],[2],[3]
Dequeue [1]: enqueue [1,2],[1,3],[1,4]
Dequeue [2]: enqueue [2,3],[2,4]
Dequeue [3]: enqueue [3,4]
Dequeue [1,2]: size==k → collect
Dequeue [1,3]: size==k → collect
... and so on
```

**Algorithm:**
1. Enqueue an empty list.
2. While queue not empty: dequeue `partial`.
   - If `partial.size() == k`: add to results.
   - Else: for `i` from `last+1` to `n - (k - size) + 1`, enqueue `partial + [i]`.

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k) — same work as backtracking, iterative |
| Space | O(C(n,k)·k) — all partial combinations live in the queue simultaneously |

---

## Solution 8: Memoized Pascal decomposition — O(C(n,k)·k) time, O(n·k·C(n,k)) space

**Idea:**

Same Pascal recurrence as Solution 5 but with a cache. The subproblems overlap: `combine(n-2, k-1)` is called by both `combine(n-1, k)` (its "exclude" branch) and `combine(n-1, k-1)` (its "exclude" branch), so without memoization it's recomputed. The cache key is just `n * 21 + k` since both fit in `[0, 20]`.

One subtlety: when the "include `n`" branch appends `n` to cached results, it must deep-copy each list first — otherwise it would mutate lists that are referenced by the cache and used again later.

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k) — each unique `(n,k)` subproblem computed once |
| Space | O(n·k) distinct subproblems, each storing its combinations |

---

## Solution 9: Bottom-up DP table — O(n·k·C(n,k)·k) time, O(n·k·C(n,k)·k) space

**Idea:**

Iterative counterpart of Solution 8. Build a 2D table `dp[i][j]` = all combinations of `j` numbers from `{1..i}`, filling it row by row using the same Pascal identity:

```
dp[i][j] = (dp[i-1][j-1] with i appended to each)  ∪  dp[i-1][j]
```

**Base cases:**
- `dp[i][0] = [[]]` for all `i` — one way to choose 0 numbers: the empty set.
- `dp[i][j] = []` for `j > i` — can't choose more numbers than are available.

**Building the table for `n = 4, k = 2`:**

```
dp[0][0]=[[]],  dp[0][1]=[]
dp[1][0]=[[]],  dp[1][1]=[[1]]
dp[2][0]=[[]],  dp[2][1]=[[1],[2]],          dp[2][2]=[[1,2]]
dp[3][0]=[[]],  dp[3][1]=[[1],[2],[3]],      dp[3][2]=[[1,2],[1,3],[2,3]]
dp[4][0]=[[]],  dp[4][1]=[[1],[2],[3],[4]],  dp[4][2]=[[1,2],[1,3],[2,3],[1,4],[2,4],[3,4]]
```

Answer: `dp[4][2]`

**Complexity:**

| | |
|---|---|
| Time | O(n·k·C(n,k)·k) — fill n·k cells, each copying up to C(n,k) lists of size k |
| Space | O(n·k·C(n,k)·k) — entire table kept in memory |

---

## Solution 10: Knuth's Algorithm T (TAOCP 7.2.1.3) — O(C(n,k)·k) time, O(k) space

**Idea:**

From Knuth's *The Art of Computer Programming*, Vol. 4A, §7.2.1.3. Uses a `(k+2)`-element array `c[0..k+1]` with two sentinels:
- `c[0] = 0` (lower sentinel, never touched)
- `c[k+1] = n+1` (upper sentinel, stops the search)

The array `c[1..k]` holds the current combination. The algorithm advances it by finding the leftmost position `j` where `c[j]+1 < c[j+1]` (there's room to increment), resetting all positions to the left of `j` back to their minimal values `c[j]=j` along the way, then incrementing `c[j]`.

**Steps:**
- **T1** Initialize: `c[j] = j` for `1 ≤ j ≤ k`; `c[k+1] = n+1`.
- **T2** Visit: record `{c[1], …, c[k]}`.
- **T3** Find j: `j = 1`; while `c[j]+1 == c[j+1]`: set `c[j] = j`, advance `j++`.
- **T4** Terminate if `j > k`.
- **T5** Increase: `c[j]++`, go to T2.

**Trace:** `n = 4, k = 2`

```
Init:  c = [0, 1, 2, 5]   → visit {1,2}
T3: c[1]+1=2==c[2]=2 → c[1]=1, j=2; c[2]+1=3≠c[3]=5 → stop at j=2
T5: c[2]++ → c=[0,1,3,5]  → visit {1,3}
T3: j=1; c[1]+1=2≠c[2]=3 → stop at j=1
T5: c[1]++ → c=[0,2,3,5]  → visit {2,3}
T3: j=1; c[1]+1=3==c[2]=3 → c[1]=1, j=2; c[2]+1=4≠c[3]=5 → stop
T5: c[2]++ → c=[0,1,4,5]  → visit {1,4}
T3: j=1; c[1]+1=2≠c[2]=4 → stop
T5: c[1]++ → c=[0,2,4,5]  → visit {2,4}
T3: j=1; c[1]+1=3≠c[2]=4 → stop
T5: c[1]++ → c=[0,3,4,5]  → visit {3,4}
T3: c[1]+1=4==c[2]=4 → c[1]=1, j=2; c[2]+1=5==c[3]=5 → c[2]=2, j=3; j>k → done
```

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k) — amortized O(1) advance per combination |
| Space | O(k) — one array of size k+2, no recursion |

**Idea:**

Instead of iterating all `2^n` masks and filtering, start at the smallest mask with `k` bits set and jump directly to the next one using pure bit arithmetic — no skipping, no `bitCount` check.

Given a valid mask, the next mask with the same number of set bits:

```
c    = mask & -mask       // isolate the lowest set bit
r    = mask + c           // add c: ripples the trailing block of 1s one position left
mask = (((r ^ mask) >> 2) / c) | r
```

The `(r ^ mask)` gives the bits that changed; shifting right by 2 and dividing by `c` packs the trailing 1s back to the lowest positions; OR-ing with `r` combines both parts.

**Example:** `k = 2`, starting mask `0011`:

```
0011 → 0101 → 0110 → 1001 → 1010 → 1100  (done, next would be ≥ 2^n)
{1,2}  {1,3}  {2,3}  {1,4}  {2,4}  {3,4}
```

**Algorithm:**
1. Start with `mask = (1 << k) - 1` (lowest `k` bits set).
2. While `mask < (1 << n)`: decode the mask into a combination, then apply Gosper's Hack to advance.

**Complexity:**

| | |
|---|---|
| Time | O(C(n,k)·k) — visit exactly C(n,k) masks, decode each in O(n) |
| Space | O(k) per combination (output excluded) |
