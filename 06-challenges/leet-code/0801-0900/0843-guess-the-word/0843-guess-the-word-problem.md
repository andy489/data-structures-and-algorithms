# 843. Guess the Word

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/guess-the-word/

---

## Problem Statement

You are given an array of unique strings `words` where `words[i]` is six letters long. One word in this list is chosen as `secret`. With a provided `Master` interface, call `master.guess(word)` to get the number of exact matches (same character, same position) between `word` and `secret`. Find the `secret` within 10 guesses.

---

## Examples

**Example 1:**
```
Input:  secret = "acckzz", words = ["acckzz","ccbazz","eiowzz","abcczz","mpfair","owmzly","dttqdn"]
(The function should guess "acckzz" within 10 calls)
```

---

## Constraints

- `1 <= words.length <= 100`
- `words[i].length == 6`
- `words[i]` consists of lowercase English letters.
- All strings in `words` are unique.
- `secret` exists in `words`.
- `10` guesses allowed.
