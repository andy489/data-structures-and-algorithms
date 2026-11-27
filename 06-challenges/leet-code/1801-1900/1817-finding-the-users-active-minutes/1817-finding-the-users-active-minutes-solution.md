# 1817. Finding the Users Active Minutes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/finding-the-users-active-minutes/

---

## Solution: HashMap of Sets — O(n) time, O(n) space

**Idea:** Map each user ID to the set of unique minutes they were active. Then count how many users have each UAM value and populate the answer array.

**Algorithm:**
1. Iterate over `logs`; for each `[id, time]`, add `time` to the set for `id`.
2. For each user's set, compute its size (the UAM); increment `answer[uam - 1]`.
3. Return `answer`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — one pass to build sets, one pass over users |
| Space | O(n) — map of sets storing at most n entries total |
