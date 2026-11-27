# 1177. Can Make Palindrome from Substring — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/can-make-palindrome-from-substring/

---

## Solution: Prefix XOR Bitmask — O(n + q) time, O(n) space

**Idea:** For a substring to become a palindrome after at most `k` replacements, count how many characters appear an odd number of times. Each replacement can fix 2 odd-count characters. So we need `ceil(odd_count / 2) <= k`.

Use a prefix XOR bitmask (each bit = parity of one of 26 letters). The XOR of prefix[right+1] and prefix[left] gives the parity bitmask of the substring. The number of set bits in this mask is the count of characters with odd frequencies.

**Algorithm:**
1. Build `prefix[0..n]` where `prefix[i] = prefix[i-1] XOR (1 << (s[i-1] - 'a'))`.
2. For each query `[left, right, k]`: compute `mask = prefix[right+1] XOR prefix[left]`.
3. Count `oddCount = popcount(mask)`.
4. Return `oddCount / 2 <= k`.

**Complexity:**

| | |
|---|---|
| Time | O(n + q) — one pass to build prefix, O(1) per query |
| Space | O(n) — prefix bitmask array |
