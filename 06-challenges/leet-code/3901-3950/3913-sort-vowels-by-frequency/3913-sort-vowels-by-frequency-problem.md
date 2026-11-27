# 3913. Sort Vowels by Frequency

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/sort-vowels-by-frequency/

## Problem

You are given a string `s` consisting of lowercase English characters.

Rearrange only the **vowels** in the string so that they appear in **non-increasing** order of their frequency.

If multiple vowels have the same **frequency**, order them by the position of their **first occurrence** in `s`.

Return the modified string.

Vowels are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

The **frequency** of a letter is the number of times it occurs in the string.

## Examples

**Example 1:**
```
Input: s = "leetcode"
Output: "leetcedo"

Explanation: Vowels [e,e,o,e] with freq e=3, o=1. Sort by freq desc -> eeeо.
Place back into vowel positions.
```

**Example 2:**
```
Input: s = "aeiaaioooa"
Output: "aaaaoooiie"

Explanation: Frequencies: a=4, o=3, i=2, e=1. Sort desc by freq -> aaaaoooiie.
```

**Example 3:**
```
Input: s = "baeiou"
Output: "baeiou"

Explanation: All vowels have frequency 1; keep order by first occurrence.
```

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of lowercase English letters.
