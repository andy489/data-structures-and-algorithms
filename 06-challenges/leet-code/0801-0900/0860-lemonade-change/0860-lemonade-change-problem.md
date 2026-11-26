# 860. Lemonade Change

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/lemonade-change/

---

## Problem Statement

At a lemonade stand, each lemonade costs `$5`. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills). Each customer will only buy one lemonade and pay with either a `$5`, `$10`, or `$20` bill. You must provide the correct change to each customer so that the net transaction is that they pay `$5`.

Note that you do not have any change in hand at first.

Return `true` if you can provide every customer the correct change, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  bills = [5,5,5,10,20]
Output: true
```

**Example 2:**
```
Input:  bills = [5,5,10,10,20]
Output: false
```

---

## Constraints

- `1 <= bills.length <= 10^5`
- `bills[i]` is either `5`, `10`, or `20`.
