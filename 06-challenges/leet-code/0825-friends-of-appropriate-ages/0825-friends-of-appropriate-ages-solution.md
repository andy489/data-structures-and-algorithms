# 825. Friends Of Appropriate Ages — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/friends-of-appropriate-ages/

---

## Solution: Counting Array — O(n + 120²) time, O(120) space

**Idea:** Since ages are bounded by 120, count frequencies and check all age pairs (a, b) with the given conditions.

**Algorithm:**
1. Count frequency of each age (1–120).
2. For each pair (a, b), if conditions are not violated and a != b (or same age with count > 1), add count[a] * count[b] to result.
3. If a == b, subtract count[a] (no self-friend request).

**Complexity:**

| | |
|---|---|
| Time | O(n + 120²) = O(n) effectively |
| Space | O(120) = O(1) constant |
