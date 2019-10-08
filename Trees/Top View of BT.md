# *Binary Tree: Level traversal. Vertical traversal. Top view.

#### Нека е дадено бинарно дърво. Под *Top view* ще разбираме множеството от върхове принадлежащи на бинарното дърво, които се виждат от върха му (в нашия случай под връх на кореновото дърво ще разбираме противоречиво на лексиката - неговия корен).

Ако например ни е дадено следното дърво:
```
         6
      /     \
     4       8
   /   \    /  \
  3     5  7    10
```
Избираме корена *6* да е на нивото на хоризонта (тоест ако хоризонта е променлива която има стойност *0* то при върха със стойност *6* стойността на хоризонта ще е *0*). Нека променливата която съхранява информацията за позицията на всеки връх от дървото спрямо хоризонта е *horizontDistance*. Тогава за върховете *4* и *6*, тази променлива ще има стойност съответно *-1* и *1*. Аналогично за 
*3, 5, 7, 10* ще имат стойност съответно *-2, 0, 0, 2*. Очевидно за всяка хоризонтална колона, ако тя има само един елемент - директно може да кажем, че този връх ще се вижда от върха, а ако това не е изпълнено, тогава ще ни трябва точно този елемент/връх, който е най близо до върха (този, който ще е възможно най-отгоре на всяка хоризонтална колона). Това автоматично означава, че освен някаква структура която на ключ *horizontDistance* съхранява контейнер от всички върхове на тази дистанция, трябва да съхранява и на всеки елемент от контейнера на каква дълбочина в дървото се намира. В такъв случай би било най-удобно да направим **хеш таблица с ключ *horizontDistance***, на който ключ ще отговаря **стойност от тип *вектор* с елементи *pair*** - с **първа стойност връх от дървото** и **втора стойност съответната му дълбочина** (*всички върхове в съответния контейнер ще имат една и съща хоризонтална дистанция*). Така ще можем от всеки ключ да извадим възможно най-горе стоящия връх и да го принтираме. Получения резултат ще е искания.

#### Решение:

```cpp
#include <iostream>
#include <map>
#include <vector>
#include <queue>

/* Програна която принтира всички върхове видими от върха на дървото (в случая крена). Например
Заявкоа за върхове: 7				Заявка за върхове: 8
Върхове: 10, 5, 13, 6, 7, 8, 9                  Върхове: 6, 4, 8, 3, 5, 7, 10, 12

   10								6
  /  \							     /     \
 5    13						    4       8
  \							   / \     / \
   6						          3   5   7   10
    \	                                                               \
     7  							        14
      \
       8 
        \
         9
Изход: 5, 10, 13, 8 , 9				Изход: 3, 4, 6, 8, 10, 14

Коментар: В нашия случай функцията за добавяне на върхове в дървото е имплементирана по начин,
който поддържа дървото да бъде бинарно дърво за търсене, но логиката за намирането на topView
трябва да работи за всяко бинарно дърво (дори и то да не е за търсене) */

struct Node
{
	Node* left, * right;
	int data;
	Node(int data) : left(nullptr), right(nullptr), data(data) {};
};

Node* add(Node* root, int data)
{	/* функция която добавя върхове в дървото по начин както го прави в BST (бинарно
	 дърво за търсене), просто за да може да изтестваме дали кода работи правилно */
	if (root == nullptr) root = new Node(data);
	else if (data <= root->data) root->left = add(root->left, data);
	else root->right = add(root->right, data);
	return root;
}

std::map<int, std::vector<Node*>> getLevelOrderMap(Node* root)
{
	std::map<int, std::vector<Node*>>levelOrderMap;
	if (root == nullptr) levelOrderMap;
	std::queue<Node*>Q;
	int level(0);
	Q.push(root);
	Q.push(nullptr);
	while (!Q.empty())
	{
		Node* curr = Q.front();
		if (curr != nullptr)
		{
			levelOrderMap[level].push_back(curr);
			if (curr->left != nullptr) Q.push(curr->left);
			if (curr->right != nullptr)	Q.push(curr->right);
			Q.pop();
		}
		else
		{
			level++;
			Q.pop();
			Q.push(nullptr);
			if (Q.front() == nullptr) return levelOrderMap; // две последователни нули в опашката			
		}
	}
	return levelOrderMap; // не би трябвало никога да се изпълни този код, но го слагаме за пълнота
}

void fillVerticalOrderMap(Node* root, int horizontDistance, int level, std::map<int, std::vector<std::pair<Node*, int>>>& map)
{
	if (root == nullptr) return;

	map[horizontDistance].push_back(std::make_pair(root, level));

	fillVerticalOrderMap(root->left, horizontDistance - 1, level + 1, map);
	fillVerticalOrderMap(root->right, horizontDistance + 1, level + 1, map);
}

std::map<int, std::vector<std::pair<Node*, int>>> getVerticalOrderMap(Node* root)
{
	std::map<int, std::vector<std::pair<Node*, int>>> verticalOrderMap;
	if (root == nullptr) return verticalOrderMap;
	int horizontDistance(0), level(0);
	fillVerticalOrderMap(root, horizontDistance, level, verticalOrderMap);
	return verticalOrderMap;
}

int main()
{
	Node* root = nullptr;
	// първото дърво от примерите най-отгоре
	/*root = add(root, 10);	root = add(root, 13);	root = add(root, 5);
	root = add(root, 6);	root = add(root, 7);	root = add(root, 8);
	root = add(root, 9);*/

	// второто дърво от примерите най-отгоре
	root = add(root, 6);	root = add(root, 4);	root = add(root, 5);
	root = add(root, 3);	root = add(root, 8);	root = add(root, 10);
	root = add(root, 14);	root = add(root, 7);

	std::map<int, std::vector<Node*>>levelOrderMap = getLevelOrderMap(root);
	for (auto i : levelOrderMap)
	{
		std::cout << "Level " << i.first << ": ";
		for (auto j : i.second)
		{
			std::cout << j->data << ' ';
		}
		std::cout << '\n';
	}

	std::cout << '\n';

	std::map<int, std::vector<std::pair<Node*, int>>>verticalOrder = getVerticalOrderMap(root);
	for (auto i : verticalOrder)
	{
		std::cout << "Horizont distance " << i.first << ": ";
		for (auto j : i.second)
		{
			std::cout << j.first->data << ' ';
		}
		std::cout << '\n';
	}

	std::cout << "\nPrint top view:\n";
	for (auto i: verticalOrder)
	{
		if (i.second.size()==1)
		{
			std::cout << i.second[0].first->data << ' ';
		}
		else
		{
			std::pair<Node*,int> mostTopNode = i.second[0];
			for (auto j: i.second)
			{
				if (j.second<mostTopNode.second)
				{
					mostTopNode = j;
				}
			}
			std::cout << mostTopNode.first->data << ' ';
		}
	}
	std::cout << '\n';

	return 0;
}

```
