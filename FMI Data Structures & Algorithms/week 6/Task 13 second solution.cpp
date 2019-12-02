#include <iostream>
#include <set>
using namespace std;

int main() {
	multiset<string> ms;

	ios::sync_with_stdio(false);
	cin.tie(nullptr);

	string input;

	while (cin >> input)
		ms.insert(input);

	auto it = ms.begin();
	while (it != ms.end()) {
		int count = ms.count(*it);
		if (count == 1)
			cout << *it << endl;
			it++;
	}

	return 0;
}
