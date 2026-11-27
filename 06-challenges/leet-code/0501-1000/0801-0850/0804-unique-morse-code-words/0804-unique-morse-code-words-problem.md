# 804. Unique Morse Code Words

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/unique-morse-code-words/

---

## Problem Statement

International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes. Given an array of strings `words`, return the number of different **transformations** among all words we have.

The Morse code for each letter: `[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]`

---

## Examples

**Example 1:**
```
Input:  words = ["gin","zen","gig","msg"]
Output: 2
Explanation: "gin" -> "--...-.", "zen" -> "--...-.", "gig" -> "--...--.", "msg" -> "--...--."
```

---

## Constraints

- `1 <= words.length <= 100`
- `1 <= words[i].length <= 12`
- `words[i]` consists of lowercase English letters.
