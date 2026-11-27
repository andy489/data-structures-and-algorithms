# 1974. Minimum Time to Type Word Using Special Typewriter

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/

## Problem

There is a special typewriter with lowercase English letters `'a'` to `'z'` arranged in a circle with a pointer. A character can only be typed if the pointer is pointing to that character. The pointer is initially pointing to the character `'a'`.

Each second, you may perform one of the following operations:

- Move the pointer one character counterclockwise or clockwise.
- Type the character the pointer is currently on.

Given a string `word`, return the minimum number of seconds to type out the characters in `word`.

## Examples

**Example 1:**
```
Input: word = "abc"
Output: 5
Explanation:
- Type the character 'a' in 1 second since the pointer is initially on 'a'.
- Move the pointer clockwise to 'b' in 1 second.
- Type the character 'b' in 1 second.
- Move the pointer clockwise to 'c' in 1 second.
- Type the character 'c' in 1 second.
```

**Example 2:**
```
Input: word = "bza"
Output: 7
```

**Example 3:**
```
Input: word = "zjpc"
Output: 34
```

## Constraints

- `1 <= word.length <= 100`
- `word` consists of lowercase English letters.
