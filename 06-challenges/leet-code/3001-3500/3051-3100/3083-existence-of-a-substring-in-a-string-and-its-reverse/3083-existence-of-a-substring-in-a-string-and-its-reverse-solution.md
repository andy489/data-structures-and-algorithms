# 3083. Existence Of A Substring In A String And Its Reverse — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/

---

## Solution: HashSet — O(n) time, O(n) space

**Idea:** Collect all 2-char substrings of s into a set, then check if any reversed 2-char substring of s is in that set.

**Algorithm:**
1. Build set of all s[i..i+1] for valid i.
2. For each i, check if reversed pair (s[i+1]+s[i]) is in the set.
3. Return true if found, false otherwise.

**Complexity:**

| | |
|---|---|
| Time | O(n) — O(n) |
| Space | O(n) — O(n) |
