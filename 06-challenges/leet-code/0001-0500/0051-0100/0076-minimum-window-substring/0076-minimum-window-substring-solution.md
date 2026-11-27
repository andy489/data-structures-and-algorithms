# 76. Minimum Window Substring — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-window-substring/

---

## Solution: Sliding Window — O(m + n) time, O(1) space

**Idea:** Maintain a window `[left, right]` over `s`. Use a frequency map `need` for characters in `t` and a counter `formed` tracking how many distinct characters are currently satisfied (i.e., their count in the window meets the required count). Expand `right` to include new characters; once all are satisfied (`formed == required`), contract `left` to minimize the window, recording the best.

**Algorithm:**
1. Build `need` map from `t`; `required = need.size()`.
2. Use `window` map to track current window frequencies.
3. Expand `right`: increment `window[c]`; if `window[c] == need[c]`, increment `formed`.
4. While `formed == required`: update best answer if current window is smaller; shrink from `left`.
5. Return the best substring (or `""` if never found).

**Complexity:**

| | |
|---|---|
| Time | O(m + n) — each character visited at most twice (once by right, once by left) |
| Space | O(1) — maps bounded by alphabet size (52 distinct chars) |
