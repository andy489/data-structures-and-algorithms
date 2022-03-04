#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

//const int ROWS = 5;
//const int COLS = 10;

// площадка отбелязваме с тире '-', празна клетка отбелязваме със звездичка '*'
char **read_matrix(int &rows, int &cols) {
    cout << "Enter number of rows: ";
    cin >> rows;
    cout << "Enter number of columns: ";
    cin >> cols;

    char **matrix = new char *[rows];

    for (int i = 0; i < rows; ++i) {
        matrix[i] = new char[cols];
    }

    for (int r = 0; r < rows; ++r) {
        for (unsigned c = 0; c < cols; c++) {
            cin >> matrix[r][c];
        }
    }

    return matrix;
}

template<typename T>
void release_matrix(T **matrix, int rows) {
    for (int i = 0; i < rows; ++i) {
        delete[] matrix[i];
    }

    delete[] matrix;
}

bool **create_duplicate_bool(int rows, int cols) {
    bool **visited = new bool *[rows];

    for (int i = 0; i < rows; ++i) {
        visited[i] = new bool[cols];
    }

    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
            visited[i][j] = false;
        }
    }

    return visited;
}

struct Area {   // създаваме си клас описващ площадка
    unsigned start_index;
    unsigned end_index;
    unsigned sz;
};

void release_vec_of_pointers(vector<Area *> &areas) {
    for (auto &area : areas) {
        delete area;
    }

    areas.clear();
}

/* Хардкоднати матрици за тестване в течение на имплементация на решението */
//char P[ROWS][COLS] = { { '-', '-', '-', '-', '*', '*', '*', '-', '-','-' },
//					   { '-', '-', '-', '*', '*', '-', '*', '*', '-', '*' },
//					   { '-', '-', '*', '*', '-', '-', '-', '*', '*', '*' },
//					   { '-', '-', '*', '*', '*', '-', '*', '*', '*', '*' },
//					   { '-', '*', '*', '*', '*', '*', '*', '*', '*', '-' } };
//
//char Q[ROWS][COLS] = { { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' },
//					   { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' },
//					   { '*', '-', '-', '*', '*', '*', '*', '*', '-', '-' },
//					   { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' },
//					   { '*', '-', '-', '*', '-', '-', '-', '*', '-', '-' } };
//
//char R[ROWS][COLS] = { { '-', '-', '-', '*', '-', '-', '-', '*', '-', '*' },
//					   { '-', '-', '-', '*', '-', '-', '-', '*', '-', '*' },
//					   { '-', '-', '-', '*', '-', '-', '-', '*', '-', '*' },
//					   { '-', '-', '-', '-', '*', '-', '*', '-', '-', '*' },
//					   { '*', '*', '*', '*', '*', '*', '*', '*', '*', '*' } };

template<typename T>
void print_matrix(T **M, int rows, int cols) { // помощна функция за принтиране на оригиналната матрица, за тестване
    for (int r = 0; r < rows; ++r) {
        for (int c = 0; c < cols; ++c) {
            cout << M[r][c] << ' ';
        }
        cout << endl;
    }
    cout << endl;
}

void print_vec_with_areas(vector<Area *> &areas) { // помощна функция за принтиране на вектора от площадки
    for (int i = 0; i < areas.size(); ++i) {
        cout << "Area #"
             << i + 1
             << " at (" << areas[i]->start_index
             << ", "
             << areas[i]->end_index
             << "), sz: "
             << areas[i]->sz
             << endl;
    }
}

bool is_safe(int row, int col, int rows, int cols, char **M, bool **(&visited)) {
    // реда и колоната не са извън размера на матрицата и клетката не е посетена все още
    return (row >= 0) && (row < rows) && (col >= 0) && (col < cols) && (M[row][col] == '-' && !visited[row][col]);
}

int cnt_size_dfs(int row, int col, int rows, int cols, char **M, bool **(&visited), int K, int *rowBr4, int *colBr4,
                 int &sz) {
    visited[row][col] = true; // маркираме клетката като посетена
    for (int k = 0; k < K; ++k) {
        if (is_safe(row + rowBr4[k], col + colBr4[k], rows, cols, M, visited)) {
            ++sz;
            cnt_size_dfs(row + rowBr4[k], col + colBr4[k], rows, cols, M, visited, K, rowBr4, colBr4,
                         sz);
        }
    }

    return sz;
}

int cnt_islands_and_areas(char **M, int rows, int cols, vector<Area *> &areas, bool **(&visited), int K, int *rowBr4,
                          int *colBr4, int &size) {
    int cnt = 0; // Инициализираме брояча на 0, като започваме да обхождаме всички клетки на матрицата

    for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; j++) {
            // Ако клетката не е посетена и е част от площадка
            if (M[i][j] == '-' && !visited[i][j]) {
                // инкрементираме броя на площадките
                ++cnt;
                // не е посещавана до сега - обхождаме и посещаваме всички клетки в тази площадка
                int area_size = cnt_size_dfs(i, j, rows, cols, M, visited, K, rowBr4, colBr4, size);

                // cout << "Area #" << count << " at (" << i << ", " << j << "), sz: " << area_size << endl;

                Area *a = new Area(); /* оператор new => оператор delete */
                a->start_index = i;
                a->end_index = j;
                a->sz = area_size;
                areas.push_back(a);
            }
            size = 1;
        }
    }

    return cnt;
}

int main() {
    /* Помощни масиви за достигане на индексите на реда и колоната
        на всички 8 съседа на дадена клетка (дефиниция с ръбче) */
    int rowBr8[] = {-1, -1, -1, 0, 0, 1, 1, 1};
    int colBr8[] = {-1, 0, 1, -1, 1, -1, 0, 1};

    /* Помощни масиви за достигане на индексите на реда и колоната
    на всички 4 съседа на дадена клетка (дефиниция с точно една обща стена) */
    int row_dir[] = {-1, 0, 0, 1};
    int col_dir[] = {0, -1, 1, 0};

    const int DIM = 4;

    int rows, cols;
    char **M = read_matrix(rows, cols);

    cout << endl << "Original matrix is:" << endl << endl;
    print_matrix(M, rows, cols);

    // булева матрица дубликат, на която ще отбелязваме дали сме посетили дадена клетка от оригиналната матрица
    bool **visited = create_duplicate_bool(rows, cols);

    // cout << endl << "Duplicate bool matrix is:" << endl << endl;
    // print_matrix(visited, rows, cols);

    vector<Area *> areas; /* създаваме си вектор от пойнтъри към площадки,
   					  като не забравяме после да изтрием поинтърите */

    int size = 1; /* инициализираме с конструктор с параметър променливата sz да приема
   				  стартова стойност 1, защото вече сме намерили площадка с поне единица размер */

    int totalCount = cnt_islands_and_areas(M, rows, cols, areas, visited, DIM, row_dir, col_dir, size);

    cout << "Total areas found: " << totalCount << endl;

    auto lambda = [](Area const *a, Area const *b) { return a->sz > b->sz; };

    sort(areas.begin(), areas.end(), lambda);

    print_vec_with_areas(areas);

    release_matrix(M, rows);
    release_matrix(visited, rows);
    release_vec_of_pointers(areas);

    return 0;
}