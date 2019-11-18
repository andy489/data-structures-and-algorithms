#include <iostream>
#include <string>

int main() {
    std::string text;
    std::cin >> text;

    /// 1 2 3     0 * 10 + 1     1 * 10 + 2    12 * 10 + 3


    int count = 0;
    for (int i = 0; i < text.size(); i++) {
        if (isdigit(text[i])) {
            int digit = text[i] - '0';
            count *= 10;
            count += text[i] - '0';
        } else {
            if (count == 0) {
                std::cout << text[i];
            } else {
                for (int c = 0; c < count; c++) {
                    std::cout << text[i];
                }

                count = 0;
            }
        }
    }

    return 0;
}
