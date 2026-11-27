# 3889. Mirror Frequency Distance

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/mirror-frequency-distance/

## Problem Statement

You are given a string `s` consisting of lowercase English letters and digits.

For each character, its **mirror character** is defined by reversing the order of its character set:

- For letters, the mirror of a character is the letter at the same position from the end of the alphabet.
  - For example, the mirror of `'a'` is `'z'`, and the mirror of `'b'` is `'y'`, and so on.
- For digits, the mirror of a character is the digit at the same position from the end of the range `'0'` to `'9'`.
  - For example, the mirror of `'0'` is `'9'`, and the mirror of `'1'` is `'8'`, and so on.

For each **unique** character `c` in the string:

- Let `m` be its **mirror** character.
- Let `freq(x)` denote the number of times character `x` appears in the string.
- Compute the **absolute difference** between their **frequencies**, defined as: `|freq(c) - freq(m)|`

The mirror pairs `(c, m)` and `(m, c)` are the same and must be counted **only once**.

Return an integer denoting the total sum of these values over all such **distinct mirror pairs**.

## Examples

### Example 1
**Input:** `s = "ab1z9"`
**Output:** `3`

**Explanation:**
| c | m | freq(c) | freq(m) | \|freq(c) - freq(m)\| |
|---|---|---------|---------|----------------------|
| a | z | 1       | 1       | 0                    |
| b | y | 1       | 0       | 1                    |
| 1 | 8 | 1       | 0       | 1                    |
| 9 | 0 | 1       | 0       | 1                    |

Answer: 0 + 1 + 1 + 1 = 3

### Example 2
**Input:** `s = "4m7n"`
**Output:** `2`

### Example 3
**Input:** `s = "byby"`
**Output:** `0`

## Constraints

- `1 <= s.length <= 5 * 10^5`
- `s` consists only of lowercase English letters and digits.
