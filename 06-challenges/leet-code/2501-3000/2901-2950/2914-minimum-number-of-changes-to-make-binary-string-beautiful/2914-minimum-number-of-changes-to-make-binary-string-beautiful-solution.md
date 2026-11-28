# 2914. Minimum Number of Changes to Make Binary String Beautiful — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-changes-to-make-binary-string-beautiful/

---

## Solution: Greedy Pair Scan — O(n) time, O(1) space

**Idea:** A beautiful string must consist of even-length blocks of same characters. Looking at pairs `(s[0],s[1])`, `(s[2],s[3])`, etc., each pair must be the same character. If `s[2i] != s[2i+1]`, we need exactly 1 change per such pair.

**Algorithm:**
1. Iterate through the string in steps of 2.
2. For each pair `(s[i], s[i+1])`, if they differ, increment the change counter.
3. Return the total count.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
