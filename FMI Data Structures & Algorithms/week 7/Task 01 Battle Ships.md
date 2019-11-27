## Battle Ships
[Battle Ships Judge System](http://codeforces.com/problemset/problem/567/D)
```
                               D. One-Dimensional Battle Ships
                                time limit per test: 1 second
                             memory limit per test: 256 megabytes
                                    input: standard input
                                   output: standard output
```

Alice and Bob love playing one-dimensional battle ships. They play on the field in the form of a line consisting of <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> square cells (that is, on a <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\times{n}"> table).

At the beginning of the game Alice puts <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> ships on the field without telling their positions to Bob. Each ship looks as a <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\times{a}"> rectangle (that is, it occupies a sequence of <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> consecutive squares of the field). The ships cannot intersect and even touch each other.

After that Bob makes a sequence of "shots". He names cells of the field and Alice either says that the cell is empty ("miss"), or that the cell belongs to some ship ("hit").

But here's the problem! Alice like to cheat. May be that is why she responds to each Bob's move with a "miss".

Help Bob catch Alice cheating — find Bob's first move, such that after it you can be sure that Alice cheated.

#### Input

The first line of the input contains three integers: <img src="https://latex.codecogs.com/svg.latex?\Large&space;n,k"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;a(1\le{n},k,a\le{2.10^5})"> — the size of the field, the number of the ships and the size of each ship. It is guaranteed that the <img src="https://latex.codecogs.com/svg.latex?\Large&space;n,k"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> are such that you can put <img src="https://latex.codecogs.com/svg.latex?\Large&space;k"> ships of size <img src="https://latex.codecogs.com/svg.latex?\Large&space;a"> on the field, so that no two ships intersect or touch each other.

The second line contains integer <img src="https://latex.codecogs.com/svg.latex?\Large&space;m(1\le{m}\le{n})"> — the number of Bob's moves.

The third line contains <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> distinct integers <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_1,x_2,...,x_m">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;x_i"> is the number of the cell where Bob made the <img src="https://latex.codecogs.com/svg.latex?\Large&space;i">-th shot. The cells are numbered from left to right from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">.

#### Output

Print a single integer — the number of such Bob's first move, after which you can be sure that Alice lied. Bob's moves are numbered from <img src="https://latex.codecogs.com/svg.latex?\Large&space;1"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;m"> in the order the were made. If the sought move doesn't exist, then print "-1".

#### Examples
Input|Output
-|-
11 3 3<br>5<br>4 8 6 1 11|3
5 1 3<br>2<br>1 5|-1
5 1 3<br>1<br>3|1
