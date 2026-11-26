# 1744. Can You Eat Your Favorite Candy on Your Favorite Day

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/

---

## Problem Statement

You are given a **(0-indexed)** array of positive integers `candiesCount` where `candiesCount[i]` represents the number of candies of the `i`th type. You are also given a 2D array `queries` where `queries[i] = [favoriteTypei, favoriteDayi, dailyCapi]`.

You play a game with the following rules:

- You start eating candies on day **0**.
- You **cannot** eat **any** candy of type `i` unless you have eaten **all** candies of type `j` where `j < i`.
- You must eat **at least one** candy per day until you finish all the candies.
- Note that you can eat different types of candy on the same day.

For each query, determine if you can eat a candy of type `favoriteTypei` on day `favoriteDayi` without violating the rules.

Return a boolean array `answer` where `answer[i]` is `true` if you can eat a candy of type `favoriteTypei` on day `favoriteDayi`, and `false` otherwise.

---

## Examples

**Example 1:**
```
Input: candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
Output: [true,false,true]
```

**Example 2:**
```
Input: candiesCount = [5,2,6,4,1], queries = [[3,1,2],[4,10,3],[3,10,100],[4,100,30],[1,3,1]]
Output: [false,true,true,false,false]
```

---

## Constraints

- `1 <= candiesCount.length <= 10^5`
- `1 <= candiesCount[i] <= 10^5`
- `1 <= queries.length <= 10^5`
- `queries[i].length == 3`
- `0 <= favoriteTypei < candiesCount.length`
- `0 <= favoriteDayi <= 10^9`
- `1 <= dailyCapi <= 10^9`
