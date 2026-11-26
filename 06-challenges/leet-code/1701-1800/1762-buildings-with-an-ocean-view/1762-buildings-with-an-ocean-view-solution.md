# 1762. Buildings With an Ocean View — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/buildings-with-an-ocean-view/

---

## Solution: Right-to-Left Scan — O(n) time, O(1) extra space

**Idea:** Scan from right to left, tracking the maximum height seen so far. A building has an ocean view if its height is strictly greater than all buildings to its right (i.e., greater than the running max). Collect results and reverse at the end.

**Algorithm:**
1. Traverse `heights` from right to left.
2. Maintain `maxRight` = maximum height seen so far.
3. If `heights[i] > maxRight`, add `i` to the result list.
4. Update `maxRight = max(maxRight, heights[i])`.
5. Reverse the result list to return indices in increasing order.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) extra — output list not counted |
