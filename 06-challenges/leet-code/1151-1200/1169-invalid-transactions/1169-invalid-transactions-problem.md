# 1169. Invalid Transactions

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/invalid-transactions/

---

## Problem Statement

A transaction is **possibly invalid** if:
- The amount exceeds `$1000`, **or**
- If it occurs within (and including) `60` minutes of another transaction with the **same name** in a **different city**.

You are given an array of strings `transactions` where each transaction is a string in the form `"{name},{time},{amount},{city}"`.

Return a list of transactions that are **possibly invalid**. You may return the answer in any order.

---

## Examples

**Example 1:**
```
Input:  transactions = ["alice,20,800,mtv","alice,50,100,beijing"]
Output: ["alice,20,800,mtv","alice,50,100,beijing"]
Explanation: Both transactions are within 60 minutes of each other in different cities.
```

**Example 2:**
```
Input:  transactions = ["alice,20,800,mtv","alice,50,1200,mtv"]
Output: ["alice,50,1200,mtv"]
Explanation: The second transaction exceeds $1000.
```

**Example 3:**
```
Input:  transactions = ["alice,20,800,mtv","bob,50,1200,mtv"]
Output: ["bob,50,1200,mtv"]
Explanation: Bob's transaction exceeds $1000; Alice's is valid.
```

---

## Constraints

- `transactions.length <= 1000`
- Each `transactions[i]` takes the form `"{name},{time},{amount},{city}"`
- Each `name` and `city` consist of lowercase English letters, length 1–10
- `0 <= time <= 1000`
- `0 <= amount <= 2000`
