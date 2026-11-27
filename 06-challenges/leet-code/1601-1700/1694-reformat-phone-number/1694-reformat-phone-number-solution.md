# 1694. Reformat Phone Number — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reformat-phone-number/

---

## Solution: Linear Scan and Group — O(n) time, O(n) space

**Idea:** Remove all spaces and dashes. Then group digits greedily:
- While more than 4 digits remain, take 3.
- If exactly 4 remain, split into two groups of 2.
- If 3 remain, take 3.
- If 2 remain, take 2.

**Algorithm:**
1. Filter only digit characters from `number`.
2. Build result groups: take 3 at a time while `len > 4`, then handle the final 2-4 digits.
3. Join groups with dashes.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
