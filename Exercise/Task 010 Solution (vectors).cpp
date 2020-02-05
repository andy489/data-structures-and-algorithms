#include <iostream>
#include <vector>
using namespace std;

int main() {
	int g;
	cin >> g;
	while (g--) {
		int n, m, x,i;
		cin >> n >> m >> x;

		vector<int> a(n),b(m);

		for (i = 0; i < n; ++i) {
			cin >> a[i];
		}

		for (i = 0; i < m; ++i) {
			cin >> b[i];
		}

		int sum(0), score(0), j(0); i = 0;

		while (i < n && sum + a[i] <= x) {
			//considering only first stack and calculating count
			sum += a[i];
			++i;
		}
		score = i;

		while (j < m) {          
			/*now adding one element of second stack at a time 
			and subtracting the top element of first stack and calculating the count*/  
			sum += b[j];
			j++;
			while (sum > x&& i > 0) {
				--i;
				sum -= a[i];
			}
			if (sum <= x && i + j > score)
				score = i + j;
		}
		cout << score << '\n';
	}
	return 0;
}
/*
1
9 10 67
19 9 8 13 1 7 18 0 19 
11 17 1 18 14 12 9 18 14 3  
*/
