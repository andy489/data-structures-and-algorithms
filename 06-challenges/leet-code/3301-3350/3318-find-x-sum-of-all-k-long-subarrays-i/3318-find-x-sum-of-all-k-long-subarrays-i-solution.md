# Solution: Find X-Sum of All K-Long Subarrays I

## Approach: Brute Force (Small Constraints)

Since `n <= 50` and `k <= 50`, we can use brute force: for each window of size `k`, compute the x-sum directly.

**x-sum computation:**
1. Count element frequencies in the window.
2. Sort by (frequency desc, value desc) to get the top-x most frequent.
3. Sum the top-x elements multiplied by their frequencies.

## Complexity

- **Time:** O((n - k + 1) * k log k) — for each window, sort the frequency map.
- **Space:** O(k) per window.
