# 1529. Minimum Suffix Flips — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-suffix-flips/

---

## Solution: Greedy Transition Count — O(n) time, O(1) space

**Idea:** Each flip sets everything from index i onwards to the same value. So we only need a new flip each time the target changes from the current state. Count the number of transitions in the target (treating '0' as the initial state).

**Algorithm:**
1. Track `current` as the current state of all characters (starts at '0').
2. Scan target left to right; whenever target[i] differs from current, we need a flip — increment count and update current.
3. Return the count.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — only a few variables |
