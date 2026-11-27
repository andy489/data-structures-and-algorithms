# 2241. Design an ATM Machine

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/design-an-atm-machine/

## Approach: Greedy Withdrawal from Largest Denomination

Store the count of each denomination. For withdrawal, greedily take as many of the largest denomination as possible, then proceed to smaller ones. If the total doesn't match the requested amount, return [-1] without updating state.

**Complexity:**
- deposit: O(1)
- withdraw: O(1) (5 denominations)
- Space: O(1)
