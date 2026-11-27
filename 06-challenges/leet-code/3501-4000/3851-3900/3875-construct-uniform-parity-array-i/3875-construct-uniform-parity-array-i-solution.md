# Solution: 3875. Construct Uniform Parity Array I

## Approach

Key observations:
- `nums1[i] - nums1[j]` has the same parity as `nums1[i] - nums1[j]`, which equals even if `nums1[i]` and `nums1[j]` have the same parity, and odd otherwise.
- To make `nums2[i]` even: use `nums1[i]` if it's even, or `nums1[i] - nums1[j]` where `nums1[j]` is odd (even - odd = odd... wait, we need even, so use `nums1[i] - nums1[j]` where both are same parity).
- To make `nums2[i]` odd: use `nums1[i]` if it's odd, or `nums1[i] - nums1[j]` where they differ in parity.

**Case: all even**
- For each `nums1[i]`: it's even already (use it), OR `nums1[i] - nums1[j]` is even when `nums1[j]` has same parity as `nums1[i]`.
- An odd element `nums1[i]` can become even if there exists some odd `nums1[j]` (j != i). This is possible when there are at least 2 odd numbers.
- An even element is already even.
- So all-even is possible if: every odd element can find another odd element to subtract from.

**Case: all odd**
- An even `nums1[i]` becomes odd if there exists an odd `nums1[j]` (even - odd = odd).
- An odd `nums1[i]` is already odd.
- So all-odd is possible if: every even element can find at least one odd element.

Simplified: 
- All-even: possible if count of odd numbers is 0, or count of odd numbers >= 2.
- All-odd: possible if count of even numbers is 0, or (count of odd numbers >= 1 so each even element can subtract an odd one).

## Complexity

- **Time:** O(n)
- **Space:** O(1)
