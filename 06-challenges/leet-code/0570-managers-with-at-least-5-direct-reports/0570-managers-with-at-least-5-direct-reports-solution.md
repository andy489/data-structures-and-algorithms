# Solution: Managers with at Least 5 Direct Reports

## Approach
Group the Employee table by `managerId`, count rows in each group, filter for count >= 5, then join back to get the manager's name.

**Time:** O(n) | **Space:** O(n)
