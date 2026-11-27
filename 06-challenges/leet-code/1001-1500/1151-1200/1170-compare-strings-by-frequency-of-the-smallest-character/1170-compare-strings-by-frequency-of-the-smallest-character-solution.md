# 1170. Compare Strings by Frequency of the Smallest Character — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/

---

## Solution: Sort + Binary Search — O((m + n) log(m + n)) time, O(m) space

**Idea:** Precompute `f` for all words, sort them. For each query compute `f(query)` and binary-search the sorted word-f array for the first value strictly greater. The count of words with `f > f(query)` is `m - lowerBound(sortedWordFs, f(query)+1)`.

**Algorithm:**
1. Compute `f(s)` for each word and sort the resulting array.
2. For each query, compute `f(query)`.
3. Binary-search for the first position where `wordFs[pos] > f(query)`.
4. Answer = `m - pos`.

**Complexity:**

| | |
|---|---|
| Time | O((m + n) log m) — sort words O(m log m), binary search per query O(n log m) |
| Space | O(m) — sorted word-f array |
