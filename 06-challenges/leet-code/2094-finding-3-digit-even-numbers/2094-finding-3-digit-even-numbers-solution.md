# 2094. Finding 3-Digit Even Numbers — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/finding-3-digit-even-numbers/

---

## Solution: Enumerate All 3-Digit Even Numbers — O(1) time, O(1) space

**Idea:** Check all 3-digit even numbers (100-998). For each, check if its digits are a subset of the given digits.

**Algorithm:**
1. Build digit frequency map from input.
2. For each even number 100 to 998: extract its 3 digits, check frequency availability.
3. Collect valid numbers.

**Complexity:**

| | |
|---|---|
| Time | O(1) |
| Space | O(1) |
