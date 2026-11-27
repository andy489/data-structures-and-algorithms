# 2037. Minimum Number of Moves to Seat Everyone

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/

---

## Problem Statement

There are `n` seats and `n` students in a room. `seats[i]` is the position of the i-th seat and `students[j]` is the position of the j-th student. In one move, a student can move one position to the left or right. Return the minimum number of moves to seat all students.

---

## Examples

**Example 1:**
```
Input:  seats = [3,1,5], students = [2,7,4]
Output: 4
```
Explanation: Sort both: seats [1,3,5], students [2,4,7]. Moves: 1+1+2=4.

**Example 2:**
```
Input:  seats = [4,1,5,9], students = [1,3,2,6]
Output: 7
```

**Example 3:**
```
Input:  seats = [2,2,6,6], students = [1,3,2,6]
Output: 4
```

---

## Constraints

- `n == seats.length == students.length`
- `1 <= n <= 100`
- `1 <= seats[i], students[j] <= 100`
