# 1688. Count of Matches in Tournament — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-of-matches-in-tournament/

---

## Solution: Math Insight — O(1) time, O(1) space

**Idea:** Every match eliminates exactly one team. To go from `n` teams to 1 winner, we need exactly `n - 1` eliminations, hence `n - 1` matches.

**Algorithm:**
1. Return `n - 1`.

Alternatively, simulate the rounds iteratively, but the math insight gives O(1).

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
