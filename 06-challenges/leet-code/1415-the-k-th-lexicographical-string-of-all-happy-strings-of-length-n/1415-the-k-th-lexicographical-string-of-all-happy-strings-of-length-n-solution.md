# 1415. The K Th Lexicographical String Of All Happy Strings Of Length N — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/

---

## Solution: Backtracking / Direct Computation — O(n) time, O(n) space

**Idea:** There are 3*2^(n-1) total happy strings. Directly compute the k-th by picking each character greedily.

**Algorithm:**
1. Total = 3 * 2^(n-1). If k > total, return empty.
2. First char: each has 2^(n-1) strings. Pick char at index ceil(k / 2^(n-1)) - 1.
3. Subsequent chars: for each position, pick 1st valid char that fits in k.
4. Adjust k at each step.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
