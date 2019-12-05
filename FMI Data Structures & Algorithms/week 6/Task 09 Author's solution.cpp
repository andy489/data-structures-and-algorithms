#include <iostream>
#include <utility>
#include <algorithm>
#include <queue>
using namespace std;
typedef pair<int, int> pii;
const int MAXN = 2000005;

int n, m, j, ans, A[MAXN];
pii B[MAXN], C[MAXN];

priority_queue<int, vector<int>, greater<int>> Q;

int main()
{
	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		cin >> A[i];
	}

	for (int i = 0; i < n; i++) {
		cin >> B[i].first >> B[i].second;
		C[i] = { B[i].first - B[i].second, B[i].first + B[i].second };
	}

	sort(A, A + n);
	sort(C, C + m);

	for (int i = 0; i < n; i++)
	{
		while (j < m && A[i] >= C[j].first) {
			Q.push(C[j].second);
			j++;
		}

		while (!Q.empty() && Q.top() < A[i]) {
			Q.pop();
		}

		if (!Q.empty()) {
			Q.pop();
			ans++;
		}
	}

	cout << ans << '\n';

	return 0;
}
