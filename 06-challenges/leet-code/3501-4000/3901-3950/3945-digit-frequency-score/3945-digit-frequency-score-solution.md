# 3945. Digit Frequency Score

## Approach

Convert the integer `n` to its string representation and iterate over each character (digit). Count the frequency of each distinct digit using a HashMap or array of size 10. Then compute the sum of `d * freq(d)` for each distinct digit `d`.

## Complexity

- **Time:** O(log n) — number of digits in n
- **Space:** O(1) — array of size 10 for digit counts
