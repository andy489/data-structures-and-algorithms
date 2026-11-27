# 3337. Total Characters in String After Transformations II

## Approach

**Matrix Exponentiation:**

Each character's transformation can be modeled as a linear system. Let `v[i]` = count of character `i` in the current string.

After one transformation:
- For character `i` (0-indexed), it becomes the next `nums[i]` consecutive characters.
- So `new[j] += v[i]` for each `j` in `[(i+1) % 26 .. (i + nums[i]) % 26]`.

This defines a 26x26 transformation matrix `M` where `M[j][i] = 1` if character `i` contributes to character `j`.

After `t` steps, the final count vector is `M^t * v`.

Use **matrix exponentiation** (fast exponentiation) to compute `M^t` in O(26^3 * log t) time.

**Answer:** Sum of all entries in `M^t * v` modulo 10^9+7.

Since `t` can be up to 10^9, matrix exponentiation is essential (direct simulation would be too slow).

## Complexity

- **Time:** O(n + 26^3 * log t) where n = s.length
- **Space:** O(26^2) for the matrix
