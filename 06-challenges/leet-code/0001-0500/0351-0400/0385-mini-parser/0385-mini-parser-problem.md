# 385. Mini Parser

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/mini-parser/

---

## Problem Statement

Given a string `s` represents the serialization of a nested list, implement a parser to deserialize it and return the deserialized `NestedInteger`.

Each element is either an integer or a list whose elements may also be integers or other lists.

The `NestedInteger` interface has these methods:
- `NestedInteger()` — an empty list
- `NestedInteger(int value)` — a single integer
- `boolean isInteger()` — true if it holds an integer
- `Integer getInteger()` — returns the integer
- `void setInteger(int value)` — sets the integer
- `void add(NestedInteger ni)` — adds to this list
- `List<NestedInteger> getList()` — returns the list

---

## Examples

**Example 1:**
```
Input:  s = "324"
Output: 324
```

**Example 2:**
```
Input:  s = "[123,[456,[789]]]"
Output: [123,[456,[789]]]
```

---

## Constraints

- `1 <= s.length <= 5 * 10^4`
- `s` consists of digits, square brackets, a negative sign `-`, and commas.
- `s` is the serialization of valid `NestedInteger`.
- All the values in the input are in the range `[-10^6, 10^6]`.
