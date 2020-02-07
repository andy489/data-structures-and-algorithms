#include <iostream>
#include <vector>
#include <stack>
using namespace std;

bool m[1000000] = { 0 };
int main() {
	int n, q;
	cin >> n >> q;
	int a, i, j;
	stack <int> v, v1;
	vector <int> p;
	for (i = 0; i < n; ++i) {
		cin >> a;
		v.push(a);
	}
	for (i = 2; i < 100000; ++i) {
		if (!m[i]) {
			for (j = 2; j * i < 1000000; ++j) {
				m[j * i] = 1;
			}
			p.push_back(i);
		}
	}
	for (i = 0; i < q; ++i) {
		v1 = v;
		stack <int> s;
		v = s;
		while (!v1.empty()) {
			if (v1.top() % p[i] == 0) {
				s.push(v1.top());
			}
			else {
				v.push(v1.top());
			}
			v1.pop();
		}
		while (!s.empty()) {
			cout << s.top() << '\n';
			s.pop();
		}
		if (v.size() == 0) break;
	}
	while (!v.empty()) {
		cout << v.top() << '\n';
		v.pop();
	}
	return 0;
}
