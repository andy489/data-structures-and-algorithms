# Solution: 3881. Direction Assignments with Exactly K Visible People

## Approach

The person at `pos` sees:
- `left = pos` people to the left (indices 0..pos-1)
- `right = n - 1 - pos` people to the right (indices pos+1..n-1)

Each person independently chooses 'L' or 'R'.
- A left person (i < pos) is seen iff they choose 'L'.
- A right person (i > pos) is seen iff they choose 'R'.

The person at pos itself can choose either direction (doesn't affect visibility count).

We need exactly `k` people visible. Let `a` be the number of left-people choosing 'L' and `b` be number of right-people choosing 'R'. We need `a + b = k`.

For each valid split `(a, b)` with `a + b = k`, `0 <= a <= left`, `0 <= b <= right`:
- Ways to choose left assignments: `C(left, a)` (choose which a people face 'L')
- Ways to choose right assignments: `C(right, b)`
- Person at pos has 2 choices

Answer = `2 * sum over a from max(0, k-right) to min(k, left) of C(left, a) * C(right, k-a)`

This equals `2 * C(left + right, k)` by Vandermonde's identity.

So the answer is `2 * C(n-1, k) mod (10^9+7)`.

## Complexity

- **Time:** O(n)
- **Space:** O(n)
