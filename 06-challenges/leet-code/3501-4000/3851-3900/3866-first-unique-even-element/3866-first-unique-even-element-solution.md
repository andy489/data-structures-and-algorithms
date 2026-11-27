# 3866. First Unique Even Element — Solution

**Link:** https://leetcode.com/problems/first-unique-even-element/

## Approach: Frequency Map

1. Build a frequency map of all elements.
2. Scan `nums` left to right; return the first element that is even and has frequency exactly 1.

## Complexity

- **Time:** O(n)
- **Space:** O(n) for the frequency map
