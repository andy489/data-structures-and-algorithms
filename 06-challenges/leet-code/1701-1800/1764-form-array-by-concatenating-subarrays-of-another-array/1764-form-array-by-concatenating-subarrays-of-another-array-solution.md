# 1764. Form Array by Concatenating Subarrays of Another Array — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/

---

## Solution: Greedy Linear Scan — O(n * m) time, O(1) space

**Idea:** Greedily match each group in order. For each group, scan `nums` from the current position to find the earliest match. If found, advance the pointer past the matched subarray. If any group can't be matched, return false.

**Algorithm:**
1. Maintain a pointer `pos` into `nums`, starting at 0.
2. For each group `g`, scan `nums[pos:]` to find the first position where `g` matches as a subarray.
3. If a match is found at index `j`, set `pos = j + g.length` and continue to next group.
4. If no match is found, return false.
5. After processing all groups, return true.

**Complexity:**

| | |
|---|---|
| Time | O(n * m) — n = total length of all groups, m = length of nums |
| Space | O(1) — no extra storage |
