# 1032. Stream of Characters

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stream-of-characters/

---

## Problem Statement

Design an algorithm that accepts a stream of characters and checks if a suffix of these characters is a string in a given array of strings `words`.

Implement the `StreamChecker` class:
- `StreamChecker(String[] words)` Initializes the object with the strings array `words`.
- `boolean query(char letter)` Accepts a new character from the stream and returns `true` if any non-empty suffix from the stream forms a word that is in `words`.

---

## Examples

**Example 1:**
```
Input:  ["StreamChecker","query","query","query","query","query","query"]
        [[['a','b','c','d','e','f']],["a"],["b"],["c"],["d"],["e"],["f"]]
Output: [null,false,false,false,false,false,true]
```

---

## Constraints

- `1 <= words.length <= 2000`
- `1 <= words[i].length <= 2000`
- `words[i]` consists of lowercase English letters.
- `letter` is a lowercase English letter.
- At most `4 * 10^4` calls will be made to `query`.
