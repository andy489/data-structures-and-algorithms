# 28. Find the Index of the First Occurrence in a String — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

---

## Solution: Sliding Window — O(n·m) time, O(1) space

**Idea:** Slide a window of length `m` (needle length) across `haystack`. At each position `i`, compare the substring `haystack[i..i+m-1]` with `needle`. Return `i` on the first match.

**Algorithm:**
1. Let `n = haystack.length()`, `m = needle.length()`.
2. Iterate `i` from `0` to `n - m` inclusive.
3. If `haystack.substring(i, i + m).equals(needle)`, return `i`.
4. Return `-1`.

**Complexity:**

| | |
|---|---|
| Time  | O(n·m) — up to n positions, each requiring an O(m) comparison |
| Space | O(1) — no extra storage beyond loop variables |

---

## Solution 2: KMP (Knuth–Morris–Pratt) — O(n + m) time, O(m) space

**Idea:** Precompute a failure function `lps[]` for `needle` that encodes the longest proper prefix which is also a suffix at each position. Use it to skip redundant comparisons during the search.

**Algorithm:**
1. Build `lps[0..m-1]`: for each position `i` in `needle`, store the length of the longest proper prefix of `needle[0..i]` that is also a suffix.
2. Search: maintain `j` (index into needle). For each character in haystack:
   - While `j > 0` and characters mismatch, set `j = lps[j - 1]`.
   - If characters match, increment `j`.
   - If `j == m`, a full match is found — return `i - m + 1`.
3. Return `-1` if no match found.

**Complexity:**

| | |
|---|---|
| Time  | O(n + m) — linear preprocessing + linear search |
| Space | O(m) — the `lps` array |
