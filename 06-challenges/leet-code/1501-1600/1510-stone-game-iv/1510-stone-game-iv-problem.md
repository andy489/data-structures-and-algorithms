# 1510. Stone Game IV

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/stone-game-iv/

---

## Problem Statement

Alice and Bob take turns playing a game, with Alice starting first.

Initially, there are `n` stones in a pile. On each player's turn, that player makes a *move* consisting of removing **any** non-zero **square number** of stones in the pile.

Also, if a player cannot make a move, he/she loses the game.

Given a positive integer `n`, return `true` if and only if Alice wins the game, assuming both players play optimally.

---

## Examples

**Example 1:**
```
Input:  n = 1
Output: true
Explanation: Alice can remove 1 stone winning the game because Bob doesn't have any moves.
```

**Example 2:**
```
Input:  n = 2
Output: true
Explanation: Alice can remove 1 stone, leaving 2 - 1 = 1 stone for Bob.
             Bob removes 1 stone, leaving 0 stones.
             Alice doesn't have any moves, so Bob wins the game… wait, Alice should remove 1 to leave Bob at 1 and that means Bob has to move on 1 stone. Bob removes 1, Alice faces 0 and loses... Actually Alice wins: she removes 1, Bob removes 1, Alice faces 0 and loses. Hmm. Actually for n=2: dp[0]=false, dp[1]=true, dp[2]: subtract 1^2=1 → dp[1]=true means if dp[1] is W, moving to it means opponent wins, so n=2 subtract 1→ Bob wins → bad. Subtract 4>2 impossible. So dp[2]=false? Let me re-check: dp[2] = false, dp[3] = true (subtract 1 → dp[2]=false).
Output: false
```

**Example 3:**
```
Input:  n = 4
Output: true
Explanation: In the starting position, there are 4 stones. Alice removes 4 stones (1 perfect square), winning the game.
```

---

## Constraints

- `1 <= n <= 10^5`
