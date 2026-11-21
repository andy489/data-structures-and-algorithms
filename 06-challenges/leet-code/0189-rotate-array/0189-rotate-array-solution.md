# 189. Rotate Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rotate-array/

---

## Solution: Triple Reverse — O(n) time, O(1) space

**Idea:** Rotating right by `k` is equivalent to:
1. Reverse the whole array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n-k` elements.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
