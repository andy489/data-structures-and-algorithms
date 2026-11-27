# Solution: 2573. Find the String with LCP

## Approach: Greedy Construction + Validation

**Step 1: Build the string greedily**

Assign each position the smallest possible character. Start by assigning `'a'` to position 0. For each subsequent position `i`:
- Check if any previously assigned position `j < i` has `lcp[j][i] > 0`. If so, `word[i]` must equal `word[j]`, which we already know.
- Otherwise, assign the next smallest available character (greedy: 'a', then 'b', etc.).

If we ever need more than 26 distinct characters, return `""`.

**Step 2: Validate the constructed string**

Compute the actual LCP matrix from the bottom-right up using DP:
- If `word[i] == word[j]`: `actual_lcp[i][j] = actual_lcp[i+1][j+1] + 1` (if i+1 < n and j+1 < n, else 1)
- Else: `actual_lcp[i][j] = 0`

Check if `actual_lcp == lcp`. If not, return `""`.

**Step 3: Return the constructed string**

## Detailed Construction

For each position `i` from `0` to `n-1`:
- For each `j < i`: if `lcp[j][i] > 0`, then `word[i] = word[j]` (forced assignment)
- If no constraint: assign smallest available char that doesn't conflict

Handle conflicts: if `lcp[j][i] > 0` and `word[j]` is already assigned and conflicts with another forced value, return `""`.

## Complexity

- **Time:** O(n^2) for construction and validation
- **Space:** O(n^2) for LCP validation matrix
