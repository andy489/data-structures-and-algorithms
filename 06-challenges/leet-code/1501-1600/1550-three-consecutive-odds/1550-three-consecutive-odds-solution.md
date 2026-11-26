# 1550. Three Consecutive Odds — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/three-consecutive-odds/

---

## Solution: Linear Scan — O(n) time, O(1) space

**Idea:** Maintain a counter of consecutive odd numbers seen so far. Reset to zero whenever an even number is encountered. Return true as soon as the counter reaches 3.

**Algorithm:**
1. Iterate through each element.
2. If the element is odd, increment the counter; if it reaches 3, return true.
3. If the element is even, reset the counter to 0.
4. Return false if no three consecutive odds were found.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the array |
| Space | O(1) — only a counter variable |
