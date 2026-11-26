# 1260. Shift 2D Grid — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/shift-2d-grid/

---

## Solution: Index Mapping — O(m*n) time, O(m*n) space

**Idea:** Flatten to 1D, shift by k (mod m*n), then reshape. Each element at linear index p moves to (p+k) % (m*n).

**Algorithm:**
1. Flatten grid to array.
2. Rotate by k positions.
3. Reshape back to m x n.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(m*n) |
