# 192. Word Frequency

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/word-frequency/

---

## Problem Statement

Write a bash script to calculate the frequency of each word in a text file `words.txt`.

For simplicity sake, you may assume:

- `words.txt` contains only lowercase characters and space `' '` characters.
- Each word must consist of lowercase characters only.
- Words are separated by one or more whitespace characters.

---

## Examples

**Example:**
```
Input (words.txt):
the day is sunny the the
the sunny is is

Output:
the 4
is 3
sunny 2
day 1
```

---

## Constraints

- Output should be sorted by frequency from highest to lowest.
- If two words have the same frequency, sort them alphabetically (the problem states each word's frequency is unique in its example, but in general practice ties are sorted alphabetically).
