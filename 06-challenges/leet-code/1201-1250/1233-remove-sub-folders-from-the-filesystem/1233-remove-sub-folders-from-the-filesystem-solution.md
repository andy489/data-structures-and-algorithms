# 1233. Remove Sub-Folders from the Filesystem — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/

---

## Solution: Sort and Prefix Check — O(n log n) time, O(n) space

**Idea:** Sort folders lexicographically. After sorting, a subfolder immediately follows its parent. Skip any folder that starts with the last kept folder + '/'.

**Algorithm:**
1. Sort folders.
2. Keep track of last added folder.
3. Skip current if it starts with last + '/'.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
