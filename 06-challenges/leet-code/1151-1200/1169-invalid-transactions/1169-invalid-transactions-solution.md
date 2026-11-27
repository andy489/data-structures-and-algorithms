# 1169. Invalid Transactions — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/invalid-transactions/

---

## Solution: HashMap by Name + Pairwise Check — O(n²) time, O(n) space

**Idea:** Parse all transactions and group them by name. For each transaction, mark it invalid if its amount > 1000 or if any other transaction with the same name has `|time1 - time2| <= 60` and a different city.

**Algorithm:**
1. Parse each transaction string into `(name, time, amount, city)` tuples.
2. Build a map from name to list of `(time, amount, city, originalString)`.
3. For each transaction, check the two invalidity conditions against all transactions in its name group.
4. Collect and return all marked invalid transactions.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — worst case all same name, pairwise comparison |
| Space | O(n) — storing parsed transactions |
