# 5. Longest Palindromic Substring — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/longest-palindromic-substring/

---

## Solution

### Expand Around Center — O(n²) time, O(1) space

**Idea:** Every palindrome has a center. For a string of length `n` there are `2n - 1` possible centers: `n` single-character centers (odd-length palindromes) and `n - 1` two-character centers (even-length palindromes). For each center, expand outward as long as characters match.

**Algorithm:**
1. For each index `i`, expand around:
   - Odd center: `left = i`, `right = i`
   - Even center: `left = i`, `right = i + 1`
2. Expand while `s[left] == s[right]` and indices are in bounds.
3. Track the longest palindrome found.

**Why this is correct:** Any palindrome can be uniquely identified by its center; exhausting all centers exhausts all palindromes.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — n centers, each expands up to O(n) |
| Space | O(1) — only store start/length of best result |

### Dynamic Programming — O(n²) time, O(n²) space

Define `dp[i][j] = true` if `s[i..j]` is a palindrome.

- Base: every single character is a palindrome (`dp[i][i] = true`).
- Transition: `dp[i][j] = (s[i] == s[j]) && dp[i+1][j-1]`.
- Fill in order of increasing substring length.

More memory but expresses the recurrence cleanly.

### Manacher's Algorithm — O(n) time, O(n) space

An advanced technique that computes the longest palindrome centered at each position in linear time by reusing previously computed expansion lengths. Practical for very long strings but more complex to implement.
