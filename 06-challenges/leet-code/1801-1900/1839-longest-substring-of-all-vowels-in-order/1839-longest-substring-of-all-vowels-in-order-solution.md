# 1839. Longest Substring of All Vowels in Order — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Scan the string maintaining the current substring start and the count of distinct vowels seen. A valid beautiful substring must start with `'a'`. When the next character is strictly greater than the current one, it extends the substring and may add a new distinct vowel. If equal, it stays the same vowel. If less (a decrease), reset: start a new substring at the current position only if the current character is `'a'`.

**Algorithm:**
1. Map `aeiou` to 0–4. Initialize `start = 0`, `distinct = 1`, `ans = 0`.
2. For each index `i` from 1 to n-1:
   - If `rank[i] == rank[i-1]`: extend current run (same vowel).
   - Else if `rank[i] == rank[i-1] + 1`: extend and increment `distinct`.
   - Else: reset `start = i`, `distinct = 1`.
   - If `distinct == 5`: update `ans = max(ans, i - start + 1)`.
3. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — constant extra variables |
