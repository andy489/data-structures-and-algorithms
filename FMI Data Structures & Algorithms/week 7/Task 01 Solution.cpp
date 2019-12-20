#include <set>
#include <iostream>
using namespace std;

int previousGuess[200002];
int a, k, m, n, guess[200000];

int getMaxShipsInInterval(int left, int right)
{
    return (right - left)/(a+1);
}

int main()
{
    cin>>n>>k>>a;
    cin>>m;
    set<int> intervalPoints;
    intervalPoints.insert(0);
    intervalPoints.insert(n+1);
    previousGuess[n+1] = 0;
    previousGuess[0] = 0;

    int maxPossibleWarships = (n+1)/(a+1);
    for(int i=0;i<m;++i)
    {
        cin>>guess[i];
        ///inserting the new guess
        intervalPoints.insert(guess[i]);

        ///finding the first guess to the left and the first to the right for the newly inserted guess
        int left = previousGuess[*intervalPoints.upper_bound(guess[i])];
        int right = *intervalPoints.upper_bound(guess[i]);

        ///calculating the maximum possible number of warships you can fit on the board after the last guess
        maxPossibleWarships = maxPossibleWarships - getMaxShipsInInterval(left, right)
            + getMaxShipsInInterval(left, guess[i]) + getMaxShipsInInterval(guess[i], right);

        ///updating previousGuesses
        previousGuess[guess[i]] = left;
        previousGuess[right] = guess[i];

        ///check if there is still a possibility that Alice is telling the truth(read the problem statement)
        if(maxPossibleWarships < k)
        {
            cout<<i+1<<endl;
            return 0;
        }
    }
    cout<<-1<<endl;
}
