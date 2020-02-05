#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
	int n, i, pos(1);
	cin >> n;

	vector<int>h(n + 2), s(n + 2);

	for (i = 1; i < n; ++i) {
		cin >> h[i];
	}

	int maxArea(0);

	for (i = 0; i < n + 2; ++i) {		
		while (h[i] < h[s[pos - 1]]) {
			int y = h[s[pos - 1]];
			pos--;
			maxArea = max(maxArea, (i - s[pos - 1] - 1) * y);
		}
		s[pos++] = i;
	}
	cout << maxArea;
}
