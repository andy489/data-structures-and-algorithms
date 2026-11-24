# 619. Biggest Single Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/biggest-single-number/

---

## Solution: Subquery with HAVING — O(n) time, O(n) space

**Idea:** Use a subquery to find all numbers appearing exactly once, then take the MAX of those. MAX returns NULL automatically if the subquery is empty.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single group-by scan |
| Space | O(n) — group-by result |
