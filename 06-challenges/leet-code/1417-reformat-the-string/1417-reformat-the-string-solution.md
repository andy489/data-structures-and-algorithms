# 1417. Reformat The String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reformat-the-string/

---

## Solution: Separate and Interleave — O(n) time, O(n) space

**Idea:** Separate into letters and digits lists. If |len(letters) - len(digits)| > 1, return empty. Interleave starting with the longer list.

**Algorithm:**
1. Collect letters and digits separately.
2. If size difference > 1, return empty.
3. Interleave, starting with whichever has more characters.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
