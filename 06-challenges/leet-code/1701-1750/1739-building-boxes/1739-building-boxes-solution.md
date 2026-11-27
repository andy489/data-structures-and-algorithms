# 1739. Building Boxes — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/building-boxes/

---

## Solution: Math / Greedy (Triangular Layer Counts) — O(n^(1/3)) time, O(1) space

**Idea:** The optimal arrangement packs boxes in a triangular corner stack. With `h` full layers, the total boxes is T(h) = sum_{i=1}^{h} T_i(i) where T_i(k) = k*(k+1)/2 is the kth triangular number. The total boxes in `h` full layers = h*(h+1)*(h+2)/6 (tetrahedral number), and the floor boxes = h*(h+1)/2.

After filling `h` complete layers, greedily add extra floor boxes one at a time (each new floor box in the (h+1)th layer holds up to `i` more boxes when it's the ith added).

**Algorithm:**
1. Find the largest `h` such that `h*(h+1)*(h+2)/6 <= n`.
2. Set `remaining = n - h*(h+1)*(h+2)/6`, `floor = h*(h+1)/2`.
3. While `remaining > 0`: add one more floor box; it can hold `i` extra boxes (1st adds 1, 2nd adds 2, etc.). Subtract; increment floor count.
4. Return `floor`.

**Complexity:**

| | |
|---|---|
| Time | O(n^(1/3)) — find h, then at most O(h) extra steps |
| Space | O(1) — constant extra |
