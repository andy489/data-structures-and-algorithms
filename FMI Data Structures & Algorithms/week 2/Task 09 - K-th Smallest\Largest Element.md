## Problem
Given an array and a number <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> where <img src="https://latex.codecogs.com/svg.latex?\Large&space;K"> is smaller than size of array, we need to find the <img src="https://latex.codecogs.com/svg.latex?\Large&space;K^{th}"> smallest element in the given array. It is given that ll array elements are distinct.

Примерен вход|Oчакван изход
-|-
6<br>7, 10, 4, 3, 20, 15<br>3|7
6<br>7, 10, 4, 3, 20, 15<br>4|10

*Първо подаваме броя на несортираните елементи, след което ги въвеждаме от конзолата. Накрая подаваме К-тото най-малко търсено чисо. Изхода е търсеното такова число.*  

## Quick Select

*In **QuickSort**, we pick a pivot element, then move the pivot element to its correct position and partition the array around it. The idea is, not to do complete quicksort, but stop at the point where pivot itself is k’th smallest element. Also, not to recur for both left and right sides of pivot, but recur for one of them according to the position of pivot. The worst case time complexity of this method is <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n^2)">, but it works in <img src="https://latex.codecogs.com/svg.latex?\Large&space;O(n)"> on average.*
