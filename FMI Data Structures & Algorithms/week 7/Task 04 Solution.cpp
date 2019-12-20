#include <vector>
#include <unordered_map>
using namespace std;

int main()
{
    int N, i, r, c(0);
    scanf("%d", &N);

    vector<int> keys, doors;
    keys.reserve(N);
    doors.reserve(N);

    unordered_map<int, int> keyChain;

    for (i = 0;i < N - 1;++i) {
        scanf("%d", &r);
        keys.push_back(r);
    }

    for (i = 0;i < N - 1;++i) {
        scanf("%d", &r);
        doors.push_back(r);
    }

    for (i = 0; i < N - 1; ++i) {
        keyChain[keys[i]]++;
        if (keyChain.find(doors[i]) != keyChain.end())
        {
            if (keyChain[doors[i]] == 0)
            {
                c++;
            }
            else
            {
                keyChain[doors[i]]--;
            }
        }
        else
        {
            c++;
        }
    }

    printf("%d", c);

    return 0;
}
