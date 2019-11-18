#include <iostream>
#include <string>

int main() {
    std::string letters;

    std::cin >> letters;

    bool used['z' + 1]{};

    for (char letter : letters) {
        used[letter] = true;
    }

    for (char letter = 'a'; letter <= 'z'; letter++) {
        if (!used[letter]) {
            std::cout << letter;
        }
    }
    std::cout << std::endl;

    return 0;
}
