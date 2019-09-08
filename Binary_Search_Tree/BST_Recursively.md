***Двоичното дърво за търсене*** е специален вид бинарно дърво. То е ефективна структора за организиране на данни, за която е необходимо бързо търсене и бързa актуализация. 

структура от данни|масив (несортиран)|свързан списък|масив (сортиран)|двоично дърво за търсене
----|----|----|----|----
**търсене**|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">
**актуализиране**|<img src="https://latex.codecogs.com/svg.latex?\Theta{(1)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(1)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">
**премахване**|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">|<img src="https://latex.codecogs.com/svg.latex?\Theta{(log{n})}">

*Можем да минимализираме цената на търсенето в масива или свързания списък, но за целта трябва да бъдат сорирани. Но дори и да пренебрегнем цената на сортировката първоначално, то трябва при всяка актуализация на данните да поддържаме структурата сортирана.*

Двоичното дърво за търсене е такова двоично дърво, на което всеки вътрешен възел складира ключ (и по избор и стойност свъзрана с ключа) и има две обособени поддървета (най-често наричани ляво и дясно). Дървото също така задоволява качеството на двоичното дърво за търсене, което казва че ключът във всеки възел трябва да е по-голям (или равен) от всички ключове пазени във лявото поддърво и по-малък (или равен) от всички ключове пазени в дясното поддърво. (Листата (крайните възли) не съдържат ключ и нямат структура която да ги различи едно от друго. Листата са най-често представяни със специалния leaf или nil знак, референция към nullptr и т.н.).

От по-горната дефиниция, може да стигнем до заключение, че освен нелинейна структура, двоичното дърво за търсене може да се разглежда като рекурсивна структура.

```cpp
//Binary Search Tree (BST) - Implementation in C++
#include <iostream>
using namespace std;
struct BstNode
{
	BstNode* left;
	int data;
	BstNode* right;
};

BstNode* getNewNode(int data)
{
	BstNode* newNode = new BstNode();//BstNode* newNode=(BstNode*)malloc(sizeof(BstNode)); 
	newNode->data = data;//(*newNode).data = data;
	newNode->left = newNode->right = nullptr;
	return newNode;
}

BstNode* insert(BstNode* root, int data)
{
	if (root == nullptr)//empty tree
	{   //case: 1
		root = getNewNode(data);
	}
	else if (data <= root->data)
	{	//case: 2
		root->left = insert(root->left, data);//recursive call
	}
	else
	{	//case: 3
		root->right = insert(root->right, data);
	}
	return root;
}

bool search(BstNode* root, int data)
{
	if (root == nullptr) return false;
	else if (root->data == data) return true;
	else if (data <= root->data)
	{	//search left subtree
		return search(root->left, data);//recursive call
	}
	else
	{	//search right subtree
		return search(root->right, data);
	}
}

BstNode* minValueAddressNode(BstNode* root)
{
	if (root->left == nullptr) return root;
	return minValueAddressNode(root->left);
}

BstNode* remove(BstNode* root, int data)
{
	if (root == nullptr) return root;
	else if (data < root->data) root->left = remove(root->left, data);
	else if (data > root->data) root->right = remove(root->right, data);
	else//we found it, now we must delete it
	{
		if (root->left == nullptr && root->right == nullptr)
		{	//case 1: no child
			delete root;
			root = nullptr;
		}
		else if (root->left == nullptr) //one child
		{   //case 2.1: right child
			BstNode* temp = root;
			root = root->right;
			delete temp;
		}
		else if (root->right == nullptr)
		{	//case 2.2: left child
			BstNode* temp = root;
			root = root->left;
			delete temp;
			return root;
		}
		else//case 3: two children
		{
			BstNode* temp = minValueAddressNode(root->right);//findMax(root->left)
			root->data = temp->data;
			root->right = remove(root->right, temp->data);
		}
	}
	return root;
}

void print(BstNode* root, int leftLim, int rightLim)
{	 
	if (root == nullptr) return;// base case
	//If value of root's key is greater than leftLim, then recursively call in left subtree
	if (leftLim < root->data) print(root->left, leftLim, rightLim);
	// If value of root's key is in range, then print the root's key
	if (leftLim <= root->data && rightLim >= root->data) cout << root->data << " ";
	//If value of root's key is smaller than krightLim, then recursively call in right subtree
	if (rightLim > root->data) print(root->right, leftLim, rightLim);
}

void test()
{
	BstNode* root = nullptr; //To store address of root node. 
						//This is pointer to root and not the root itself. 
							 //Initially setting the root to NULL, 
							 //to say that the tree is empty 
	root = insert(root, 22); root = insert(root, 9); root = insert(root, 18);
	root = insert(root, 50); root = insert(root, 10); root = insert(root, 14);

	print(root, 0, 100);

	int data; // our data is an integer number, but it can be anything
	cout << "\nEnter a data to be searched:\n";
	cin >> data;
	search(root, data) ? cout << "found" : cout << "not found";
	cout << "\n~Removing node with key value 22!";
	remove(root, 22);

	cout << "\nEnter a data to be searched:\n";
	cin >> data;
	search(root, data) ? cout << "found\n" : cout << "not found\n";

	print(root, 0, 100);
}

int main()
{
	test();	
	return 0;
}
```

**Задача.** Да се напише функция, която проверява дали дадено двоично дърво е двоично дърво за търсене.

*Решение:*

Естествено интуитивния, но не толкова ефикасен подход е да използваме отново рекурсия. За да бъде дадено двоично дърво - двоично дърво за търесене е необходимо за корена му да са изпълнени следните условия: 
- всички елементи на лявото поддърво да са по-малки или равни 
- всички елементи на дясното поддърво да са по-големи
- лявото и дясното поддървета са също двоични дърва за търсене
Остана да добавим и базовия случай или така нареченото дъно на рекурсията - когато дървото или поддървото са празни.

```cpp
bool isSubtreeLesser(BstNode* root, int data)
{
	if (root == nullptr) return true;
	if (root->data <= data
		&& isSubtreeLesser(root->left, data)
		&& isSubtreeLesser(root->right, data)) return true;
	else return false;
}

bool isSubtreeGreater(BstNode* root, int data)
{
	if (root == nullptr) return true;
	if (root->data > data
		&& isSubtreeGreater(root->left, data)
		&& isSubtreeGreater(root->right, data)) return true;
	else return false;
}

bool isBinarySearchTree(BstNode* root)
{
	if (root == nullptr) return true;
	if (isSubtreeLesser(root->left, root->data)
		&& isSubtreeGreater(root->right, root->data)		
		&& isBinarySearchTree(root->right)
		&& isBinarySearchTree(root->left)) return true;
	else return false;
}
```
Вместо функциите *bool isSubtreeLesser(BstNode* root, int data)* и *bool isSubtreeGreater(BstNode* root, int data)* може да напишем функция, която да намира максималния ключ на лявото поддърво и да го сравним с ключа на корена, ако той е по-малък от него, значи всички ключове на лявото поддървото са по-малки от ключа на корена, аналогично ако минималния ключ на дясното поддърво е по-голям от ключа на корена, значи всички ключове на дясното поддърво са с по-голям ключ от ключа на корена. Но така или иначе и в двата случая ще извършим прекалено много излични и преповтарящи се сравнения на брой, което ще оскъпи прекалено много проверката. За по-ефикасно решение на задачата може да задаваме ограничителни интервали за ключовете на всеки следващ възел и да проверяваме дали ключа на следващия възел се намира в интервала. Тези проверки ще се извършват за константно време, докато предишните се изпълняваха за пропорционално на броя на възлите на поддърветата. Освен това ще преминем през всеки възел точно веднъж.

```cpp
bool isBstUtil(BstNode* root, int minValue, int maxValue)
{
	if (root == nullptr) return true;
	if (root->data > minValue && root->data < maxValue
		&& isBstUtil(root->left, minValue, root->data)
		&& isBstUtil(root->right, root->data, maxValue)) return true;
	else return false;
}

bool isBinarySearchTree(BstNode* root)
{
	return isBstUtil(root, INT_MIN, INT_MAX);
}
```

Сложността на първия алгоритъм е <img src="https://latex.codecogs.com/svg.latex?\Theta{(n^2)}">, а сложността на втория е <img src="https://latex.codecogs.com/svg.latex?\Theta{(n)}">.
