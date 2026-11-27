# 763. Partition Labels — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/partition-labels/

---

## Solution: Last Occurrence Greedy — O(n) time, O(1) space

**Idea:** Precompute the last occurrence of each character. Greedily extend the current partition as far as the last occurrence of any character seen so far. When index reaches the partition end, record the size.

**Algorithm:**
1. Build `last[c]` = last index of character `c` in `s`.
2. Scan with `start = 0`, `end = 0`. For each `i`, update `end = max(end, last[s[i]])`.
3. When `i == end`, record `end - start + 1`, set `start = i + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two passes |
| Space | O(1) — 26-char array |
