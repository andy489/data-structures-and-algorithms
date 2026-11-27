# 1441. Build An Array With Stack Operations — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/build-an-array-with-stack-operations/

---

## Solution: Simulation — O(n) time, O(n) space

**Idea:** Iterate 1 to max(target). Push each. If not in target, pop immediately.

**Algorithm:**
1. Use a set for O(1) lookup of target values.
2. For i from 1 to max(target): Push; if i not in target: Pop.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
