# 128. Longest Consecutive Sequence — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-consecutive-sequence/

---

## Solution: Hash Set — O(n) time, O(n) space

**Idea:** Insert all numbers into a hash set. For each number, only start counting a streak if it is the **beginning** of a sequence (i.e. `num - 1` is not in the set). This ensures each number is visited at most twice across all streak expansions, giving O(n) overall.

**Algorithm:**
1. Put all numbers into a set.
2. For each `num` in the set: if `num - 1 ∉ set`, count forward (`num, num+1, num+2, ...`) as long as the next value is in the set.
3. Track and return the maximum streak length found.

**Complexity:**

| | |
|---|---|
| Time  | O(n) — each number is the start of at most one streak; total inner iterations across all streaks ≤ n |
| Space | O(n) — hash set stores all n numbers |
