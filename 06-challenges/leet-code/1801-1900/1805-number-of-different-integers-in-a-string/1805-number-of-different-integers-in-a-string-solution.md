# 1805. Number of Different Integers in a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-different-integers-in-a-string/

---

## Solution: Regex Split + Strip Leading Zeros — O(n) time, O(n) space

**Idea:** Extract all maximal digit runs from the string. Two runs represent the same integer if and only if they are equal after stripping leading zeros. Store the stripped strings in a set and return its size.

**Algorithm:**
1. Scan the string character by character.
2. When a digit is encountered, find the end of the digit run.
3. Skip any leading zeros within the run (keeping at least one digit).
4. Add the resulting substring to a `HashSet`.
5. Return the size of the set.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass through the string |
| Space | O(n) — set stores at most O(n) distinct digit substrings |
