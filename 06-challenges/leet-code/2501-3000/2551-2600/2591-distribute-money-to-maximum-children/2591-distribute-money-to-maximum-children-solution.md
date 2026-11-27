# Solution: 2591. Distribute Money to Maximum Children

## Approach

Use greedy reasoning:
1. First check if distribution is impossible: `money < children` (can't give each at least $1), or if `money > 8 * children` (can't avoid giving too much). Return -1 in these cases.
2. Each child gets at least $1. Reserve `children` dollars as the base. Now distribute the remaining `money - children` dollars.
3. Try to give as many children $8 each (which means adding $7 more above the base $1).
4. The number of children who can get $8 is `min((money - children) / 7, children)`.
5. After assigning $8 to some children, check the remainder: if remaining money for remaining children is exactly 3 (i.e., last child would get $4 which is forbidden), reduce count by 1.

## Complexity

- **Time:** O(1)
- **Space:** O(1)
