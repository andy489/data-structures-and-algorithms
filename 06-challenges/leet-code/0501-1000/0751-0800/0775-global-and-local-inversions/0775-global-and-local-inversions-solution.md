# 775. Global and Local Inversions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/global-and-local-inversions/

---

## Solution: Max Prefix Tracking — O(n) time, O(1) space

**Idea:** Every local inversion is also a global inversion. So global == local iff there are no non-local global inversions. A non-local global inversion exists if any `nums[i] > nums[j]` where `j >= i + 2`. Equivalently, check if the prefix max up to `i` ever exceeds `nums[i+2]`.

**Algorithm:**
1. Track `maxSoFar` = max of `nums[0..i]`.
2. For each `i` from 0 to n-3: if `maxSoFar > nums[i+2]`, return false.
3. Update `maxSoFar` each step.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra |
