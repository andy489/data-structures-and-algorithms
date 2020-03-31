// github.com/andy489

#include <iostream>
#include <algorithm>
#include <string>
#include <unordered_map>
using namespace std;

int main() {
  int t;
  scanf("%d\n", &t);
  while (t--) {
    unordered_map<string, int> um;
    string s;
    getline(cin, s);
    int n = s.size(), len, j;
    for (len = 1; len < n; ++len) {
      for (j = 0; j <= n - len; ++j) {
        string sub = s.substr(j, len);
        sort(sub.begin(), sub.end());
        ++um[sub];
      }
    }
    int ans(0);
    for (const auto& kvp : um) {
      ans += kvp.second * (kvp.second - 1) / 2;
    }
    printf("%d\n", ans);
  }
  return 0;
}
