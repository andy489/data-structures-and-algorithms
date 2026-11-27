# 3389. Minimum Operations to Make Character Frequencies Equal — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-operations-to-make-character-frequencies-equal/

---

## Solution: DP over alphabet with carry — O(n + 26 * max_freq) time, O(26) space

**Idea:** For a fixed target frequency `k`, compute the minimum operations to make every character appear exactly `k` times (or 0 times — we can delete all occurrences). Process characters `a` to `z` left-to-right, keeping a `carry` of "extra" frequency that can be donated to the next character via change operations.

For each character `i` with frequency `f`:
- Effective frequency after receiving carry: `f + carry`.
- If `f + carry > k`: we have excess. We must delete `f + carry - k` occurrences (cost), and carry forward 0.
- If `f + carry < k`: we can either delete all `f + carry` occurrences (cost = `f + carry`) or insert `k - (f + carry)` occurrences (cost = `k - f - carry`). Take the minimum.
- If `f + carry == k`: cost 0, carry = 0.

But wait — carry from letter `i` to `i+1` via "change" means we can convert some occurrences of `i` into `i+1`. So if `f > k`, the excess `f - k` can either be deleted OR changed to `i+1` (carry). We choose what minimizes total cost.

Actually the carry model: excess from letter `i` over `k` can be forwarded free (via change), so we carry it at no cost and subtract it from letter `i+1`'s needed insertions.

**Algorithm:**
1. Compute `freq[26]`.
2. Try each target `k` from 0 to `max(freq)`.
3. For each `k`, simulate left-to-right with carry, accumulating costs.
4. Return the minimum over all `k`.

**Complexity:**

| | |
|---|---|
| Time | O(26 * max_freq) — 26 letters, max_freq up to n |
| Space | O(26) — frequency array |
