### Check for balanced parentheses

**Problem**: Given an expression in the form of a string comprising of constants, variables, operators and parenthesis. In the definition of parenthesis we also include curly braces and brackets, i.e. (, {, [, ], }, ). So the expression or string can contain characters that can be upper or lower case letters, symbols for operators and an opening or closing parenthesis (or an opening or closing curly brace, or an opening or closing square bracket). Let's write down some expressions here:

- **(A+B)**         *balanced*
- **{(A+B)+(C+D)}** *balanced*

Given such expressions we want to write a program that would tell us whether parenthesis in the expression are balanced or not and what do we really mean by balanced parenthesis is that corresponding to each opening parenthesis or opening curly brace or opening bracket we should have a closing counter part in correct order. The upper two expressions are balanced, however the following expressions are not balanced:
- **{(x+y).(z)** *not balanced*
  - missing a closing curly brace at the end
- **[2+3]+(A)]** *not balanced*
  - missing an opening square bracket at the beginning
- **{a+z)** *not balanced*
  - corresponding to the opening curly brace we do not have a closing curly brace and corresponding to the closing paranthesis we do not have an opening paranthesis
  
  Checking for balanced paranthesis is one of the tasks performed by a compiler. WHen we write a program we often miss an opening or closing curly brace or an opening or closing paranthesis:
```cpp
int main()
{
	for (int i = 0; i < 100; i++)
	{
		// some code	
}
```
Compiler must check for this balancing and if symbols are not balanced it should give you an error. In the above problem what's inside the paranthesis does not matter, we do not want to check for correctness of anything that is inside a paranthesis so in the string any character other than opening and closing paranthesis or opening or closing curly brace or opening or closing square bracket can be ignored. This problem sometimes is better stated like this: Given a string comprising only of opening and closing characters of paranthesis braces or brackets - check for balancing. So only these characters and their order is important:
- **()**
- **{()()}**
- **{()()**
- **[]()]**
- **{)**
