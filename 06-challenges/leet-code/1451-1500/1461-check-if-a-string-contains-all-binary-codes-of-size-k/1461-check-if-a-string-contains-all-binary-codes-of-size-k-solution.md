# 1461. Check If A String Contains All Binary Codes Of Size K — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

---

## Solution: HashSet Sliding Window — O(n) time, O(2^k) space

**Idea:** Collect all length-k substrings into a set. Check if set size == 2^k.

**Algorithm:**
1. Add every length-k substring to a set.
2. Return set.size() == (1 << k).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(2^k) |
