# 900. RLE Iterator — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rle-iterator/

---

## Solution: Pointer — O(n/group) per next, O(1) extra space

**Idea:** Keep a pointer into the encoding array and a counter of remaining elements in the current run. For each `next(n)`, subtract `n` across runs until exhausted.

**Complexity:**

| | |
|---|---|
| Time | O(k/group) amortized per next call |
| Space | O(1) extra |
