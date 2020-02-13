https://www.hackerrank.com/challenges/30-sorting/problem

## Day 20: Sorting

Objective
Today, we're discussing a simple sorting algorithm called Bubble Sort. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-sorting/topics) tab for learning materials and an instructional video!

Consider the following version of Bubble Sort:
```cpp
for (int i = 0; i < n; i++) {
    // Track number of elements swapped during a single array traversal
    int numberOfSwaps = 0;
    
    for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (a[j] > a[j + 1]) {
            swap(a[j], a[j + 1]);
            numberOfSwaps++;
        }
    }
    
    // If no elements were swapped during a traversal, array is sorted
    if (numberOfSwaps == 0) {
        break;
    }
}
```
#### Task
Given an array, <img src="https://latex.codecogs.com/svg.latex?\Large&space;a">, of size <img src="https://latex.codecogs.com/svg.latex?\Large&space;n"> distinct elements, sort the array in ascending order using the Bubble Sort algorithm above. Once sorted, print the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> lines:

1. *Array is sorted in numSwaps swaps*.<br>
where <img src="https://latex.codecogs.com/svg.latex?\Large&space;numSwaps"> is the number of swaps that took place.

2. *First Element: firstElement*<br>
where <img src="https://latex.codecogs.com/svg.latex?\Large&space;firstElement"> is the first element in the sorted array.

3. *Last Element: lastElement*<br>
where <img src="https://latex.codecogs.com/svg.latex?\Large&space;lastElement"> is the last element in the sorted array.

**Hint:** To complete this challenge, you will need to add a variable that keeps a running tally of all swaps that occur during execution.

#### Input Format

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;n">, denoting the number of elements in array <img src="https://latex.codecogs.com/svg.latex?\Large&space;a">. The second line contains space-separated integers describing the respective values of <img src="https://latex.codecogs.com/svg.latex?\Large&space;a_0,a_1,...,a_{n-1}">.

#### Constraints
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;2\le{n}\le{600}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{a_i}\le{2\times{10^6}}">, where <img src="https://latex.codecogs.com/svg.latex?\Large&space;0\le{u}<n">.

#### Output Format

Print the following three lines of output:

1. *Array is sorted in numSwaps swaps.*<br>
where <img src="https://latex.codecogs.com/svg.latex?\Large&space;numSwaps"> is the number of swaps that took place.
2. *First Element: firstElement*<br>
where <img src="https://latex.codecogs.com/svg.latex?\Large&space;firstElement"> is the first element in the sorted array.
3. *Last Element: lastElement*<br>
where <img src="https://latex.codecogs.com/svg.latex?\Large&space;lastElement"> is the last element in the sorted array.

#### Sample Input 0
```
3
1 2 3
```
#### Sample Output 0
```
Array is sorted in 0 swaps.
First Element: 1
Last Element: 3
```
#### Explanation 0

The array is already sorted, so <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> swaps take place and we print the necessary <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> lines of output shown above.

#### Sample Input 1
```
3
3 2 1
```
#### Sample Output 1
```
Array is sorted in 3 swaps.
First Element: 1
Last Element: 3
```
#### Explanation 1

The array <img src="https://latex.codecogs.com/svg.latex?\Large&space;a=[3,2,1]"> is not sorted, so we perform the following <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> swaps:

1. <img src="https://latex.codecogs.com/svg.latex?\Large&space;[3,2,1]\rightarrow[2,3,1]">

2. <img src="https://latex.codecogs.com/svg.latex?\Large&space;[2,3,1]\rightarrow[2,1,3]">

3. <img src="https://latex.codecogs.com/svg.latex?\Large&space;[2,1,3]\rightarrow[1,2,3]">

At this point the array is sorted and we print the necessary <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> lines of output shown above.
