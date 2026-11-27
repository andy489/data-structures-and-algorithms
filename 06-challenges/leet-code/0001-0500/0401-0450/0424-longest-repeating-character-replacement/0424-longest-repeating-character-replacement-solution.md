# 424. Longest Repeating Character Replacement — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-repeating-character-replacement/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Maintain a sliding window. The window is valid when `(window size) - (count of most frequent char) <= k`. Expand right always; shrink left only when invalid. Track the historical maximum frequency seen — we never need to shrink the window below the current best answer size.

**Algorithm:**
1. Maintain frequency array of 26 chars and `maxFreq` (max frequency ever seen in any window).
2. Expand `right`; update frequency and `maxFreq`.
3. If `(right - left + 1) - maxFreq > k`, slide left by 1 (don't update `maxFreq` on shrink — we only care about larger windows).
4. Answer is the final window size `right - left + 1`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass |
| Space | O(1) — 26-char frequency array |
