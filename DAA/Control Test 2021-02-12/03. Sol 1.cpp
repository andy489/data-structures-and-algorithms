#include <cstdio>
#include <cstring>

using namespace std;

const int MAX_LENGTH = 3 * int(1e5)+5;
const int MODULE = 1e9+7;

char str[MAX_LENGTH];
size_t length;

unsigned long int dyn[MAX_LENGTH];

unsigned long int solve() {
    dyn[0] = dyn[1] = 1;

    for(size_t i = 1; i < length; i++) {
        if(str[i] == str[i-1]) {
            if(str[i] == 'u' || str[i] == 'n') {
                dyn[i+1] = (dyn[i] + dyn[i-1]) % MODULE;
            } else {
                dyn[i+1] = dyn[i];
            }
        } else {
            dyn[i+1] = dyn[i];
        }
    }
    return dyn[length];
}

int main() {
    scanf("%s", str);
    length = strlen(str);

    for(size_t i = 0; i < length; i++) {
        if(str[i] == 'm' || str[i] == 'w') {
            printf("0\n");
            return 0;
        }
    }

    printf("%lu\n", solve());

    return 0;
}
