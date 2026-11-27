# 3947. Maximum Number of Items From Sale II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/

## Problem

You are given a 2D integer array `items`, where `items[i] = [factor_i, price_i]` represents the `i`-th item. You are also given an integer `budget`.

There are unlimited copies of each item available for purchase. You may buy any number of copies of any items such that the total cost of the purchased copies is at most `budget`.

After buying items, you may receive free copies according to the following rules:

- Each purchased copy of item `i` can give you **at most one** free copy of another item `j`.
- The free item must satisfy `i != j` and `factor_i` divides `factor_j`.
- For each ordered pair `(i, j)`, you can receive a free copy of item `j` from purchases of item `i` **at most once**, regardless of how many copies of item `i` you buy.
- The same item `j` can be received multiple times for free if it is received from purchases of different item types.

Return the **maximum total number of item copies** you can obtain, including both purchased copies and free copies, while spending at most `budget` on purchased items.

## Examples

**Example 1:**
```
Input: items = [[1,6],[2,4],[3,5]], budget = 19
Output: 5
Explanation:
- You can buy 2 copies of item 0 and 1 copy of item 1 for a total cost of 2*6+4=16.
- One purchased copy of item 0 gives 1 free copy of item 1 (factor 1 divides factor 2).
- The other purchased copy of item 0 gives 1 free copy of item 2 (factor 1 divides factor 3).
- You leave with 3 purchased copies and 2 free copies, for a total of 5.
```

**Example 2:**
```
Input: items = [[2,8],[1,10],[6,6],[4,12],[5,20],[5,17]], budget = 35
Output: 7
Explanation:
- You can buy 2 copies of item 0, 1 copy of item 1, and 1 copy of item 2 for a total cost of 2*8+10+6=32.
- One purchased copy of item 0 gives 1 free copy of item 2 (factor 2 divides factor 6).
- The other purchased copy of item 0 gives 1 free copy of item 3 (factor 2 divides factor 4).
- The purchased copy of item 1 gives 1 free copy of item 2 (factor 1 divides factor 6).
- Buying item 2 gives no free copy.
- You leave with 4 purchased copies and 3 free copies, for a total of 7.
```

## Constraints

- `1 <= items.length <= 10^5`
- `items[i] = [factor_i, price_i]`
- `1 <= factor_i <= items.length`
- `1 <= price_i <= 10^9`
- `1 <= budget <= 10^9`
