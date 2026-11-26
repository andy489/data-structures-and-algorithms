# 1419. Minimum Number Of Frogs Croaking — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-number-of-frogs-croaking/

---

## Solution: Counter Simulation — O(n) time, O(1) space

**Idea:** Track counts for each stage. Each character increments its stage and decrements the previous. Count simultaneous frogs.

**Algorithm:**
1. Map 'croak' to indices 0-4. Keep counts c,r,o,a,k.
2. For char at index i > 0: if prev stage count is 0, return -1.
3. Increment current, decrement prev. Track max concurrent (non-zero k means frog finished).
4. At end, all counts must be 0.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
