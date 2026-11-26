# 1520. Maximum Number of Non-Overlapping Substrings — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-number-of-non-overlapping-substrings/

---

## Solution: Greedy Interval Expansion — O(n * 26) time, O(n) space

**Idea:** For each character `c`, compute the minimal valid substring `[left[c], right[c]]` where `left[c]` = first occurrence and `right[c]` = last occurrence. But the interval must also contain all occurrences of every character within it — so we expand the right boundary until stable. Then use a greedy algorithm: iterate left to right, and for each starting character, check if the expanded interval is valid (starts at current position). If so, it's a candidate; take the one that ends earliest (greedy for maximum count with minimum length).

**Algorithm:**
1. For each character `c`, record `first[c]` and `last[c]`.
2. `getRight(i)`: expand right boundary starting from `i` — for each character in `s[i..r]`, extend `r` to max of current `r` and `last[char]`. Return the final `r` (or -1 if `first[char]` < `i`, meaning the interval can't start at `i`).
3. Iterate positions left to right. Only consider position `i` if `first[s[i]] == i` (this is the first occurrence). Call `getRight(i)`. If valid, it's a candidate interval `[i, r]`.
4. Greedy: among non-overlapping candidates picked by earliest end, collect results.

**Complexity:**

| | |
|---|---|
| Time | O(n * 26) — for each of n starts, expansion is O(n) but amortized O(26) per start |
| Space | O(n) — result list |
