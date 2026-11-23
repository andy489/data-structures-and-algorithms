# Solution: Employee Bonus

## Approach
LEFT JOIN Employee with Bonus on `empId`. Filter rows where bonus IS NULL or bonus < 1000.

**Time:** O(n) | **Space:** O(n)
