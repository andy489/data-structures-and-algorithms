# 984. String Without AAA or BBB — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/string-without-aaa-or-bbb/

---

## Solution: Greedy — O(a+b) time, O(a+b) space

**Idea:** Always write two of the dominant letter (if it has at least twice as many), otherwise write one. Alternate to prevent runs of 3.

**Complexity:**

| | |
|---|---|
| Time | O(a+b) |
| Space | O(a+b) |
