# 3948. Lexicographically Maximum MEX Array

## Approach

Greedy: at each step, we want to maximize the first element of `result`, then the second, etc.

For the current prefix of `nums`, compute the MEX of prefixes of increasing length. We want the largest possible MEX, so try to extend the prefix as long as doing so gives a MEX >= any MEX we'd get with a shorter prefix.

Key insight: the MEX of a prefix can only increase or stay the same as the prefix grows (not necessarily monotone). We want to choose the cut point that gives the maximum MEX.

Actually MEX can go down when we add more elements (e.g., if 0 is missing from a short prefix, adding 0 makes MEX go from 0 to something higher). So we need to find for each possible cut, the MEX.

To maximize lexicographically: at each step, find the maximum MEX over all possible cut points `k` from 1 to remaining length. Take that MEX, remove those `k` elements, repeat.

For efficiency: maintain a frequency count and a pointer for current MEX. As we extend the prefix one element at a time, update MEX. At each position, record the MEX. The maximum MEX over all positions from 1 to len is taken greedily only if taking more elements doesn't reduce the MEX below that maximum.

Greedy: take the longest prefix that achieves the maximum possible MEX. This maximizes both the current value and doesn't waste elements that could be useful later.

## Complexity

- **Time:** O(n) amortized — MEX pointer only moves forward
- **Space:** O(n) — frequency array
