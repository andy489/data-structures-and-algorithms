# 1239. Maximum Length of a Concatenated String with Unique Characters — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

---

## Solution: Bitmask DP — O(2^n) time, O(2^n) space

**Idea:** Represent each string as a bitmask of characters. Use DP: maintain set of achievable bitmasks. For each string, try adding it to all existing masks if no overlap.

**Algorithm:**
1. Convert each string to bitmask (or discard if has duplicate chars).
2. dp = set of achievable character masks.
3. For each string mask, extend all dp masks if no overlap.
4. Track max popcount.

**Complexity:**

| | |
|---|---|
| Time | O(2^n) |
| Space | O(2^n) |
