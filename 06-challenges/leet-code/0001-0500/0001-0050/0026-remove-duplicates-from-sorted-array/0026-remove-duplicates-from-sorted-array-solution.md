# 26. Remove Duplicates from Sorted Array — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/remove-duplicates-from-sorted-array/

---

## Solution: Two Pointers — O(n) time, O(1) space

**Idea:** Use a slow pointer `k` to track the position of the next unique element, and a fast pointer `i` to scan through the array. Whenever `nums[i]` differs from `nums[k - 1]`, copy it into position `k` and advance `k`.

**Algorithm:**
1. Initialize `k = 1` (the first element is always unique).
2. Iterate `i` from `1` to `n - 1`.
3. If `nums[i] != nums[k - 1]`, set `nums[k] = nums[i]` and increment `k`.
4. Return `k`.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — single pass through the array |
| Space | O(1) — only two pointers, no extra storage |
