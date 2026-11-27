# Solution: 3876. Construct Uniform Parity Array II

## Approach

The key difference from part I is that subtraction requires `nums1[i] - nums1[j] >= 1`, meaning `nums1[i] > nums1[j]`.

**Case: all odd**
- An odd `nums1[i]` stays odd (use it directly).
- An even `nums1[i]` needs `nums1[i] - nums1[j]` to be odd and positive. This requires `nums1[j]` to be odd and `nums1[j] < nums1[i]`.
- So for each even element, we need an odd element **smaller** than it.
- Condition: for every even element `e`, there exists an odd element `< e`.
- Equivalently: the minimum odd element < every even element.

**Case: all even**
- An even `nums1[i]` stays even.
- An odd `nums1[i]` needs `nums1[i] - nums1[j]` to be even and positive. This requires `nums1[j]` odd and `nums1[j] < nums1[i]`.
- So for each odd element, we need a smaller odd element.
- The smallest odd element has no smaller odd to use, so if there are any odd elements, the minimum odd one is stuck being odd.
- Condition: for every odd element `o`, there must be an odd element `< o`. This means only possible if there are no odd elements, OR the minimum odd can use a smaller odd. Since the minimum odd has none smaller, the only way is if there are no odd elements (all even array).

Simplified:
- All-even: `odds == 0`
- All-odd: for every even element, `min_odd < even element` (need `min_odd` to exist and be smaller than all evens)

## Complexity

- **Time:** O(n)
- **Space:** O(1)
