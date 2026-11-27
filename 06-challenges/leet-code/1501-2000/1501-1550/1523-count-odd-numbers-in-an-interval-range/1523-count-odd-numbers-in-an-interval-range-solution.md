# 1523. Count Odd Numbers in an Interval Range — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

---

## Solution: Math Prefix Count — O(1) time, O(1) space

**Idea:** The count of odd numbers from 1 to n is `⌊(n+1)/2⌋`. So the count in [low, high] is the prefix count up to high minus the prefix count up to low-1.

**Algorithm:**
1. Compute `(high + 1) / 2` — number of odd values in [1, high].
2. Subtract `low / 2` — number of odd values in [1, low-1].
3. Return the difference.

**Complexity:**

| | |
|---|---|
| Time | O(1) — constant math operations |
| Space | O(1) — no extra storage |
