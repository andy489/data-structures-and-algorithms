# 3365. Rearrange K Substrings to Form Target String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/

---

## Solution: Frequency Map of Chunks — O(n) time, O(n) space

**Idea:** Divide both `s` and `t` into `k` equal chunks of length `n/k`. We need to check whether the multiset of chunks from `s` equals the multiset of chunks from `t`. Use a HashMap to count occurrences of each chunk from `s`, then subtract for each chunk of `t`.

**Algorithm:**
1. Compute `len = s.length() / k`.
2. For each index `i` in `[0, k)`, extract `s[i*len .. (i+1)*len)` and increment its count in the map.
3. For each index `i` in `[0, k)`, extract `t[i*len .. (i+1)*len)` and decrement its count. If the count drops below 0, return `false`.
4. Return `true`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — building the map takes O(n) total across all k chunks |
| Space | O(n) — storing up to k substrings of total length n |
