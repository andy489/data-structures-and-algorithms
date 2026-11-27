# 1807. Evaluate the Bracket Pairs of a String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

---

## Problem Statement

You are given a string `s` that contains some bracket pairs, with each pair containing a **non-empty** key.

- For example, in the string `"(name)is(age)yearsold"`, there are two bracket pairs that contain the keys `"name"` and `"age"`.

You know the values of a wide range of keys. This is represented by a 2D string array `knowledge` where each `knowledge[i] = [key_i, value_i]` indicates that key `key_i` has a value of `value_i`.

You are tasked to evaluate **all** of the bracket pairs. When you evaluate a bracket pair that contains some key `key_i`, you will:

- Replace `(key_i)` with the corresponding `value_i` from `knowledge` if it is present.
- Replace `(key_i)` with `"?"` if it is not present.

Each key will appear at most once in `knowledge`.

Return the resulting string after evaluating all of the bracket pairs.

---

## Examples

**Example 1:**
```
Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
Output: "bobistwoyearsold"
```

**Example 2:**
```
Input: s = "hi(name)", knowledge = [["a","b"]]
Output: "hi?"
```

**Example 3:**
```
Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
Output: "yesyesyesaaa"
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `0 <= knowledge.length <= 10^5`
- `knowledge[i].length == 2`
- `1 <= key_i.length, value_i.length <= 10`
- `s` consists of lowercase English letters and round brackets `'('` and `')'`
- Every open bracket `'('` in `s` will have a corresponding close bracket `')'`
- The key in each bracket pair of `s` will be non-empty
- There will not be any nested bracket pairs in `s`
- `key_i` and `value_i` consist of lowercase English letters
- Each `key_i` in `knowledge` is unique
