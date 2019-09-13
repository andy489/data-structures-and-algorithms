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

While parsing a real expression we can simply ignore other characters. All we care about is these characters and their order.

Now, how do we solve this problem? One straight forward thing that comes to mind is that because we should have a closing counter part for an opening paranthesis or opening curly brace or opening square bracket what we can do is, we can count the number of opening and closing symbols for each of these three types and they should be equal. So the number of opening paranthesis should be equal to number of closing paranthesis. And the number of opening curly braces should be equal to number of closings curly braces and same should be true for square brackets as well. But this would not be good enough and here is a counter example:
- **)(**
  - this expression has one opening paranthesis and one closing paranthesis, but it is not balanced
- **[()]**
  - this one is balanced
- **[(])**
  - but this one with the same number of characters of each type as the second expression is not balanced

So the above approach with counting will not work. Apart from count being equal that are some other properties that must be conserved. **Every opening paranthesis must find a closing counterpart to its right and every closing paranthesis must find an opening counterpart in its left**, which is not true in the first expression. And the other property that must be conserved is that **a paranthesis can close only when all the paranthesis opened after it are closed**. In the third expression, the bracket is closed before the paranthesis is closed. 

### Last Opened First Closed

which is the same as LIFO principle (Last In First Out)
