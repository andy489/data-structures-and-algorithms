# 2073. Time Needed to Buy Tickets

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/time-needed-to-buy-tickets/

---

## Problem Statement

There are `n` people in a queue. `tickets[i]` = number of tickets the i-th person wants to buy. Each second, the first person buys 1 ticket (if they still need tickets) and goes to the back; otherwise they leave. Return the time (seconds) for person `k` to finish buying all their tickets.

---

## Examples

**Example 1:**
```
Input:  tickets = [2,3,2], k = 2
Output: 6
```

**Example 2:**
```
Input:  tickets = [5,1,1,1], k = 0
Output: 8
```

---

## Constraints

- `n == tickets.length`
- `1 <= n <= 100`
- `1 <= tickets[i] <= 100`
- `0 <= k < n`
