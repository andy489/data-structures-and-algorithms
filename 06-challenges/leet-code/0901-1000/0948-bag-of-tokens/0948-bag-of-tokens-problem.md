# 948. Bag of Tokens

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/bag-of-tokens/

---

## Problem Statement

You have an initial **power** of `power`, an initial **score** of `0`, and a bag of tokens where `tokens[i]` is the value of the `i`th token (0-indexed).

Your goal is to maximize your total **score** by potentially playing each token in one of two ways:
- If your current power is at least `tokens[i]`, you may play the `i`th token face-up, losing `tokens[i]` power and gaining `1` score.
- If your current score is at least `1`, you may play the `i`th token face-down, gaining `tokens[i]` power and losing `1` score.

Return *the maximum number of score* you can attain after playing **any** number of tokens.

---

## Examples

**Example 1:**
```
Input:  tokens = [100,200,300,400], power = 200
Output: 2
```

---

## Constraints

- `0 <= tokens.length <= 1000`
- `0 <= tokens[i], power < 10^6`
