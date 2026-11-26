# 1452. People Whose List Of Favorite Companies Is Not A Subset Of Another List — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

---

## Solution: Set Subset Check — O(n^2 * m) time, O(n * m) space

**Idea:** Convert each list to a set. For each person, check if their set is a subset of any other set. If not, include in result.

**Algorithm:**
1. Convert all lists to sets.
2. For each i: if set[i] is a subset of any set[j] (j != i), skip.
3. Otherwise, include i in result.

**Complexity:**

| | |
|---|---|
| Time | O(n^2 * m) |
| Space | O(n * m) |
