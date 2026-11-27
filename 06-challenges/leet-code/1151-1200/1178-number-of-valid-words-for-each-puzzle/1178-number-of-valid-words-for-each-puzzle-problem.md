# 1178. Number of Valid Words for Each Puzzle

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-valid-words-for-each-puzzle/

---

## Problem Statement

With respect to a given `puzzle` string, a `word` is **valid** if both the following conditions are satisfied:
- `word` contains the **first letter** of `puzzle`.
- For each letter in `word`, that letter is in `puzzle`.

For example, if the puzzle is `"abcdefg"`, then valid words are `"faced"`, `"cabbage"`, and `"cbag"` while invalid words include `"beefed"` (does not include `'a'`) and `"based"` (includes `'s'` which is not in the puzzle).

Return an array `answer`, where `answer[i]` is the number of words in the given word list `words` that are valid with respect to the puzzle `puzzles[i]`.

---

## Examples

**Example 1:**
```
Input:  words = ["aaaa","asas","able","ability","actt","actor","access"],
        puzzles = ["aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"]
Output: [1,1,3,2,4,0]
```

**Example 2:**
```
Input:  words = ["apple","pleas","please"],
        puzzles = ["aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"]
Output: [0,1,3,2,0]
```

---

## Constraints

- `1 <= words.length <= 10^5`
- `4 <= words[i].length <= 50`
- `1 <= puzzles.length <= 10^4`
- `puzzles[i].length == 7`
- `words[i]` and `puzzles[i]` consist of lowercase English letters
- Each `puzzles[i]` does not contain repeated characters
