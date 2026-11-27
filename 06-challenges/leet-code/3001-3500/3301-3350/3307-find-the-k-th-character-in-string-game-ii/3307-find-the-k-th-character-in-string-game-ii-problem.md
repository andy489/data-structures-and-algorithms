# 3307. Find the K-th Character in String Game II

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/

## Problem

Alice and Bob are playing a game. Initially, Alice has a string `word = "a"`.

You are given a **positive** integer `k` and an integer array `operations`, where `operations[i]` represents the **type** of the `i`th operation.

Bob will ask Alice to perform **all** operations in sequence:
- If `operations[i] == 0`, **append** a copy of `word` to itself.
- If `operations[i] == 1`, generate a new string by **changing** each character in `word` to its **next** character in the English alphabet, and **append** it to the original `word`.

Return the value of the `k`th character in `word` after performing all the operations.

**Note** that the character `'z'` can be changed to `'a'` in the second type of operation.

## Examples

**Example 1:**
```
Input: k = 5, operations = [0,0,0]
Output: "a"
Explanation:
word goes: "a" -> "aa" -> "aaaa" -> "aaaaaaaa"
```

**Example 2:**
```
Input: k = 10, operations = [0,1,0,1]
Output: "b"
Explanation:
word goes: "a" -> "aa" -> "aabb" -> "aabbaabb" -> "aabbaabbbbccbbcc"
```

## Constraints

- `1 <= k <= 10^14`
- `1 <= operations.length <= 55`
- `operations[i]` is either `0` or `1`.
- The input is generated such that after all operations, `word` has **at least** `k` characters.
