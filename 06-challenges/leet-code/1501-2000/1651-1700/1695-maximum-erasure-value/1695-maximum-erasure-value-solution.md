# 1695. Maximum Erasure Value — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-erasure-value/

---

## Solution: Sliding Window — O(n) time, O(n) space

**Idea:** Use a sliding window that maintains a subarray with all unique elements. Expand right; when a duplicate is encountered, shrink from the left until the duplicate is removed.

**Algorithm:**
1. Use a HashMap/Set to track elements in the current window.
2. Maintain `windowSum` and `maxSum`.
3. For each `r`, if `nums[r]` is already in the set, advance `l` removing elements until `nums[r]` is gone.
4. Add `nums[r]` to window, update `windowSum` and `maxSum`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — the hash set |
