# 926. Flip String to Monotone Increasing — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flip-string-to-monotone-increasing/

---

## Solution: DP / One Pass — O(n) time, O(1) space

**Idea:** Track `ones` = number of 1s seen, `flips` = minimum flips to make current prefix monotone. For each char: if '1', flips stays same (no flip needed); if '0', we can either flip this 0 to 1 (flips+1) or flip all previous 1s to 0 (ones flips). Take the min.

**Algorithm:**
1. For each char: if '0', flips = min(flips+1, ones); if '1', ones++.
2. Return flips.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
