# 2086. Minimum Number of Food Buckets to Feed the Hamsters — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-food-buckets-to-feed-the-hamsters/

---

## Solution: Greedy — O(n) time, O(1) space

**Idea:** Greedily place bucket to the right of each hamster if possible (position+1 is E). Otherwise use left position. Fail if neither available.

**Algorithm:**
1. Scan left to right.
2. For each H: if right is E, skip right (use it, mark E at right).
3. Else if left is E, decrement left's E.
4. Else return -1.
5. Count placements.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
