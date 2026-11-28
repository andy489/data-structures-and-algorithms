# 2937. Make Three Strings Equal — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/make-three-strings-equal/

---

## Solution: Longest Common Prefix — O(min(n1,n2,n3)) time, O(1) space

**Idea:** Find the length of the longest common prefix among all three strings. The answer is the total length of all three strings minus three times the common prefix length. If there is no common prefix at all (first characters differ), return -1.

**Algorithm:**
1. Find the minimum length among s1, s2, s3.
2. Walk from index 0 up to that minimum, counting how many leading characters are equal across all three strings.
3. If the common prefix length is 0, return -1.
4. Otherwise return `(s1.length - prefix) + (s2.length - prefix) + (s3.length - prefix)`.

**Complexity:**

| | |
|---|---|
| Time | O(min(n1, n2, n3)) |
| Space | O(1) |
