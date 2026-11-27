# 2120. Execution of All Suffix Instructions Staying in a Grid — Solution

**Link:** https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/

## Approach: Simulation

Given `m <= 500`, we can simulate each starting position directly. For each index `i` from `0` to `m-1`, simulate the robot starting at `startPos` and executing `s[i..m-1]`, counting how many steps it takes before going off-grid or finishing.

Total work is O(m^2) = O(250000) which is fast enough.

## Complexity

| | Time | Space |
|---|---|---|
| **Brute Force Simulation** | O(m^2) | O(m) |
