# 1296. Divide Array in Sets of K Consecutive Numbers — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

---

## Solution: Greedy with Sorted Map — O(n log n) time, O(n) space

**Idea:** Same as LeetCode 846 Hand of Straights. Sort unique values. Greedily form groups starting from the smallest available value.

**Algorithm:**
1. Count frequencies in a sorted map.
2. For each smallest key with count > 0: try forming a group of k starting there.
3. If any element is unavailable, return false.

**Complexity:**

| | |
|---|---|
| Time | O(n log n) |
| Space | O(n) |
