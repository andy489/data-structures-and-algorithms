# 3325. Count Substrings With K-Frequency Characters I

## Approach

**Sliding Window (Two Pointers):**

For each starting index `i`, use a sliding window to find the smallest ending index `j` such that the substring `s[i..j]` has at least one character appearing at least `k` times. All substrings from `s[i..j]` to `s[i..n-1]` will also be valid.

**Algorithm:**
- Use a frequency map and a sliding window with two pointers `l` (left) and `r` (right)
- For each `r`, expand the window and update frequency
- When a character reaches frequency `k`, all substrings starting from `l` to `r` and ending at `r` or beyond are valid
- Count: `n - r` substrings are valid for each valid `r`

Alternatively, use the complement: total substrings - substrings where NO character appears k times. The complement can be counted with two pointers.

**Direct approach:** For each left `l`, find the minimum right `r` where some char has freq >= k. Then `ans += n - r`.

## Complexity

- **Time:** O(n * 26) = O(n) where n = s.length
- **Space:** O(26) = O(1) for the frequency array
