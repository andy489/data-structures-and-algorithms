# 768. Max Chunks To Make Sorted II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/max-chunks-to-make-sorted-ii/

---

## Solution: Left Max / Right Min — O(n) time, O(n) space

**Idea:** A chunk boundary at index `i` is valid if `max(arr[0..i]) <= min(arr[i+1..n-1])`. Precompute prefix max and suffix min arrays, then count valid cut points.

**Algorithm:**
1. Build `leftMax[i]` = max of `arr[0..i]`.
2. Build `rightMin[i]` = min of `arr[i..n-1]`.
3. Count positions where `leftMax[i] <= rightMin[i+1]`.
4. Answer = count + 1.

**Complexity:**

| | |
|---|---|
| Time | O(n) — 3 passes |
| Space | O(n) — two auxiliary arrays |
