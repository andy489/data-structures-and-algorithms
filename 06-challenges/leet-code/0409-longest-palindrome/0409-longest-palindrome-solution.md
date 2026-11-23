# 409. Longest Palindrome — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/longest-palindrome/

---

## Solution: Frequency Count — O(n) time, O(1) space

**Idea:** Count character frequencies. All even-frequency characters can be fully used. For odd-frequency characters, we use `freq - 1` (the largest even number ≤ freq). If any character has an odd count, we can place one such character in the center, adding 1 to the total.

**Algorithm:**
1. Count frequency of each character.
2. Sum up `freq / 2 * 2` for each character (the even portion).
3. If the total is less than `s.length()`, we can add 1 for a center character.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single frequency pass |
| Space | O(1) — fixed alphabet of 52 characters |
