# 2239. Find Closest Number to Zero

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/find-closest-number-to-zero/

## Approach: Linear Scan

Track the best candidate: a number is better if its absolute value is strictly smaller, or equal but the number itself is larger (positive preferred over negative).

**Complexity:**
- Time: O(n)
- Space: O(1)
