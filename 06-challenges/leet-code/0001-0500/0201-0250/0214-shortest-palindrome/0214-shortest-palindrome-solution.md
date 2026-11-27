# 214. Shortest Palindrome — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-palindrome/

---

## Solution: KMP Failure Function — O(n) time, O(n) space

**Idea:** The shortest palindrome formed by prepending characters equals `reverse(s[k+1..n-1]) + s`, where `k` is the length of the longest palindromic prefix of `s`. Find `k` using the KMP failure function on the string `t = s + "#" + reverse(s)`: the failure value at the last position gives the length of the longest prefix of `s` that is also a suffix of `reverse(s)`, i.e., the longest palindromic prefix.

**Algorithm:**
1. Build `t = s + "#" + reverse(s)`.
2. Compute the KMP failure (partial-match) array for `t`.
3. `k = failure[last]` is the length of the longest palindromic prefix of `s`.
4. Answer is `reverse(s[k..]) + s`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — KMP preprocessing |
| Space | O(n) — failure array and string concatenation |
