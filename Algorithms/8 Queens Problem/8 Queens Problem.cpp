/*Да се намерят всички възможни начини, по които може да се поставят 8 кралици на шахматна дъска, 
така че да не се „бият“ една-друга.*/

// github.com/andy489

#include <iostream>
#include <set>
#define size 8

int board[size][size];

std::set<int> attackedRows;
std::set<int> attackedCols;

unsigned count;

bool canPlaceQueen(int row, int col){
	if (attackedRows.count(row) || attackedCols.count(col)) return false;
	// left-up 
	for (int i = 1; i < size; i++){
		int currRow = row - i;
		int currCol = col - i;

		if (currRow < 0 || currRow >= size ||
			currCol < 0 || currCol >= size){
			break;
		}
		if (board[currRow][currCol] == 1){ // Queen here
			return false;
		}
	}
	// right-up 
	for (int i = 1; i < size; i++){
		int currRow = row - i;
		int currCol = col + i;

		if (currRow < 0 || currRow >= size ||
			currCol < 0 || currCol >= size){
			break;
		}
		if (board[currRow][currCol] == 1){ // Queen here
			return false;
		}
	}
	// left-down 
	for (int i = 1; i < size; i++){
		int currRow = row + i;
		int currCol = col - i;

		if (currRow < 0 || currRow >= size ||
			currCol < 0 || currCol >= size){
			break;
		}
		if (board[currRow][currCol] == 1){ // Queen here
			return false;
		}
	}
	// right-down 
	for (int i = 1; i < size; i++){
		int currRow = row + i;
		int currCol = col + i;

		if (currRow < 0 || currRow >= size ||
			currCol < 0 || currCol >= size){
			break;
		}
		if (board[currRow][currCol] == 1){ // Queen here
			return false;
		}
	}
	return true;
}
void markAttackedFields(int row, int col){
	board[row][col] = 1;
	attackedRows.insert(row);
	attackedCols.insert(col);
}
void unmarkAttackedFields(int row, int col){
	board[row][col]=0;
	attackedRows.erase(row);
	attackedCols.erase(col);
}
void printSolution(){
	count++;
	for (int row = 0; row < size; row++){
		for (int col = 0; col < size; col++){
			if (board[row][col] == 1) std::cout << "Q ";
			else std::cout << "- ";
		}
		std::cout << '\n';
	}
	std::cout << '\n';
}

void solve(int row){
	if (row == size){
		printSolution();
		return;
	}
	else{
		for (int col = 0; col < size; col++){
			if (canPlaceQueen(row, col)){
				markAttackedFields(row, col);
				solve(row + 1);
				unmarkAttackedFields(row, col);
			}
		}
	}
}

int main(){	
	solve(0);
	std::cout << "Total count: " << count << "\n";
	return 0;
}
