# 670. Maximum Swap — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-swap/

---

## Solution: Last Occurrence Map — O(n) time, O(1) space

**Idea:** Store the last occurrence index of each digit 0–9. Then scan from left; for each digit, check if any larger digit appears later. If so, swap and return.

**Algorithm:**
1. Convert num to digits array.
2. Build `last[d]` = last index of digit d.
3. For each position i from left: check digits 9 down to digits[i]+1. If `last[d] > i`, swap and return.

**Complexity:**

| | |
|---|---|
| Time | O(n) — n ≤ 9 digits |
| Space | O(1) — fixed-size arrays |
