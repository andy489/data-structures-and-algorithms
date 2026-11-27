# Solution: Minimum Cost to Convert String I

## Approach: Floyd-Warshall on 26 Characters

Since there are only 26 lowercase English characters, run Floyd-Warshall to compute the minimum cost to transform any character into any other character. Then for each position in source and target, add the minimum transformation cost. If any position is unreachable, return -1.

## Complexity

| | Time | Space |
|---|---|---|
| **Floyd-Warshall + Linear Scan** | **O(26³ + n)** | **O(26²)** |

## Key Insight

The 26-character alphabet makes Floyd-Warshall trivially fast (17,576 iterations). Initialize dist[i][i] = 0 and dist[i][j] = min of all direct conversion costs, then run Floyd-Warshall for shortest paths.
