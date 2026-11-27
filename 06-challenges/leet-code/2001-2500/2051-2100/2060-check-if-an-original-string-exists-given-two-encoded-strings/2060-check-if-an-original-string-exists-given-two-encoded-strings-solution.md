# 2060. Check If an Original String Exists Given Two Encoded Strings — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/

---

## Solution: DP with Offset Tracking — O(|s1| * |s2| * maxNum) time, O(|s1| * |s2| * maxNum) space

**Idea:** DP: state (i, j, diff) where diff = unmatched length advantage of s1 over s2.

**Algorithm:**
1. DP states: (i, j, diff) = parsed i chars of s1, j chars of s2, s1 is diff chars ahead.
2. Process letter or number tokens.
3. Match letters when diff == 0.
4. Return dp[|s1|][|s2|][0].

**Complexity:**

| | |
|---|---|
| Time | O(|s1| * |s2| * maxNum) |
| Space | O(|s1| * |s2| * maxNum) |
