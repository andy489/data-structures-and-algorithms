# 458. Poor Pigs

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/poor-pigs/

---

## Problem Statement

There are `buckets` buckets of liquid, where **exactly one** of them is poisonous. To figure out which one is poisonous, you may feed some number of (possibly the same) pigs the liquid to see whether they will die or not. Unfortunately, you only have `minutesToTest` minutes to determine which bucket is poisonous.

You can feed the pigs according to these steps:

1. Choose some live pigs to feed.
2. For each pig, choose which buckets to feed it. The pig will consume all the chosen buckets simultaneously and will die or survive accordingly.
3. Wait for `minutesToDie` minutes. You may **not** feed any other pigs during this time.
4. After `minutesToDie` minutes have passed, any pigs that have been fed the poisonous bucket will die, and all others will survive.
5. Repeat this process until you run out of time.

Given `buckets`, `minutesToDie`, and `minutesToTest`, return the **minimum** number of pigs needed to figure out which bucket is poisonous within the allotted time.

---

## Examples

**Example 1:**
```
Input:  buckets = 4, minutesToDie = 15, minutesToTest = 15
Output: 2
```

**Example 2:**
```
Input:  buckets = 4, minutesToDie = 15, minutesToTest = 30
Output: 2
```

---

## Constraints

- `1 <= buckets <= 1000`
- `1 <= minutesToDie <= minutesToTest <= 100`
