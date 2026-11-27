# 855. Exam Room

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/exam-room/

---

## Problem Statement

There is an exam room with `n` seats in a single row labeled from `0` to `n - 1`.

When a student enters the room, they must sit in the seat that maximizes the distance to the closest person. If there are multiple such seats, they sit in the lowest numbered seat. If no one is in the room, the student sits at seat number `0`.

Design a class that simulates this process.

Implement the `ExamRoom` class:
- `ExamRoom(int n)` Initializes the object of the exam room with the number of seats `n`.
- `int seat()` Returns the label of the seat at which the next student will set.
- `void leave(int p)` Indicates that the student sitting at seat `p` will leave the room. It is guaranteed that there will be a student sitting at seat `p`.

---

## Examples

**Example 1:**
```
Input:  ["ExamRoom", "seat", "seat", "seat", "seat", "leave", "seat"]
        [[10], [], [], [], [], [4], []]
Output: [null, 0, 9, 4, 2, null, 5]
```

---

## Constraints

- `1 <= n <= 10^9`
- It is guaranteed that there is a student sitting at seat `p`.
- At most `10^4` calls will be made to `seat` and `leave`.
