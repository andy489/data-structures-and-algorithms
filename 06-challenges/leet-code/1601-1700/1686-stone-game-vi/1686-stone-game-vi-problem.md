# 1686. Stone Game VI

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game-vi/

---

## Problem Statement

Alice and Bob take turns playing a game, with Alice starting first.

There are `n` stones in a pile. On each player's turn, they can **remove** a stone from the pile and receive points based on the stone's value. Alice and Bob may **value the stones differently**.

You are given two integer arrays of length `n`, `aliceValues` and `bobValues`. Each `aliceValues[i]` and `bobValues[i]` represents how Alice and Bob, respectively, value the `i`-th stone.

The winner is the person with the most points after all the stones are chosen. If both players have the same number of points, the game results in a draw. Both players will play **optimally**. Both players know the other's values.

Determine the result of the game:

- Return `1` if Alice wins.
- Return `-1` if Bob wins.
- Return `0` if the game results in a draw.

---

## Examples

**Example 1:**
```
Input: aliceValues = [1,3], bobValues = [2,1]
Output: 1
Explanation: Alice takes stone 1 (aliceValues[1] = 3). Bob takes stone 0 (bobValues[0] = 2).
Alice has 3, Bob has 2. Alice wins.
```

**Example 2:**
```
Input: aliceValues = [1,2], bobValues = [3,1]
Output: 0
Explanation: Alice takes stone 0 (aliceValues[0] = 1). Bob takes stone 1 (bobValues[1] = 1). Draw.
```

**Example 3:**
```
Input: aliceValues = [2,4,3], bobValues = [1,6,7]
Output: -1
```

---

## Constraints

- `n == aliceValues.length == bobValues.length`
- `1 <= n <= 10^5`
- `1 <= aliceValues[i], bobValues[i] <= 100`
