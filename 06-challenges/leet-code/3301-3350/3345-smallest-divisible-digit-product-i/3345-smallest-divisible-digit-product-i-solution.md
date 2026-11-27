# 3345. Smallest Divisible Digit Product I — Solution

## Approach: Linear Scan

Since `n <= 100` and `t <= 10`, we can linearly scan from `n` upward. For each candidate number, compute the product of its digits and check if it is divisible by `t`. Return the first match.

**Note:** A digit of 0 makes the product 0, and 0 is divisible by any `t`. So numbers containing 0 (like 10, 20, 100, etc.) always satisfy the condition.

## Complexity

- **Time:** O(answer - n) — at most a small constant in practice given the constraints.
- **Space:** O(1) — constant extra space.
