# 1487. Making File Names Unique — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/making-file-names-unique/

---

## Solution: HashMap Counter — O(n * L) time, O(n) space

**Idea:** Track next suffix counter for each base name. When collision, increment counter and re-check.

**Algorithm:**
1. Map name -> next k to try.
2. For each name: while name exists, append (k), increment k. Add to used set, update map.

**Complexity:**

| | |
|---|---|
| Time | O(n * L) |
| Space | O(n) |
