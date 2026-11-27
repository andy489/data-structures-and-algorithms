# 2953. Count Complete Substrings — Solution

## Approach: Split + Sliding Window per Distinct Count

**Key observations:**
1. The "adjacent characters differ by at most 2" constraint means we can split `word` into maximal segments where consecutive characters differ by at most 2.
2. Within each segment, a "complete" substring of length `m * k` (for some m = 1..26 distinct characters) has exactly `m` distinct characters each appearing exactly `k` times.

**Algorithm:**
1. Split `word` into maximal segments where `|word[i] - word[i-1]| <= 2`.
2. For each segment and each `m` in 1..26:
   - Use a sliding window of fixed size `m * k`.
   - Count windows where exactly `m` distinct characters each appear exactly `k` times.
   - Use a frequency map; a character "satisfies" the condition when its count equals exactly `k`. Track `satisfied` count; a window is complete when `satisfied == m`.

## Complexity

| | Time | Space |
|---|---|---|
| Split + 26 sliding windows | O(26 * n) = O(n) | O(26) = O(1) |
