# 336. Palindrome Pairs — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/palindrome-pairs/

---

## Solution: HashMap + All Splits — O(n * k²) time, O(n * k) space

**Idea:** For each word, try every split into prefix+suffix. If prefix is palindrome and reverse(suffix) is in map → pair found. If suffix is palindrome and reverse(prefix) is in map → pair found.

**Algorithm:**
1. Build `wordIndex` map.
2. For each word at index i and each split k: check prefix palindrome → look up rev(suffix); check suffix palindrome → look up rev(prefix).
3. Skip duplicate pairs from empty strings by requiring `k != len`.

**Complexity:**

| | |
|---|---|
| Time | O(n * k²) |
| Space | O(n * k) |
