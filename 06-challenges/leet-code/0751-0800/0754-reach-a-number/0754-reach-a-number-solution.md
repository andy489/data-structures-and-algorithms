# 754. Reach a Number — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reach-a-number/

---

## Solution: Math / Greedy — O(√target) time, O(1) space

**Idea:** Mirror: target can be negative so take `|target|`. Take steps 1,2,...,k until `sum >= target`. The difference `diff = sum - target` must be even (we can flip one step from + to - to reduce sum by 2×step). If `diff` is odd, keep taking steps until `diff` is even.

**Algorithm:**
1. `target = abs(target)`.
2. Accumulate `sum += k` for k=1,2,... until `sum >= target` and `(sum - target)` is even.
3. Return `k`.

**Complexity:**

| | |
|---|---|
| Time | O(√target) — sum grows as k²/2 |
| Space | O(1) |
