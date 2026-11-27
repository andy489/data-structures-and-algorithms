# Solution: Find Mirror Score of a String

## Approach

For each character c (a-z), its mirror is chr(ord('z') - ord(c) + ord('a')).

Maintain a stack for each of the 26 characters. For each index i:
- Find the mirror character m of s[i].
- If the stack for m is non-empty, pop the top index j, add i-j to score (both j and i are now marked).
- Otherwise, push i onto the stack for s[i] (it's available for future matching).

We never explicitly "mark" — popping from the stack serves as marking.

## Complexity

| | Complexity |
|---|---|
| Time | O(n) |
| Space | O(n) |
