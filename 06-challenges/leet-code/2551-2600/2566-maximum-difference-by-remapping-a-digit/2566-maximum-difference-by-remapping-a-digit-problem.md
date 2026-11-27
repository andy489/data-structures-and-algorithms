# 2566. Maximum Difference by Remapping a Digit

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-difference-by-remapping-a-digit/

---

## Problem Statement

You are given an integer `num`. You know that Bob will sneakily **remap** one of the 10 possible digits (`0` to `9`) to another digit.

Return the difference between the maximum and minimum values Bob can make by remapping **exactly one** digit in `num`.

**Notes:**
- When Bob remaps a digit `d1` to another digit `d2`, Bob replaces all occurrences of `d1` in `num` with `d2`.
- Bob can remap a digit to itself, in which case `num` does not change.
- Bob can remap different digits for obtaining minimum and maximum values respectively.
- The resulting number after remapping can contain leading zeroes.

---

## Examples

**Example 1:**
```
Input:  num = 11891
Output: 99009
```
*Explanation:* To achieve the maximum value, Bob remaps digit 1 to 9 to yield 99899. To achieve the minimum value, Bob remaps digit 1 to 0, yielding 890. The difference is 99009.

**Example 2:**
```
Input:  num = 90
Output: 99
```
*Explanation:* The maximum value is 99 (0 replaced by 9) and the minimum is 0 (9 replaced by 0). Difference is 99.

---

## Constraints

- `1 <= num <= 10^8`
