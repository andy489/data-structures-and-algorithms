# 2240. Number of Ways to Buy Pens and Pencils

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/number-of-ways-to-buy-pens-and-pencils/

## Approach: Enumerate Pens Count

Iterate over all possible numbers of pens (0 to total/cost1), and for each count compute how many pencils can be bought with the remaining money.

**Algorithm:**
- For each `i` pens: ways += (total - i * cost1) / cost2 + 1
- Sum all ways.

**Complexity:**
- Time: O(total / cost1)
- Space: O(1)
