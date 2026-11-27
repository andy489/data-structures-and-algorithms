# 1104. Path In Zigzag Labelled Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

---

## Solution: Math (Work Upwards) — O(log n) time, O(log n) space

**Idea:** Work backwards from the given label up to the root (label 1), computing the parent at each step. In a standard (non-zigzag) binary tree, the parent of node at index `i` in row `r` is at `i // 2`. In the zigzag tree, even rows are mirrored — so we must "un-mirror" the label to find the correct parent.

**Algorithm:**
1. Find the row `r` of `label` using `r = floor(log2(label))`.
2. The row's range is `[2^r, 2^(r+1) - 1]`. The mirror of `label` in row `r` is `2^r + 2^(r+1) - 1 - label`.
3. The parent in the zigzag tree is `mirror(label) // 2`.
4. Repeat from the parent until reaching row 0 (the root, label 1).
5. Reverse the collected path and return it.

**Complexity:**

| | |
|---|---|
| Time | O(log n) — one step per row, there are log2(label) rows |
| Space | O(log n) — the result list has log2(label) + 1 entries |
