# 2954. Count the Number of Infection Sequences

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-the-number-of-infection-sequences/

## Problem

You are given an integer `n` and an array `sick` sorted in increasing order, representing positions of infected people in a line of `n` people.

At each step, one uninfected person adjacent to an infected person gets infected. This process continues until everyone is infected.

An **infection sequence** is the order in which uninfected people become infected, excluding those initially infected.

Return the number of different infection sequences possible, modulo `10^9 + 7`.

## Examples

**Example 1:**
```
Input: n = 5, sick = [0,4]
Output: 4
Explanation:
There is a total of 6 different sequences overall.
Valid infection sequences are [1,2,3], [1,3,2], [3,2,1] and [3,1,2].
[2,3,1] and [2,1,3] are not valid because person at index 2 cannot be infected first.
```

**Example 2:**
```
Input: n = 4, sick = [1]
Output: 3
Explanation:
There is a total of 6 different sequences overall.
Valid infection sequences are [0,2,3], [2,0,3] and [2,3,0].
[3,2,0], [3,0,2], and [0,3,2] are not valid.
```

## Constraints

- `2 <= n <= 10^5`
- `1 <= sick.length <= n - 1`
- `0 <= sick[i] <= n - 1`
- `sick` is sorted in increasing order.
