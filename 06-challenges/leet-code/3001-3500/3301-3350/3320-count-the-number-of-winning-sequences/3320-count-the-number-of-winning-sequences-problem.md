# 3320. Count the Number of Winning Sequences

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/count-the-number-of-winning-sequences/

## Problem

Alice and Bob are playing a fantasy battle game consisting of `n` rounds where they summon one of three magical creatures each round: a Fire Dragon (F), a Water Serpent (W), or an Earth Golem (E).

Rules:
- Fire Dragon beats Earth Golem (+1 point for Fire).
- Water Serpent beats Fire Dragon (+1 point for Water).
- Earth Golem beats Water Serpent (+1 point for Earth).
- Same creature = no points.

You are given string `s` representing Alice's sequence. Bob must never summon the same creature in two consecutive rounds. Bob **beats** Alice if his total points are **strictly greater** than Alice's.

Return the number of distinct sequences Bob can use to beat Alice, modulo `10^9 + 7`.

## Examples

**Example 1:**
```
Input: s = "FFF"
Output: 3
Explanation: Bob's winning sequences: "WFW", "FWF", "WEW".
```

**Example 2:**
```
Input: s = "FWEFW"
Output: 18
```

## Constraints

- `1 <= s.length <= 1000`
- `s[i]` is either `'F'`, `'W'`, or `'E'`.
