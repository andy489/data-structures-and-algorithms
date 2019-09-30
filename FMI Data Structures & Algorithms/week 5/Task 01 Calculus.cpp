#include <iostream>
#include <cmath>
int main()
{
	size_t n; std::cin >> n;
	std::cout << 1 + 2 * (n - pow(2, (int)log2(n)));
	return 0;
}
