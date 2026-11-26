# 1456. Maximum Number Of Vowels In A Substring Of Given Length — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

---

## Solution: Sliding Window — O(n) time, O(1) space

**Idea:** Maintain a sliding window of size k. Track vowel count in current window.

**Algorithm:**
1. Count vowels in first k chars. Slide: add new char (if vowel +1), remove old char (if vowel -1). Track max.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
