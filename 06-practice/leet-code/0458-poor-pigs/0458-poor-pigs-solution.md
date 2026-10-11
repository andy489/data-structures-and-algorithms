# 458. Poor Pigs — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/poor-pigs/

---

## Solution (Information-Theoretic / Base Encoding)

### Key Insight

The core idea is to think in terms of **information capacity**.

**How many test rounds do we have?**

```
rounds = minutesToTest / minutesToDie
```

**What outcomes can a single pig encode?**

Each pig participates in up to `rounds` tests. After all tests complete, a pig's **death round** tells us information:
- It died in round 1
- It died in round 2
- ...
- It died in round `rounds`
- It never died (survived all rounds)

So one pig can encode **`rounds + 1` distinct outcomes**.

**How many pigs do we need?**

With `p` pigs, each able to encode `(rounds + 1)` outcomes independently, we can distinguish:

```
(rounds + 1)^p  total states
```

We need this to be at least `buckets`. Therefore:

```
(rounds + 1)^p >= buckets
p >= log(buckets) / log(rounds + 1)
p = ceil(log(buckets) / log(rounds + 1))
```

### Encoding Strategy (how to actually assign buckets to pigs)

Think of each bucket as a number in base `(rounds + 1)`. Assign each pig to a positional digit:

- **Pig 0** handles the least significant digit.
- **Pig 1** handles the next digit.
- ...and so on.

In round `r` (1-indexed), each pig `i` drinks from all buckets whose base-`(rounds+1)` representation has digit value `r` at position `i`.

After all rounds, the pattern of which pigs died and in which round uniquely encodes the poisoned bucket's index.

### Example Walkthrough

`buckets = 4`, `minutesToDie = 15`, `minutesToTest = 30` → `rounds = 2`, base = 3

Label buckets 0..3 in base 3:
```
Bucket 0 → (0, 0)
Bucket 1 → (1, 0)
Bucket 2 → (2, 0)
Bucket 3 → (0, 1)
```

- Pig 0 (units digit): drinks bucket 1 in round 1, bucket 2 in round 2.
- Pig 1 (next digit): drinks bucket 3 in round 1.

Observation outcomes map 1-to-1 to bucket indices.

### Complexity

| | |
|---|---|
| Time | O(1) — single formula |
| Space | O(1) |

### Code

```cpp
int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int rounds = minutesToTest / minutesToDie;
    int pigs = 0;
    while (pow(rounds + 1, pigs) < buckets)
        ++pigs;
    return pigs;
}
```

```java
public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    int rounds = minutesToTest / minutesToDie;
    int pigs = 0;
    while (Math.pow(rounds + 1, pigs) < buckets)
        ++pigs;
    return pigs;
}
```
