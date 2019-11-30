#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n, id;
    scanf("%d", &n);

    unordered_map<int,int> clientOrders;

    while (n-- && scanf("%d",&id))
    {
        clientOrders[id]++;
    }

    int clients_waiting(0), undelivered_products(0);

    for (const auto& x : clientOrders)
    {
        if (x.second % 10)
        {
            clients_waiting++;
        }
        undelivered_products += x.second % 10;
    }
    printf("%d %d", clients_waiting, undelivered_products);    
    return 0;
}
