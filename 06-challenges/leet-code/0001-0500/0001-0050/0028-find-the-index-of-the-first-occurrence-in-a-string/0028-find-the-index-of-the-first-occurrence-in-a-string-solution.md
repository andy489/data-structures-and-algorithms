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

---

## Solution 3: Z-Algorithm — O(n + m) time, O(n + m) space

**Idea:** Concatenate `needle + "$" + haystack` into a string `s`. Build the Z-array where `z[i]` is the length of the longest substring starting at `s[i]` that matches a prefix of `s`. Any position `i` in the haystack part where `z[i] >= m` is a match; the index in the original haystack is `i - m - 1`.

**Algorithm:**
1. Form `s = needle + "$" + haystack` (the `"$"` sentinel prevents a Z-value from spanning the boundary).
2. Build `z[0..len-1]` using the standard Z-box technique (maintain a window `[l, r]` of the rightmost matching segment).
3. For each `i` from `m + 1` to `len - 1`: if `z[i] >= m`, return `i - m - 1`.
4. Return `-1`.

**Complexity:**

| | |
|---|---|
| Time  | O(n + m) — one pass to build Z-array, one pass to scan |
| Space | O(n + m) — the concatenated string and Z-array |
