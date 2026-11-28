# 2942. Find Words Containing Character — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-words-containing-character/

---

## Solution: Linear Scan — O(n * m) time, O(1) extra space

**Idea:** Iterate over all words, check if the character `x` is present in each word, and collect the index if it is.

**Algorithm:**
1. Initialize an empty result list.
2. For each index `i`, if `words[i]` contains character `x`, add `i` to the result.
3. Return the result list.

**Complexity:**

| | |
|---|---|
| Time | O(n * m) |
| Space | O(1) extra (output not counted) |
