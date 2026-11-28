# 2904. Shortest and Lexicographically Smallest Beautiful String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/

---

## Solution: Sliding Window — O(n^2) time, O(n) space

**Idea:** Use a sliding window to find all substrings with exactly `k` ones. Among those, find the shortest, then pick the lexicographically smallest among all shortest ones.

**Algorithm:**
1. Use two pointers `left` and `right`. Expand `right` until we have exactly `k` ones.
2. When we have exactly `k` ones, record the substring `s[left..right]`. Then try to shrink from the left while maintaining `k` ones.
3. Among all collected substrings, find the minimum length, then among all with minimum length return the lexicographically smallest.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) |
| Space | O(n) |
