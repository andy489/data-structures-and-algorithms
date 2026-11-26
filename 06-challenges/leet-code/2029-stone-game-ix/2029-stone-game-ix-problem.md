# 2029. Stone Game IX

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/stone-game-ix/

---

## Problem Statement

Alice and Bob take turns removing stones. Alice goes first. Each turn remove one stone. If the running sum is divisible by 3, Alice loses. Alice wins if she can keep playing until all stones removed. Count of stones of each type (mod 3 gives 0, 1, 2). Return true if Alice wins.

---

## Examples

**Example 1:**
```
Input:  stones = [2,1]
Output: true
```

**Example 2:**
```
Input:  stones = [2]
Output: false
```

**Example 3:**
```
Input:  stones = [5,1,2,4,3]
Output: false
```

---

## Constraints

- `1 <= stones.length <= 10^5`
- `1 <= stones[i] <= 10^4`
