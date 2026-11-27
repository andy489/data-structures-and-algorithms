# 3335. Total Characters in String After Transformations I

## Approach

**Character frequency simulation:**

Instead of tracking the actual string, track only the frequency of each character (26 letters). In each transformation:
- For chars 'a' to 'y': `freq[c+1] += freq[c]`, then `freq[c] = 0` (or shift)
- For 'z': `freq['a'] += freq['z']`, `freq['b'] += freq['z']`, then `freq['z'] = 0`

After `t` transformations, the answer is the sum of all frequencies (mod 10^9+7).

**Efficient approach:** We can represent the transformation as a vector-matrix multiplication over Z/(10^9+7), but since t <= 10^5, simple simulation over 26-element arrays is fast enough.

For each step, we apply the transformation on the 26-element frequency array. Total: 26 * t operations = 26 * 10^5 = 2.6 * 10^6, which is fast.

## Complexity

- **Time:** O(26 * t) = O(t) effectively
- **Space:** O(26) = O(1)
