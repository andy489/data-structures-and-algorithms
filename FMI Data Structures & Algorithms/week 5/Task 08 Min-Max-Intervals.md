## Min-Max-Intervals

[Min-Max-Intervals Judge](https://www.hackerrank.com/contests/practice-5-sda/challenges/min-max-intervals)

Даден ви е масив с N цели положителни числа: A[0], A[1], ..., A[N - 1] и цялото число K. Min-Max интервал ще наричаме последователност от елементи на масива, такава че разликата между минималния и максималния измежду тях е най-много K. По-формално казано:

Min-Max-Intervals = { s = A[i], A[i + 1], ..., A[j] | 0 <= i <= j < N & max(s) - min(s) <= K }

Намерете броят на Min-Max интервалите в масива А (броя на елементите на множеството Min-Max-Intervals).

Input Format

На първият ред се въвеждат числата N и К.

Следват N числа - елементите на масива A[0], A[1], ..., A[N - 1];

Constraints

0 ≤ N ≤ 2 000 000

0 ≤ K ≤ 2 000 000

0 ≤ A[i] ≤ 2 000 000

Output Format

Изведете едно число - броя на Min-Max интервалите в масива А.

Sample Input 0

10 5
8 4 9 5 7 1 2 10 6 3 

Sample Output 0

23

Sample Input 1

8 4
4 1 8 7 2 6 5 3 

Sample Output 1

16

