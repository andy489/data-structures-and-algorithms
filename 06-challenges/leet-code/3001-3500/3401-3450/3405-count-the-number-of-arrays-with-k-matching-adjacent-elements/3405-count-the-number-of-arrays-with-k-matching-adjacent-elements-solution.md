# Solution: Count the Number of Arrays with K Matching Adjacent Elements

## Approach

Think combinatorially. An array of length n has n-1 adjacent pairs. Exactly k of them are "equal" (arr[i-1] == arr[i]).

**Step 1: Choose which k positions (out of n-1) have equal adjacent pairs.**
This is C(n-1, k).

**Step 2: Count arrays with exactly those k positions equal.**
The array can be decomposed into "runs" of consecutive equal elements. With k equal pairs, there are (n-1-k) "change" positions, meaning n-k distinct runs. 

The first element can be any of m values. Each subsequent run must differ from the previous. So:
- First element: m choices
- Each of the (n-k-1) subsequent runs: (m-1) choices (must differ from previous)

Total = m * (m-1)^(n-k-1)

**Combined:** C(n-1, k) * m * (m-1)^(n-k-1)

Use modular arithmetic and precomputed factorials for C(n-1, k).

## Complexity

| | Complexity |
|---|---|
| Time | O(n) for factorial precomputation |
| Space | O(n) |
