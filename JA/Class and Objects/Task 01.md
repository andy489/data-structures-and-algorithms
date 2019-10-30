## Task 1 – Sentence Shifter
You are given a **list of words** in one line. On the other line you are given a **simple integer**.
Your role is to **shift the words** in the sentence **according to that integer.**
For example if a sentence has 10 words and you receive a shift number 2 - the first word should become the third, the second word should become the fourth and so on, ..., the word before the last should become the first and the last word should become the second.
Implement this task with a class that is initialized with a **linear container** (array, vector, etc.) of words and which has a **getShiftedSentence()** method which returns the words shifted.
Each word is printed on a different line.

#### Examples

Input|Output
Welcome to my github and have fun learning programming<br>2|learning<br>programming<br>Welcome<br>to<br>my<br>github<br>and<br>have<br>fun

```cpp
#include <iostream>
#include <sstream>
#include <list>
using namespace std;

class Sentence
{
	list<string> Q;
public:
	Sentence()
	{
		string line;
		getline(cin, line);
		istringstream istr(line);
		while (istr >> line)
		{
			Q.push_back(line);
		}
	}

	void getShiftedSentence()
	{
		int N;
		cin >> N;

		int M = N % Q.size();
		string str;
		while (M != 0)
		{
			str = Q.back();
			Q.push_front(str);
			Q.pop_back();
			M--;
		}
	}

	friend ostream& operator<<(ostream& os, Sentence& s)
	{
		while (!s.Q.empty())
		{
			os << s.Q.front() << '\n';
			s.Q.pop_front();
		}
		return os;
	}
};

int main()
{
	Sentence S;
	S.getShiftedSentence();
	cout << S;
	return 0;
}
```
