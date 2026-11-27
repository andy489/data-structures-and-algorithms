# 3387. Maximize Amount After Two Days of Conversions

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximize-amount-after-two-days-of-conversions/

---

## Problem Statement

You are given a string `initialCurrency`, and you start with `1.0` of `initialCurrency`.

You are also given four arrays with currency pairs (strings) and rates (real numbers):

- `pairs1[i] = [startCurrencyi, targetCurrencyi]` denotes that you can convert from `startCurrencyi` to `targetCurrencyi` at a rate of `rates1[i]` on **day 1**.
- `pairs2[i] = [startCurrencyi, targetCurrencyi]` denotes that you can convert from `startCurrencyi` to `targetCurrencyi` at a rate of `rates2[i]` on **day 2**.
- Also, each `targetCurrency` can be converted back to its `startCurrency` at a rate of `1 / rate`.

You can perform **any** number of conversions, including zero, using `rates1` on day 1, **followed** by any number of conversions using `rates2` on day 2.

Return the **maximum** amount of `initialCurrency` you can have after performing any number of conversions on both days in order.

**Note:** Conversion rates are valid with no contradictions. The rates for the days are independent of each other.

---

## Examples

**Example 1:**
```
Input:  initialCurrency = "EUR",
        pairs1 = [["EUR","USD"],["USD","JPY"]], rates1 = [2.0,3.0],
        pairs2 = [["JPY","USD"],["USD","CHF"],["CHF","EUR"]], rates2 = [4.0,5.0,6.0]
Output: 720.00000
```
Explanation: EUR→USD(×2)→JPY(×3) on day1, then JPY→USD(×4)→CHF(×5)→EUR(×6) on day2 = 1×2×3×4×5×6 = 720.

**Example 2:**
```
Input:  initialCurrency = "NGN", pairs1 = [["NGN","EUR"]], rates1 = [9.0],
        pairs2 = [["NGN","EUR"]], rates2 = [6.0]
Output: 1.50000
```
Explanation: NGN→EUR(×9) on day1, EUR→NGN(×1/6) on day2 → 9/6 = 1.5.

**Example 3:**
```
Input:  initialCurrency = "USD", pairs1 = [["USD","EUR"]], rates1 = [1.0],
        pairs2 = [["EUR","JPY"]], rates2 = [10.0]
Output: 1.00000
```
Explanation: No conversions needed; best is to hold USD.

---

## Constraints

- `1 <= initialCurrency.length <= 3`
- `1 <= n == pairs1.length <= 10`
- `1 <= m == pairs2.length <= 10`
- `1.0 <= rates1[i], rates2[i] <= 10.0`
- No contradictions or cycles in either conversion graph.
