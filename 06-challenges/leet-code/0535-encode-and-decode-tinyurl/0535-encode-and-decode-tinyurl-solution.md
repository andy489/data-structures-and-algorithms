# 535. Encode and Decode TinyURL — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/encode-and-decode-tinyurl/

---

## Solution: HashMap with Counter — O(1) time, O(n) space

**Idea:** Maintain a counter as the short URL key. Store `counter → longUrl` in a map. The short URL is `http://tinyurl.com/<counter>`.

**Complexity:**

| | |
|---|---|
| Time | O(1) per encode/decode |
| Space | O(n) — n URLs stored |
