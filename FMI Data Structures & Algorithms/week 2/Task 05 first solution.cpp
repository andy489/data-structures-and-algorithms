#include <iostream>
#include <string>
#include <vector>
#define ASCII_SYMBOLS 256

std::vector<int> histo(const std::string& word)
{
    std::vector<int>vec(ASCII_SYMBOLS,0);
    size_t SIZE = word.size();
    for (size_t i = 0; i < SIZE; i++)
    {
        vec[word[i]]++;
    }
    return vec;
}

bool checkPermText(const std::string & word1,const std::string & word2)
{    
    std::vector<int> histogram1 = histo(word1);
    std::vector<int> histogram2 = histo(word2);
        
    for (size_t i = 0; i < ASCII_SYMBOLS; i++)
    {
        if (histogram1[i] != histogram2[i])
        {
            return false;
        }
    }
    return true;
}

int main()
{
    std::ios::sync_with_stdio(false);
    std::cin.tie(nullptr);

    int n; std::cin >> n; // why?!
    std::string word1, word2;    std::cin >> word1 >> word2;

    checkPermText(word1, word2) ? std::cout << "yes" : std::cout << "no";

    return 0;
}
    
