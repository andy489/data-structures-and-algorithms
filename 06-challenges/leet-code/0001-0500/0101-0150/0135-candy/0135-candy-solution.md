# 135. Candy — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/candy/

---

## Solution 1: Two-Pass Greedy — O(n) time, O(n) space

**Idea:** Make two passes over the ratings array, each enforcing one side of the neighbor constraint. In the left pass, give each child one more candy than their left neighbor if their rating is strictly higher. In the right pass (right to left), give each child one more than their right neighbor if their rating is strictly higher — but keep the max from the left pass so both constraints are satisfied simultaneously.

**Algorithm:**
1. Initialize `candy[i] = 1` for all `i`.
2. Left pass (i = 1 to n-1): if `ratings[i] > ratings[i-1]`, set `candy[i] = candy[i-1] + 1`.
3. Right pass (i = n-2 to 0): if `ratings[i] > ratings[i+1]`, set `candy[i] = max(candy[i], candy[i+1] + 1)`.
4. Return `sum(candy)`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — two linear passes |
| Space | O(n) — candy allocation array |

---

## Solution 2: One-Pass Greedy — O(n) time, O(1) space

**Idea:** Track the lengths of the current ascending (`up`) and descending (`down`) runs. When an ascending run ends, the peak gets `up + 1` candies. When a descending run follows, the peak should be `max(up, down) + 1` — but we emit the peak during the ascending run, so if `down >= up` we need to add the difference (`down - up + 1`) retroactively. The total candies for a run of length `k` going strictly up or down is the triangular number `k*(k+1)/2`.

**Algorithm:**
1. Start with `ans = 1`, `up = 0`, `down = 0`, `peak = 0`.
2. For each pair of adjacent children:
   - If ascending: flush any pending descent, increment `up`, record `peak = up`, add `up + 1` to `ans`.
   - If equal: flush both runs, reset all to 0, add 1 to `ans`.
   - If descending: increment `down`, add `down + 1` to `ans`; if `down >= peak`, add 1 more (the peak needs to grow).
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass |
| Space | O(1) — only counters |
