# 3090. Maximum Length Substring With Two Occurrences — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Expand right pointer; if any character count exceeds 2, shrink left pointer.

**Algorithm:**
1. Use sliding window [l, r].
2. freq[s[r]]++. While freq[s[r]] > 2: freq[s[l]]--, l++.
3. Track max(r-l+1).

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) — each char added/removed at most once |
| Space | O(1) — O(26) = O(1) |
