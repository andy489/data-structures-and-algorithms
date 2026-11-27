# 3334. Find the Maximum Factor Score of Array

## Approach

**Brute Force with prefix/suffix precomputation:**

Since `nums.length <= 100`, we can precompute prefix GCD/LCM and suffix GCD/LCM arrays.

- `prefGcd[i]` = GCD of nums[0..i-1]
- `prefLcm[i]` = LCM of nums[0..i-1]
- `sufGcd[i]` = GCD of nums[i..n-1]
- `sufLcm[i]` = LCM of nums[i..n-1]

For each index `i` we want to remove:
- `combinedGcd = gcd(prefGcd[i], sufGcd[i+1])`
- `combinedLcm = lcm(prefLcm[i], sufLcm[i+1])`
- factor score = combinedGcd * combinedLcm

Take the maximum over all removals (and no removal = full array score).

Handle edge cases: empty array (score 0), single element (score = x*x).

## Complexity

- **Time:** O(n * log(max)) for building prefix/suffix arrays
- **Space:** O(n) for the arrays
