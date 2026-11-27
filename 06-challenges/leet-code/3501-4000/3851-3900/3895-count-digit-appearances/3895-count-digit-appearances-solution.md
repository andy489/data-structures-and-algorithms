# Solution: 3895. Count Digit Appearances

## Approach: String Conversion

Convert each number to its string representation and count occurrences of the target digit character.

### Algorithm

1. Convert `digit` to its character representation.
2. For each number in `nums`, convert it to a string and count how many times the digit character appears.
3. Sum up all counts.

## Complexity

- **Time:** O(N * D) where D is the number of digits in each number (at most 7 for 10^6)
- **Space:** O(D) for string conversion
