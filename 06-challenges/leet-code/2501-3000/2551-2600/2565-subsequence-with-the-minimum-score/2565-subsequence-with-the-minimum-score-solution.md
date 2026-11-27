# 2565. Subsequence With the Minimum Score — Solution

## Approach: Prefix + Suffix Matching with Binary Search

**Key Insight:** We want to remove a contiguous segment `[left, right]` from `t` and minimize `right - left + 1`. The remaining parts `t[0..left-1]` and `t[right+1..m-1]` must together form a subsequence of `s`.

**Algorithm:**
1. Precompute `pre[i]` = number of characters of `t` that can be matched as a prefix subsequence in `s[0..i]`. Specifically, `pre[i]` = max characters from start of `t` matched up to `s[i]`.
2. Precompute `suf[i]` = number of characters of `t` that can be matched as a suffix subsequence in `s[i..n-1]`. Specifically, `suf[i]` = max characters from end of `t` matched from `s[i]`.
3. Binary search on the answer (window size): for each possible `left`, find the minimum `right` such that `pre[index_matching_left_chars] + suf[...]` covers all needed characters.

**Cleaner approach:** 
- `preMatch[i]` = number of `t` prefix chars matched using `s[0..i]`.
- `sufMatch[i]` = number of `t` suffix chars matched using `s[i..n-1]`.
- For the segment `[l, r]` in `t` to be removable: `preMatch[some_s_pos] >= l` AND `sufMatch[some_s_pos+1] >= m - 1 - r`.
- Binary search on window size; for each window size `w`, check if any split works.

## Complexity

- **Time:** O((n + m) log m) — prefix/suffix arrays in O(n+m), binary search with O(n) check
- **Space:** O(n + m) — for prefix and suffix arrays
