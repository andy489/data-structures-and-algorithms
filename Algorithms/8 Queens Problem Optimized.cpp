// github.com/andy489

#include <iostream>
#include <set>
#define size 8

bool chessboard[size][size];

std::set<int> attackedCols;
std::set<int> attackedLeftDiagonals;
std::set<int> attackedRightDiagonals;

unsigned count;

bool canPlaceQueen(int row, int col){
	bool positionOccupied =
		attackedCols.count(col) ||
		attackedLeftDiagonals.count(col - row) ||
		attackedRightDiagonals.count(row + col);
	return !positionOccupied;
}
void markAllAttackedPositions(int row, int col){
	attackedCols.insert(col);
	attackedLeftDiagonals.insert(col-row);
	attackedRightDiagonals.insert(row+col);
	chessboard[row][col] = true;
}
void unmarkAllAttackedPositions(int row, int col){	
	attackedCols.erase(col);
	attackedLeftDiagonals.erase(col - row);
	attackedRightDiagonals.erase(row + col);
	chessboard[row][col] = false;
}
void printSolution(){
	count++;
	int row,col;
	for (row = 0; row < size; row++){
		for (col = 0; col < size; col++){
			if (chessboard[row][col] == 1) std::cout << "Q ";
			else std::cout << "- ";
		}
		std::cout << '\n';
	}
	std::cout << '\n';
}

void putQueens(int row)
{
	if (row == size){
		printSolution();		
	}
	else{ int col;
		for (col = 0; col < size; col++){
			if (canPlaceQueen(row, col)){
				markAllAttackedPositions(row, col);
				putQueens(row + 1);
				unmarkAllAttackedPositions(row, col);
			}
		}
	}
}

int main(){
	putQueens(0);
	std::cout << "Total count: " << count << "\n";
	return 0;
}
