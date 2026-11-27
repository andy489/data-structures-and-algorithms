# 3324. Find the Sequence of Strings Appeared on the Screen

## Approach

Simulate the minimum key presses to build each character:

1. For each character `c` in `target`, we need to:
   - Append 'a' by pressing key 1 (extend the current string with 'a')
   - Then press key 2 (`c - 'a'`) times to increment 'a' to `c`

2. Each intermediate state is added to the result list.

**Algorithm:**
- Maintain a `StringBuilder` current
- For each target character `c`:
  - Append 'a' to current, record the state
  - While current's last character != c: increment last char, record state

## Complexity

- **Time:** O(n * 26) where n is the length of target — in the worst case each character requires 25 increments
- **Space:** O(n * 26) for the output list
