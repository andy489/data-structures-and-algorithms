// github.com/andy489

// First Solution (binary search)
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;

int main() {
	int q, i;
	cin >> q;
	while (q--) {
		string word;
		cin >> word;

		int length = (int)word.length(),
			indx(-1);

		char curr = word[length - 1];

		for (i = length - 1;i > 0;i--)
		{
			if (word[i] > word[i - 1])
			{
				indx = i - 1;
				curr = word[indx];
				break;
			}
		}

		if (indx == -1) cout << "no answer\n";
		else { // binary search to find the best swap
			int l(indx + 1),
				r(length - 1),
				mid,ans;
			while (l <= r) {
				mid = l + (r - l) / 2;
				if (word[mid] > curr) {
					ans = mid;
					l = mid + 1;
				}
				else {
					r = mid - 1;
				}
			}
			swap(word[indx], word[ans]);
			reverse(word.begin() + indx + 1, word.end());
			cout << word << '\n';
		}
	}	
}

// Second Solution (built-in function)
#include <iostream>
#include <string>
#include <algorithm>
using namespace std;
int main() {
    int t;
    cin>>t;
    string w;
    while(t--) {
        cin >> w;
        if (next_permutation(w.begin(), w.end()))
            cout << w << '\n';
        else
            cout << "no answer\n";
    }
}
