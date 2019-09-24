/* We will generate all N*(N-1)/2 possible pairs of socks and collect them in a vector<PairSocks>. After that we will sort 
the vector by key - diff (the difference between first and second sock in the pair). Finally we will display the k-th pair. */

#include <iostream>
#include <vector>
#include <algorithm>

class PairSocks
{
	size_t a, b, diff;
public:
	const size_t getA() const;
	const size_t getB() const;
	const size_t getDiff() const;
	PairSocks(size_t p, size_t q);
	friend std::ostream& operator<<(std::ostream& os, const PairSocks& v);
};

struct byDiff
{
	bool operator()(PairSocks const &a, PairSocks const &b) const
	{
		return a.getDiff() < b.getDiff();
	}
};

int main()
{
	size_t n, k;
	std::cin >> n >> k;

	std::vector<int> socks(n);
	for (size_t i = 0; i < n; i++) std::cin >> socks[i];

	std::vector<PairSocks> pairs; //vector with all {n choose 2} pairs
	for (size_t i = 0; i < n; i++)
	{
		for (size_t j = i + 1; j < n; j++)
		{
			pairs.push_back(PairSocks(socks[i], socks[j]));
		}
	}
	// Sorting all pairs by key
	sort(pairs.begin(), pairs.end(), byDiff()); //using operator ()
	std::cout << pairs[k - 1]; //using operator <<
	return 0;
}

const size_t PairSocks::getA() const
{
	return this->a;
}

const size_t PairSocks::getB() const
{
	return this->b;
}

const size_t PairSocks::getDiff() const
{
	return this->diff;
}

PairSocks::PairSocks(size_t p, size_t q)
{
	if (p < q) { a = p;	b = q; }
	else { a = q; b = p; }
	diff = b - a;
}

std::ostream & operator<<(std::ostream & os, const PairSocks &pair)
{
	os << pair.a << ' ' << pair.b << '\n';
	return os;
};
