# 1807. Evaluate the Bracket Pairs of a String — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

---

## Solution: HashMap Lookup — O(n + k) time, O(n + k) space

**Idea:** Build a dictionary from the `knowledge` list, then scan `s` once. For each regular character, append it to the result. For each `(`, find the matching `)`, look up the enclosed key in the dictionary, and append the value or `"?"`.

**Algorithm:**
1. Load all `[key, value]` pairs from `knowledge` into a `HashMap`.
2. Iterate through `s` with index `i`:
   - If `s[i] == '('`, find the closing `')'` using `indexOf` (or scan forward), extract the key, look it up in the map, and append the result.
   - Otherwise, append the character directly.
3. Return the built string.

**Complexity:**

| | |
|---|---|
| Time | O(n + k) — one pass over s of length n, map build from k entries |
| Space | O(n + k) — output buffer of size n, map of size k |
