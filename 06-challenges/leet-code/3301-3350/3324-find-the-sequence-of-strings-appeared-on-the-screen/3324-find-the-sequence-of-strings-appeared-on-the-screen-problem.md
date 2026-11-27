# 3324. Find the Sequence of Strings Appeared on the Screen

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/

## Problem

You are given a string `target`.

Alice is going to type `target` on her computer using a special keyboard that has **only two** keys:

- Key 1 appends the character `"a"` to the string on the screen.
- Key 2 changes the **last** character of the string on the screen to its **next** character in the English alphabet. For example, `"c"` changes to `"d"` and `"z"` changes to `"a"`.

**Note** that initially there is an *empty* string `""` on the screen, so she can **only** press key 1.

Return a list of *all* strings that appear on the screen as Alice types `target`, in the order they appear, using the **minimum** key presses.

## Examples

**Example 1:**

Input: `target = "abc"`
Output: `["a","aa","ab","aba","abb","abc"]`

Explanation:
- Press key 1 → "a"
- Press key 1 → "aa"
- Press key 2 → "ab"
- Press key 1 → "aba"
- Press key 2 → "abb"
- Press key 2 → "abc"

**Example 2:**

Input: `target = "he"`
Output: `["a","b","c","d","e","f","g","h","ha","hb","hc","hd","he"]`

## Constraints

- `1 <= target.length <= 400`
- `target` consists only of lowercase English letters.
