# 946. Validate Stack Sequences — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/validate-stack-sequences/

---

## Solution: Simulation — O(n) time, O(n) space

**Idea:** Simulate: push elements, and whenever the stack top equals the next expected pop value, pop it. Stack should be empty at the end.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
