# 274. H-Index — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/h-index/

---

## Solution: Counting Sort / Bucket — O(n) time, O(n) space

**Idea:** Create a bucket array of size `n+1` where `bucket[i]` = number of papers with exactly `i` citations (papers with `>= n` citations go in bucket `n`). Scan from the high end, accumulating a count of papers with at least that many citations. The first position where `count >= h` is the answer.

**Algorithm:**
1. Build `bucket[0..n]`; cap citations at `n`.
2. Accumulate from `n` down: `count += bucket[i]`. When `count >= i`, return `i`.
3. Return `0` if none found.

**Complexity:**

| | |
|---|---|
| Time | O(n) — two linear passes |
| Space | O(n) — bucket array of size n+1 |
