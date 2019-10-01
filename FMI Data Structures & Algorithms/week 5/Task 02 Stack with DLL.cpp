#include <iostream>
#include <string>
#include <windows.h>
#include <climits>

struct Stone
{
	Stone *prev, *next;
	std::string color;
	int number;

	Stone(std::string color, int number, Stone *prev = nullptr, Stone *next = nullptr); //constructor with two default arguments
};

struct Path
{
	Stone *head; // in our case we use head only for printing
	Stone *tail;
	int size = 0;

	Path(); // default constructor

	Stone* getNewNode(std::string color, int number); // utility function for creating a new Node

	void addAtTail(std::string color, int number);
	bool eraseAtTail();

	friend std::ostream& operator<<(std::ostream& os, const Path& list); // same as print but with operator << for the List
};

int main()
{
	Path LillyPath;
	std::string color; int number, i, count;
	std::cout << "Enter count of stones at Lilly's path: ";
	std::cin >> count;
	for (i = 1; i <= count; i++)
	{
		if (i == 1)
		{
			SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
			std::cout << "~For every stone enter color and number separated by space:\n";
			SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
		}
		std::cout << "Stone " << i << ": ";
		std::cin >> color >> number;
		if (color == "white")
		{
			LillyPath.addAtTail(color, number);
		}
		else
		{
			if (color == "green")
			{
				int sumPrev(0);
				for (int i = 0; i < number; i++)
				{
					sumPrev += LillyPath.tail->number;
					LillyPath.eraseAtTail();

				} LillyPath.addAtTail("white", sumPrev);
			}
			else if (color == "blue")
			{
				int maxPrev(INT_MIN);
				for (int i = 0; i < number; i++)
				{
					if (LillyPath.tail->number > maxPrev)
					{
						maxPrev = LillyPath.tail->number;
					}
					LillyPath.eraseAtTail();
				} LillyPath.addAtTail("white", maxPrev);
			}
		}
	}
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 2);
	std::cout << "~Lilly's path after her walk:\n";
	SetConsoleTextAttribute(GetStdHandle(STD_OUTPUT_HANDLE), 7);
	std::cout << LillyPath;
	return 0;
}

Stone::Stone(std::string color, int number, Stone *prev, Stone *next)
{
	this->color = color;
	this->number = number;
	this->prev = prev;
	this->next = next;
}

Path::Path()
{
	head = tail = nullptr;
}

Stone * Path::getNewNode(std::string color, int number)
{
	Stone *newNode = new Stone(color, number);
	return newNode;
}

void Path::addAtTail(std::string color, int number)
{
	Stone *newNode = getNewNode(color, number); size++;
	if (head == nullptr)
	{
		head = tail = newNode;
	}
	else
	{
		Stone* temp = tail;
		tail = newNode;
		newNode->prev = temp;
		temp->next = tail;
		tail = temp->next;
	}
}

bool Path::eraseAtTail()
{
	if (head == nullptr)
	{
		std::cout << "cannot perform erase - path is empty\n";
		return false;
	}
	else if (head->next == nullptr)
	{
		delete head;
		head = tail = nullptr; size--;
		return true;
	}
	else
	{
		tail = tail->prev;
		delete tail->next;
		tail->next = nullptr; size--;
		return true;
	}
}

std::ostream & operator<<(std::ostream & os, const Path& path)
{
	Stone* traversal = path.head;
	if (traversal == nullptr)
	{
		os << "path is empty\n";
	}
	else
	{
		while (traversal != nullptr)
		{
			os << traversal->color << ' ' << traversal->number << '\n';
			traversal = traversal->next;
		}
	}
	return os;
}
