#include <iostream>
#include <vector>
using namespace std;
typedef vector<int> vi;
#define F(i,k,n) for(int i = k; i<n; ++i)

void m(vi& col, vi& L, vi& R)
{
	size_t lC(L.size()), rC(R.size()), i(0), j(0), k(0);
	while (i < lC && j < rC)
	{
		if (L[i] < R[j]) col[k++] = L[i++];
		else col[k++] = R[j++];
	}
	while (i < lC)col[k++] = L[i++];
	while (j < rC)col[k++] = R[j++];
}

void mS(vi& col)
{
	size_t N(col.size()), mid;
	if (N < 2) return;
	mid = (N + 1) / 2; //mid = N/2;
	vi L(mid), R(N - mid);
	F(i, 0, mid) L[i] = col[i];
	F(j, mid, N)R[j - mid] = col[j];
	mS(L);mS(R);m(col, L, R);
}

int main()
{
	size_t N;cin >> N;
	vi col(N);
	F(i, 0, N) cin >> col[i];
	mS(col);
	for (const auto& el : col) cout << el << ' ';
	return 0;
}
