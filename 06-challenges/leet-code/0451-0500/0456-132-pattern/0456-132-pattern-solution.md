# 456. 132 Pattern — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/132-pattern/

---

## Solution: Monotonic Stack (Scan Right to Left) — O(n) time, O(n) space

**Idea:** Scan from right to left. Maintain a monotonic decreasing stack. As we pop elements smaller than the current, they become candidates for `nums[k]` (the "2" in 132 — the middle value). Track `third = max popped`. If we encounter a value smaller than `third`, we found the pattern.

**Algorithm:**
1. Initialize `third = Integer.MIN_VALUE`, stack = empty.
2. Iterate `i` from `n-1` to `0`:
   - If `nums[i] < third`, return `true` (nums[i] is the "1").
   - While stack not empty and `nums[i] > stack.top()`, pop into `third`.
   - Push `nums[i]`.
3. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each element pushed/popped at most once |
| Space | O(n) — stack |
