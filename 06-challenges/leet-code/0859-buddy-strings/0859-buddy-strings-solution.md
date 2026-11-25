# 859. Buddy Strings — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/buddy-strings/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Find positions where s and goal differ. If exactly 2 diffs: check if swapping makes them equal. If 0 diffs: need a repeated character (can swap same char with itself). Otherwise false.

**Algorithm:**
1. If lengths differ, return false.
2. Find all diff positions.
3. If 0 diffs: return true if any char appears twice.
4. If 2 diffs [i, j]: return s[i]==goal[j] && s[j]==goal[i].
5. Otherwise false.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
