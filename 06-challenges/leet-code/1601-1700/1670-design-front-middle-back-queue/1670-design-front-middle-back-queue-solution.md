# 1670. Design Front Middle Back Queue — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/design-front-middle-back-queue/

---

## Solution: Two Deques (Left and Right halves) — O(1) per operation, O(n) space

**Idea:** Maintain two deques `left` and `right` such that `left.size() == right.size()` or `left.size() == right.size() - 1` (right holds the extra element when odd). This keeps middle access O(1).

**Algorithm:**
- After each operation, rebalance: transfer front/back between deques to maintain the size invariant.
- `pushFront`: add to left front, rebalance.
- `pushMiddle`: if even total, add to right front; else add to left back, rebalance.
- `pushBack`: add to right back, rebalance.
- `popFront/Middle/Back`: remove from appropriate end, rebalance.

**Complexity:**

| | |
|---|---|
| Time | O(1) per operation |
| Space | O(n) |
