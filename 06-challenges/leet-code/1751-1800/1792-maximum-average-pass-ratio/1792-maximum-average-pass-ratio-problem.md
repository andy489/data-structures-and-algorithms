# 1792. Maximum Average Pass Ratio

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-average-pass-ratio/

---

## Problem Statement

There is a school that has classes of students and each class will be having a final exam. You are given a 2D integer array `classes`, where `classes[i] = [pass_i, total_i]`. You know beforehand that in the `i`th class, there are `total_i` total students, but only `pass_i` number of students will pass the exam.

You are also given an integer `extraStudents`. There are another `extraStudents` brilliant students that are **guaranteed** to pass the exam of any class they are assigned to. You want to assign each of the `extraStudents` students to a class in a way that **maximizes** the **average** pass ratio across all the classes.

The **pass ratio** of a class is equal to the number of students of the class that will pass the exam divided by the total number of students of the class. The **average pass ratio** is the sum of pass ratios of all the classes divided by the number of classes.

Return the **maximum** possible average pass ratio after assigning the `extraStudents` students. Answers within `10^-5` of the actual answer will be accepted.

---

## Examples

**Example 1:**
```
Input: classes = [[1,2],[3,5],[2,2]], extraStudents = 2
Output: 0.78333
Explanation: Assign the two extra students to the first class. The average pass ratio will be equal to (3/4 + 3/5 + 2/2) / 3 = 0.78333.
```

**Example 2:**
```
Input: classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
Output: 0.53485
```

---

## Constraints

- `1 <= classes.length <= 10^5`
- `classes[i].length == 2`
- `1 <= pass_i <= total_i <= 10^5`
- `1 <= extraStudents <= 10^5`
