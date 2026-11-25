# 1005. Maximize Sum Of Array After K Negations — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

---

## Solution: Greedy Sort — O(n log n) time, O(1) space

**Idea:** Sort by absolute value descending. Negate negatives first (greedy). If k remaining is odd, negate the smallest absolute value element.

**Algorithm:**
1. Sort by abs value descending.
2. For each element, if negative and k>0, negate it, decrement k.
3. If k is still odd, negate last element (smallest abs).
4. Return sum.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(1) |
