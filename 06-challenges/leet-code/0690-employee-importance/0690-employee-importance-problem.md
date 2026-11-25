# 690. Employee Importance

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/employee-importance/

---

## Problem Statement

You have a data structure of employee information, including the employee's **unique ID**, **importance value**, and **direct subordinates' IDs**.

Given a list of employees `employees` and an integer `id`, return the **total importance value** of the employee with the given `id` and all their direct and indirect subordinates.

---

## Examples

**Example 1:**
```
Input:  employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
Output: 11
Explanation: Employee 1 has value 5 and has subordinates 2 and 3. Their total importance is 5+3+3 = 11.
```

**Example 2:**
```
Input:  employees = [[1,2,[5]],[5,-3,[]]], id = 5
Output: -3
```

---

## Constraints

- `1 <= employees.length <= 2000`
- `1 <= employees[i].id <= 2000`
- All `employees[i].id` are **unique**.
- `-100 <= employees[i].importance <= 100`
- One employee has at most one direct leader and may have several direct subordinates.
- The IDs in `employees[i].subordinates` are valid IDs.
