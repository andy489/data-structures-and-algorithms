# 2106. Maximum Fruits Harvested After at Most K Steps — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/

---

## Solution: Sliding Window — O(n) time, O(n) space

**Idea:** The optimal strategy is to either:
1. Go only right.
2. Go only left.
3. Go left first, then right.
4. Go right first, then left.

The key observation: the reachable range is a contiguous interval `[left, right]` on the x-axis. If we go left by `leftDist` steps and right by `rightDist` steps, the cost is `min(2*leftDist, 2*rightDist) + max(leftDist, rightDist)` (go one direction and come back, then go the other). This simplifies to: if we go left `a` steps and right `b` steps from `startPos`, the cost is `min(2a + b, a + 2b)`.

We want the maximum `sum` over all intervals `[L, R]` such that the interval is reachable in `k` steps:
- Left boundary `L = fruits[i][0]`, right boundary `R = fruits[j][0]`.
- Reachable if: `min(2 * (startPos - L), 2 * (R - startPos)) + max(startPos - L, R - startPos) <= k`, or equivalently, `min(startPos - L, R - startPos) * 2 + max(startPos - L, R - startPos) <= k`.

We use a **sliding window** on the sorted `fruits` array. For a fixed right endpoint `j`, find the smallest `i` such that the interval `[fruits[i][0], fruits[j][0]]` is reachable. We maintain a window sum and slide.

The reachability condition for `[L, R]` where `L <= startPos <= R`:
- `min(2*(startPos-L), 2*(R-startPos)) + (startPos-L) + (R-startPos) <= k`
- Simplifies to: `(startPos-L) + (R-startPos) + min(startPos-L, R-startPos) <= k`
- i.e., `(R-L) + min(startPos-L, R-startPos) <= k`

For `R < startPos`: only go left, cost = `startPos - L`.
For `L > startPos`: only go right, cost = `R - startPos`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — sliding window with prefix sum |
| Space | O(n) — prefix sum array |
