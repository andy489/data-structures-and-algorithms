# 14. Longest Common Prefix — Solution

**Difficulty:** Easy  
**Link:** https://leetcode.com/problems/longest-common-prefix/

---

## Solution

### Horizontal Scanning — O(S) time, O(1) space

**Idea:** Start with the first string as the prefix candidate. Compare it against each subsequent string, trimming the candidate from the right until it matches the beginning of the current string.

**Algorithm:**
1. `prefix = strs[0]`
2. For each `strs[i]` (i from 1 to n-1):
   - While `strs[i]` does not start with `prefix`:
     - `prefix = prefix[0..len-2]` (drop last character)
     - If `prefix` is empty, return `""`.
3. Return `prefix`.

**Complexity:**

| | |
|---|---|
| Time | O(S) where S = total number of characters across all strings |
| Space | O(1) — the prefix is a substring of the first string |

### Vertical Scanning — O(S) time, O(1) space

Compare character by character column by column (position 0 of all strings, then position 1, etc.). Stop as soon as any string is exhausted or a mismatch is found. This can be faster in practice when the common prefix is short, since we terminate early.

### Divide and Conquer — O(S) time, O(m·log n) space

Split the array into halves, find the LCP of each half recursively, then find the LCP of the two results. More complex but elegant; the log n depth of recursion incurs extra space.
