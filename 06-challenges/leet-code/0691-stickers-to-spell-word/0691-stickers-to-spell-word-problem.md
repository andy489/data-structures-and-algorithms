# 691. Stickers to Spell Word

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stickers-to-spell-word/

---

## Problem Statement

We are given `n` different types of stickers. Each sticker has a lowercase English word on it.

You would like to spell out the given string `target` by cutting individual letters from your collection of stickers and rearranging them. You can use each sticker more than once, and you have infinite copies of each sticker.

Return the **minimum number of stickers** that you need to spell out `target`. If the task is impossible, return `-1`.

---

## Examples

**Example 1:**
```
Input:  stickers = ["with","example","science"], target = "thehat"
Output: 3
Explanation: We use 2 "with" stickers and 1 "science" sticker.
```

**Example 2:**
```
Input:  stickers = ["notice","possible"], target = "basicbasic"
Output: -1
```

---

## Constraints

- `n == stickers.length`
- `1 <= n <= 50`
- `1 <= stickers[i].length <= 10`
- `1 <= target.length <= 15`
- `stickers[i]` and `target` consist of lowercase English letters.
