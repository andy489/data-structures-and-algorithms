# 911. Online Election

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/online-election/

---

## Problem Statement

You are given two integer arrays `persons` and `times`. In the `i`th vote, `persons[i]` voted at time `times[i]`.

Implement the `TopVotedCandidate` class:
- `TopVotedCandidate(int[] persons, int[] times)` Initializes the object with the `persons` and `times` arrays.
- `int q(int t)` Returns the number of the person that was leading the election at time `t`.

---

## Examples

**Example 1:**
```
Input:  ["TopVotedCandidate","q","q","q","q","q","q"]
        [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
```

---

## Constraints

- `1 <= persons.length <= 5000`
- `times.length == persons.length`
- `0 <= persons[i] < persons.length`
- `0 <= times[i] <= 10^9`
- `times` is sorted in a strictly increasing order.
- `times[0] <= t <= times[times.length - 1]`
- At most `10^4` calls will be made to `q`.
