# 204. Count Primes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-primes/

---

## Solution 1: Sieve of Eratosthenes — O(n log log n) time, O(n) space

**Idea:** Create a boolean array `isComposite` of size `n`, initially all `false`. For each number `i` starting from 2, if it is not yet marked composite, it is prime — mark all its multiples starting from `i*i` as composite. Count the entries still `false` at the end.

**Algorithm:**
1. If `n < 2`, return `0`.
2. Allocate `isComposite[0..n-1]`, all `false`.
3. For `i` from `2` to `√n`:
   - If `isComposite[i]` is `false`, mark `isComposite[i*i], isComposite[i*i+i], ...` as `true` (stop before `n`).
4. Count and return the number of indices `i` in `[2, n-1]` where `isComposite[i]` is `false`.

**Complexity:**

| | |
|---|---|
| Time | O(n log log n) — see proof below |
| Space | O(n) — boolean array of size n |

**Time complexity proof:**

The total work is the number of multiples marked across all primes p ≤ √n:

$$\sum_{p \leq \sqrt{n},\ p \text{ prime}} \frac{n}{p}$$

By Mertens' second theorem:

$$\sum_{p \leq x,\ p \text{ prime}} \frac{1}{p} = \log \log x + M + O\!\left(\frac{1}{\log x}\right)$$

where M ≈ 0.2615 is the Meissel–Mertens constant. Multiplying through by n gives O(n log log n) total operations.

---

## Solution 2: Linear Sieve (Sieve of Euler) — O(n) time, O(n) space

**Idea:** Maintain a list of discovered primes. For each number `i`, mark `i * p` as composite for every prime `p` in the list, stopping once `p` divides `i`. Each composite is crossed out exactly once (by its smallest prime factor), achieving true O(n) time.

**Algorithm:**
1. If `n < 2`, return `0`.
2. Allocate `isComposite[0..n-1]`, all `false`. Maintain a `primes` list.
3. For `i` from `2` to `n-1`:
   - If `isComposite[i]` is `false`, add `i` to `primes`.
   - For each prime `p` in `primes` while `i * p < n`:
     - Mark `isComposite[i * p] = true`.
     - If `i % p == 0`, break (p is the smallest prime factor of i).
4. Return `primes.size()`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — see proof below |
| Space | O(n) — isComposite array + primes list |

**Time complexity proof:**

Every composite number `c` has a unique smallest prime factor `spf(c)`. The linear sieve marks `c` exactly when `i = c / spf(c)` and `p = spf(c)` — this pair `(i, p)` is unique for each composite. Therefore the inner loop executes at most once per composite number in `[2, n)`, giving O(n) total iterations across all outer-loop steps.

---

## Solution 3: Segmented Sieve — O(n log log n) time, O(√n) space

**Idea:** First sieve primes up to √n using O(√n) space. Then process the range `[2, n)` in blocks of size √n, using only a small O(√n) boolean block array. For each block, mark composites using the precomputed primes. This reduces peak memory from O(n) to O(√n), improving cache efficiency significantly for large `n`.

**Algorithm:**
1. Compute `limit = √n`. Sieve primes up to `limit` with a standard sieve into `smallPrimes`.
2. For each segment `[low, high)` where `high = min(low + limit, n)`, starting from `low = 2`:
   - Allocate a block boolean array of size `high - low`.
   - For each prime `p` in `smallPrimes`, mark all multiples of `p` in `[low, high)` as composite, starting from `max(p*p, ceil(low/p)*p)`.
   - Count unmarked entries in the block (those are prime); add to result.
3. Return total count.

**Complexity:**

| | |
|---|---|
| Time | O(n log log n) — see proof below |
| Space | O(√n) — only a √n-sized block is live at any time |

**Time and space complexity proof:**

*Space:* The initial sieve uses an array of size `limit = √n`. Each segment block is also of size `limit`. Both are O(√n); no O(n) array is ever allocated.

*Time:* The total marking work across all segments equals the total work of the standard sieve — each composite `c` is marked exactly once, in the segment containing it, by its smallest prime factor `p ≤ √n`. The aggregate count of mark operations is:

$$\sum_{p \leq \sqrt{n},\ p \text{ prime}} \left\lfloor \frac{n}{p} \right\rfloor = O\!\left(n \sum_{p \leq \sqrt{n}} \frac{1}{p}\right) = O(n \log \log n)$$

The O(√n log log √n) cost of the initial small-prime sieve is dominated by this term.
