# 2023. Number of Pairs of Strings With Concatenation Equal to Target — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

---

## Solution: Count Prefix Matches — O(n * L) time, O(n) space

**Idea:** For each `nums[i]`, check if it's a prefix of target; count matching suffixes.

**Algorithm:**
1. For each string, if it's a prefix of target, count how many other strings equal the remaining suffix.
2. Sum counts.

**Complexity:**

| | |
|---|---|
| Time | O(n * L) |
| Space | O(n) |
