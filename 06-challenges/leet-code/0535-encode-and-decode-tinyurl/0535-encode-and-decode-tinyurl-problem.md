# 535. Encode and Decode TinyURL

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/encode-and-decode-tinyurl/

---

## Problem Statement

> Note: This is a companion problem to the System Design problem.

TinyURL is a URL shortening service where you enter a URL such as `https://leetcode.com/problems/design-tinyurl` and it returns a short URL such as `http://tinyurl.com/4e9iAk`. Design a class to encode a URL and decode a tiny URL.

There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.

Implement the `Solution` class:
- `String encode(String longUrl)` Returns a tiny URL for the given `longUrl`.
- `String decode(String shortUrl)` Returns the original long URL for the given `shortUrl`.

**Note:** It is guaranteed that the given `shortUrl` was encoded by the same object.

---

## Constraints

- `1 <= url.length <= 10^4`
- `url` is guranteed to be a valid URL.
