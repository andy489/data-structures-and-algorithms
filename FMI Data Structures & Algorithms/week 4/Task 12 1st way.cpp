#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct Tree
{
    int h, pos;
    Tree(int h = 0, int pos = 0) :h(h), pos(pos) {};
    bool operator <= (const Tree& other) const
    {
        return this->h <= other.h;
    }
    bool operator > (const Tree& other) const
    {
        return this->h > other.h;
    }
    bool operator < (const Tree& other) const
    {
        return this->h < other.h;
    }
};


int main()
{
    int N, h; // h = hight of tree
    cin >> N;

    if (N == 0 || N == 1)
    {
        cout << 0;
        return 0;
    }

    vector<Tree> forest;
    forest.reserve(N);

    for (int i = 0;i < N;i++)
    {
        cin >> h;
        forest.emplace_back(h, i);
    }

    //for (const auto& t : forest) cout << t.h << ' ' << t.pos << '\n';

    stack<Tree> S;

    int fullestStack = 1;
    int bestView = forest[N-1].pos-1;

    for (int i = N - 1;i >= 0;i--)
    {
        if (S.empty() || forest[i] < S.top())
        {
            S.push(forest[i]);
            if (S.size() >= fullestStack)
            {
                fullestStack = S.size();
                bestView = S.top().pos;
            }
        }
        else
        {
            
            while (!S.empty() && S.top() <= forest[i])
            {
                S.pop();
            }
            S.push(forest[i]);
            if (S.size() >= fullestStack)
            {
                fullestStack = S.size();
                bestView = S.top().pos;
            }
        }
    }

    cout << bestView;

    return 0;
}
