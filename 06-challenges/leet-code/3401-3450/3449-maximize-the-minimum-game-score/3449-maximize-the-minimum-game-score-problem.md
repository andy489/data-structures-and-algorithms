# 3449. Maximize the Minimum Game Score

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-the-minimum-game-score/

## Problem

You are given an array points of size n and an integer m. There is another array gameScore of size n, where gameScore[i] represents the score achieved at the ith game. Initially, gameScore[i] == 0 for all i.

You start at index -1, which is outside the array (before the first position at index 0). You can make at most m moves. In each move, you can either:

- Increase the index by 1 and add points[i] to gameScore[i].
- Decrease the index by 1 and add points[i] to gameScore[i].

Note that the index must always remain within the bounds of the array after the first move.

Return the maximum possible minimum value in gameScore after at most m moves.

## Examples

**Example 1:**
```
Input: points = [2,4], m = 3
Output: 4
Explanation:
Move 1: Increase i to 0, gameScore = [2, 0]
Move 2: Increase i to 1, gameScore = [2, 4]
Move 3: Decrease i to 0, gameScore = [4, 4]
The minimum value in gameScore is 4.
```

**Example 2:**
```
Input: points = [1,2,3], m = 5
Output: 2
Explanation:
Move to index 0 -> 1 -> 0 -> 1 -> 2: gameScore = [2, 4, 3]
The minimum value in gameScore is 2.
```

## Constraints

- 2 <= n == points.length <= 5 * 10^4
- 1 <= points[i] <= 10^6
- 1 <= m <= 10^9
