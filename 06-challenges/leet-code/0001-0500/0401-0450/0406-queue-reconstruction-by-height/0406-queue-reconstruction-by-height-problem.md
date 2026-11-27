# 406. Queue Reconstruction by Height

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/queue-reconstruction-by-height/

---

## Problem Statement

You are given an array `people` where `people[i] = [hi, ki]`:
- `hi` is the height of the `i`th person
- `ki` is the number of people in front of the `i`th person who have a height **greater than or equal** to `hi`

Reconstruct and return the queue that is represented by the input array. The returned queue should be formatted as an array `queue` where `queue[j] = [hj, kj]` is the attributes of the `j`th person in the queue (0-indexed).

---

## Examples

**Example 1:**
```
Input:  people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
```

**Example 2:**
```
Input:  people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
```

---

## Constraints

- `1 <= people.length <= 2000`
- `0 <= hi <= 10^6`
- `0 <= ki < people.length`
- It is guaranteed that the queue can be reconstructed
