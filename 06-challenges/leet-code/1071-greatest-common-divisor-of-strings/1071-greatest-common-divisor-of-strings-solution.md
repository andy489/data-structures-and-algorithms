# 1071. Greatest Common Divisor of Strings — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/greatest-common-divisor-of-strings/

---

## Solution: GCD of Lengths — O(m+n) time, O(m+n) space

**Idea:** The GCD string exists iff str1+str2 == str2+str1. Its length is gcd(len1, len2).

**Algorithm:**
1. If `str1+str2 != str2+str1`, return "".
2. Return `str1[:gcd(len(str1), len(str2))]`.

**Complexity:**

| | |
|---|---|
| Time | O(m+n) |
| Space | O(m+n) |
