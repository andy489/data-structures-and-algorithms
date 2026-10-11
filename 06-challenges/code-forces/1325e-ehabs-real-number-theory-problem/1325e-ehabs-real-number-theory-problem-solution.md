# 1325E. Ehab's REAL Number Theory Problem — Solution

---

## Key Insight

A product of numbers is a **perfect square** iff every prime appears an **even** number of times in the product's factorization. This is a **linear algebra over GF(2)** problem: represent each number as a vector of parities of prime exponents, and find the shortest subset summing to the zero vector (mod 2).

The constraint "at most 7 divisors" means each *aᵢ* has a highly restricted factorization: it is of the form `p⁶`, `p⁵`, `p⁴`, `p³q`, `p²q²`, `p²q`, `pq`, `p²`, `p`, or `1` for primes *p, q*. Crucially, **each number involves at most 2 distinct primes**.

---

## Graph Reduction

Model the problem as a **shortest cycle** in a graph:

1. Reduce each *aᵢ* by removing squared factors (replace *aᵢ* with its **square-free part** — only primes with odd exponents matter).
2. After reduction, each number is either `1`, a prime `p`, or a product `p·q` of two primes.
3. Build a graph where:
   - Nodes = primes (up to ~1000 primes ≤ 10⁶ that appear) + a special node for `1`.
   - Edge for each number:
     - `1` → self-loop on the `1` node (but handled separately: if any *aᵢ* = 1 after reduction, answer is 1).
     - `p` → edge between the `1`-node and the `p`-node.
     - `p·q` → edge between the `p`-node and `q`-node.
4. The shortest subsequence with perfect square product = **shortest cycle** in this graph.

**Why cycles?** A cycle in the graph corresponds to a set of edges (numbers) where each node (prime) has even degree — exactly the condition for a perfect square product.

**Finding shortest cycle:** BFS from each node to find the shortest cycle through that node. Since primes ≤ 10⁶ can be large but the actual graph has at most ~10⁵ nodes, use BFS efficiently. The special structure (primes ≤ 1000 appear frequently; primes > 1000 appear at most once as a factor of at most one edge) allows optimization.

---

## Algorithm

1. Factor each *aᵢ*, compute square-free part.
2. If any square-free part is 1: output 1.
3. If any two identical square-free parts: output 2 (their product is a square).
4. Build graph as described.
5. Run BFS from each node to find shortest cycle: answer = minimum cycle length found, or -1.

---

## Complexity

| | |
|---|---|
| Time | O(n√max_a + V·E) — factorization + BFS per node |
| Space | O(V + E) |

*V* ≈ number of distinct primes, *E* ≈ *n*. The "at most 7 divisors" constraint bounds *E* per node.
