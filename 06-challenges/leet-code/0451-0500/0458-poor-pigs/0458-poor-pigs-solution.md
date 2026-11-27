# 458. Poor Pigs — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/poor-pigs/

---

## Intuition

Forget the pigs for a moment. The real question is: **how much information can we extract?**

You have a fixed time budget — `minutesToTest` minutes — and each test takes `minutesToDie` minutes to produce a result. So you can run at most:

```
rounds = minutesToTest / minutesToDie
```

test rounds total.

---

## What can one pig tell you?

A pig drinks some buckets in round 1, some in round 2, ..., some in round `rounds`. After all rounds you observe **exactly one of these outcomes**:

| Outcome | Meaning |
|---------|---------|
| Died in round 1 | The poisoned bucket was one it drank in round 1 |
| Died in round 2 | The poisoned bucket was one it drank in round 2 (but not round 1) |
| ... | ... |
| Died in round `rounds` | Drank from the poisoned bucket only in the last round |
| **Never died** | The poisoned bucket was never given to this pig |

So **one pig encodes `rounds + 1` distinct outcomes** — not just 2 (alive/dead), but `rounds + 1`.

---

## How many pigs for `buckets` buckets?

With `p` pigs, each independently producing `rounds + 1` outcomes, the total number of distinguishable situations is:

```
(rounds + 1)^p
```

We need this to cover all `buckets`:

```
(rounds + 1)^p >= buckets
```

Solving for `p` (change-of-base formula, any log base works since it cancels):

```
p >= log(buckets) / log(rounds + 1)
p = ceil(log(buckets) / log(rounds + 1))
```

---

## Concrete example

`buckets = 25`, `minutesToDie = 15`, `minutesToTest = 60`  
→ `rounds = 4`, base = `rounds + 1 = 5`

Each pig has 5 outcomes (died round 1/2/3/4, or survived). With 2 pigs: `5² = 25` states — exactly enough for 25 buckets.

**How to assign buckets?** Label each bucket 0–24 as a 2-digit base-5 number:

```
Bucket  0 → (fives=0, units=0)
Bucket  1 → (fives=0, units=1)
...
Bucket  5 → (fives=1, units=0)
Bucket  6 → (fives=1, units=1)
...
Bucket 24 → (fives=4, units=4)
```

- **Pig 0** (fives digit): in round `r`, drinks all buckets whose fives digit is `r`.
- **Pig 1** (units digit): in round `r`, drinks all buckets whose units digit is `r`.

After all rounds, Pig 0 dying in round 3 means fives digit = 3; Pig 1 surviving means units digit = 0. Together they point to exactly **one** bucket.

---

## Why increment pigs in a loop (not use the formula directly)?

The formula involves `ceil` and floating-point `log`, which can have precision issues. Incrementing `pigs` until `(rounds+1)^pigs >= buckets` is simple, exact, and terminates in at most ~10 iterations for any realistic input.

---

## Complexity

| | |
|---|---|
| Time | O(log(buckets) / log(rounds+1)) ≈ O(1) for practical inputs |
| Space | O(1) |
