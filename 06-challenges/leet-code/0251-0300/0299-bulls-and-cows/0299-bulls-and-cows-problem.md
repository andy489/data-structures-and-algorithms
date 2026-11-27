# 299. Bulls and Cows

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bulls-and-cows/

---

## Problem Statement

You are playing the **Bulls and Cows** game with your friend.

You write down a secret number and ask your friend to guess what the number is. When your friend makes a guess, you provide a hint with the following info:

- The number of "bulls", which is the number of digits in the guess that are in the correct position.
- The number of "cows", which is the number of digits in the guess that are in your secret number but located in the wrong position. Specifically, the non-bull digits in the guess that could be rearranged such that they become bulls.

Given the secret number `secret` and your friend's guess `guess`, return the hint for your friend's guess.

The hint should be formatted as `"xAyB"`, where `x` is the number of bulls and `y` is the number of cows. Note that both `secret` and `guess` may contain duplicate digits.

---

## Examples

**Example 1:**
```
Input:  secret = "1807", guess = "7810"
Output: "1A3B"
Explanation: Bulls are indicated with 'A' and cows are indicated with 'B'.
"1807"
  |
"7810"
1 bull and 3 cows (7, 1, 0 are cows).
```

**Example 2:**
```
Input:  secret = "1123", guess = "0111"
Output: "1A1B"
Explanation: The 1st digit 1 in both secret and guess are bulls. The 2nd digit 1 in the guess is a cow since '1' is used in the secret (once).
```

---

## Constraints

- `1 <= secret.length, guess.length <= 1000`
- `secret.length == guess.length`
- `secret` and `guess` consist of digits only.
