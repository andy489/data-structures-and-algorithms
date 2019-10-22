#include <iostream>

int myAbs(int a)
{
    return a > 0 ? a : -a;
}

int main()
{
    int T, cpy, norm;std::cin >> T;

    for (size_t i = 0; i < T; i++)
    {
        std::cin >> cpy >> norm; // induction for count of normal socks
        if (norm <= 0)
        {
            std::cout << "no\n";
        }
        if (norm == 1)
        {
            if (cpy == 0)
            {
                std::cout << "yes\n";
            }
            else
            {
                std::cout << "no\n";
            }
        }
        if (norm >= 2)
        {
            if (norm-cpy>=2)
            {
                std::cout << "no\n";
            }
            else
            {
                if (myAbs(cpy - norm) & 1)
                {
                    std::cout << "yes\n";
                }
                else
                {
                    std::cout << "no\n";
                }
            }
        }
    }
    return 0;
}
