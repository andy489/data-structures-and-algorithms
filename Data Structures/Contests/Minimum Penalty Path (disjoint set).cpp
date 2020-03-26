// github.com/andy489

#include<iostream>
#include<vector>
using namespace std;
const int MAX = 1024;

vector<pair<int, int>> w[MAX];
int o[MAX];

int find(int a) {
	if (a == o[a]) return a;
	return o[a] = find(o[a]);
}
void uni(int a, int b) {
	o[find(a)] = find(b);
}

int main() {
	int n, m;
	cin >> n >> m;
	while (m--) {
		int a, b, c;
		cin >> a >> b >> c;
		w[c].emplace_back(a, b);
	}
	int x, y;
	cin >> x >> y;
	for (int c = 1;c <= MAX;++c) {
		for (int i = 1;i <= n;++i) {
			o[i] = i;
		}
		for (int c2 = 1;c2 <= c;++c2) {
			if ((c2 | c) == c) {
				for (const auto& edge : w[c2]) {
					uni(edge.first, edge.second);
				}
			}
		}
		if (find(x) == find(y)) {
			cout << c;
			return 0;
		}
	}
	cout << "-1";
	return 0;
}
