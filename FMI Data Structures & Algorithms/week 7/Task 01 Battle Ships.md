## Battle Ships
[Battle Ships Judge System](http://codeforces.com/problemset/problem/567/D)
```
D. One-Dimensional Battle Ships
time limit per test
1 second
memory limit per test
256 megabytes
input
standard input
output
standard output
```

Alice and Bob love playing one-dimensional battle ships. They play on the field in the form of a line consisting of n square cells (that is, on a 1 × n table).

At the beginning of the game Alice puts k ships on the field without telling their positions to Bob. Each ship looks as a 1 × a rectangle (that is, it occupies a sequence of a consecutive squares of the field). The ships cannot intersect and even touch each other.

After that Bob makes a sequence of "shots". He names cells of the field and Alice either says that the cell is empty ("miss"), or that the cell belongs to some ship ("hit").

But here's the problem! Alice like to cheat. May be that is why she responds to each Bob's move with a "miss".

Help Bob catch Alice cheating — find Bob's first move, such that after it you can be sure that Alice cheated.
Input

The first line of the input contains three integers: n, k and a (1 ≤ n, k, a ≤ 2·105) — the size of the field, the number of the ships and the size of each ship. It is guaranteed that the n, k and a are such that you can put k ships of size a on the field, so that no two ships intersect or touch each other.

The second line contains integer m (1 ≤ m ≤ n) — the number of Bob's moves.

The third line contains m distinct integers x1, x2, ..., xm, where xi is the number of the cell where Bob made the i-th shot. The cells are numbered from left to right from 1 to n.
Output

Print a single integer — the number of such Bob's first move, after which you can be sure that Alice lied. Bob's moves are numbered from 1 to m in the order the were made. If the sought move doesn't exist, then print "-1".
Examples
Input
Copy

11 3 3
5
4 8 6 1 11

Output
Copy

3

Input
Copy

5 1 3
2
1 5

Output
Copy

-1

Input
Copy

5 1 3
1
3

Output
Copy

1
