# 27. Remove Element — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/remove-element/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use a write pointer `k` that tracks the next position for a valid element. Scan through the array with `i`; whenever `nums[i] != val`, copy it to `nums[k]` and advance `k`. Elements at index `k` and beyond are irrelevant.

**Algorithm:**
1. Initialize `k = 0`.
2. Iterate `i` from `0` to `n - 1`.
3. If `nums[i] != val`, set `nums[k] = nums[i]` and increment `k`.
4. Return `k`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass through the array |
| Space | O(1) — only two pointers, no extra storage |
