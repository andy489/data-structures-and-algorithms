#include <iostream>
#include <list>
#include <iterator>
using namespace std;

auto inp(int n)
{
    list<int> l;
    while(n--)
    {
        int t;
        cin >> t;
        l.push_back(t);
    }
    return l;
}

template<class RevIt>
int removeSmallerAfter(list<int>& trees, RevIt it)
{
    list<int>::iterator pos = it.base();
    int currentHeight = *prev(pos, 1), removed = 0;
    while(pos != trees.end())
    {
        if(currentHeight < *pos) break;
        pos = trees.erase(pos);
        removed++;
    }
    return removed;
}

int solve(list<int>& trees)
{
    int bestPos, currentPos = trees.size(), maxVisibleTrees = 0, visibleTrees = 0;
    for(auto it=trees.rbegin(); it!=trees.rend();)
    {
        currentPos--;
        visibleTrees++;
        visibleTrees -= removeSmallerAfter(trees, it++);
        if(visibleTrees >= maxVisibleTrees)
        {
            maxVisibleTrees = visibleTrees;
            bestPos = currentPos;
        }
    }
    return bestPos;
}

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n;
    cin >> n;
    auto trees = inp(n);
    cout << solve(trees) << endl;
}

