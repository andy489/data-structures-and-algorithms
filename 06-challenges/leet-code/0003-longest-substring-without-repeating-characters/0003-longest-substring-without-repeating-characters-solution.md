# 3. Longest Substring Without Repeating Characters — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/longest-substring-without-repeating-characters/

---

## Solution

### Sliding Window with Hash Map — O(n) time, O(min(n, Σ)) space

**Idea:** Maintain a window `[left, right]` that always contains unique characters. As we advance `right`, if we encounter a duplicate, we shrink from the left until the duplicate is gone.

**Algorithm:**
1. Use a hash map `lastSeen` mapping each character to the last index where it was seen.
2. Keep a `left` pointer for the window's start, and iterate `right` from 0 to n-1.
3. If `s[right]` was seen at index `k` and `k >= left`, move `left = k + 1` (jump past the previous occurrence).
4. Update `lastSeen[s[right]] = right`.
5. Track the maximum `right - left + 1`.

**Why jumping works:** By storing the last index of each character, we can immediately skip `left` past the duplicate in O(1) rather than iterating character by character.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each character is visited at most twice (once by right, once logically by left) |
| Space | O(min(n, Σ)) — map holds at most Σ distinct characters (Σ = alphabet size) |
