# 217. Contains Duplicate — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/contains-duplicate/

---

## Solution: HashSet — O(n) time, O(n) space

**Idea:** Insert elements into a HashSet. If any element is already present, a duplicate exists.

**Algorithm:**
1. For each `num` in `nums`: if `seen.contains(num)` return `true`; else `seen.add(num)`.
2. Return `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(n) — HashSet |
