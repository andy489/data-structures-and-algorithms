# 30. Substring with Concatenation of All Words — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/substring-with-concatenation-of-all-words/

---

## Solution: Sliding Window with Frequency Maps — O(n · k) time, O(k) space

**Idea:** Since all words share the same length `w`, there are exactly `w` distinct "phases" (offsets 0, 1, …, w−1) in which a valid concatenation can start. For each phase, maintain a sliding window of exactly `k * w` characters (where `k = words.length`) that advances word-by-word. Track which words from the required multiset the window currently covers using two frequency maps: `need` (target counts) and `have` (current window counts). A counter `matched` tracks how many distinct words are fully satisfied. When the window contains more copies of a word than needed, shrink from the left until the excess is removed.

**Algorithm:**
1. Build `need` map from `words`. Let `w = words[0].length()`, `k = words.length`.
2. For each offset `i` in `[0, w)`:
   - Use two pointers `left = i`, `right = i`, and a `matched` counter.
   - Advance `right` by `w` each step. Extract the word `cur = s[right..right+w)`.
   - If `cur` is not in `need`, reset: clear `have`, `matched = 0`, `left = right + w`.
   - Otherwise increment `have[cur]`. If `have[cur] == need[cur]`, increment `matched`.
   - While `have[cur] > need[cur]`, remove the leftmost word from `have` (shrink left by `w`), decrementing `matched` if needed.
   - If `matched == need.size()`, record `left` as a valid start.
3. Return all recorded indices.

**Complexity:**

| | |
|---|---|
| Time  | O(n · k) — each of the `w` phases scans `n/w` windows, each window operation is O(1) amortized; overall O(n) for string operations, but hash map ops per window add O(k) worst case |
| Space | O(k) — the two frequency maps store at most `k` distinct words |
