# 1147. Longest Chunked Palindrome Decomposition — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-chunked-palindrome-decomposition/

---

## Solution: Greedy Two-Pointer — O(n^2) time, O(n) space

**Idea:** Use two pointers from the left and right ends of the remaining string. Greedily find the shortest matching prefix/suffix pair. When a prefix of the left side equals a suffix of the right side, peel them off and add 2 to the count. Continue until the two halves meet. If anything is left in the middle, it counts as 1.

**Algorithm:**
1. Use left index `l` (start of remaining) and right index `r` (end of remaining).
2. Try all prefix lengths `len` from 1 to `(r - l + 1) / 2`:
   - If `text[l..l+len-1] == text[r-len+1..r]`, peel off: `ans += 2`, advance `l += len`, `r -= len`, break inner loop.
3. If `l <= r` after all peeling, there is a middle chunk: `ans += 1`.
4. Return `ans`.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — O(n) iterations × O(n) string comparison |
| Space | O(n) — substring comparisons |

---

## Solution 2: Greedy with Rolling Hash — O(n) expected time, O(n) space

**Idea:** Use rolling hashes (Rabin-Karp style) to compare prefix and suffix in O(1) per step, reducing total to O(n) expected.

**Complexity:**

| | |
|---|---|
| Time | O(n) expected |
| Space | O(n) |
