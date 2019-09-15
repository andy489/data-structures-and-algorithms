### Evaluation of Prefix and Postfix expressions

Algorithms to evaluate prefix and postfix expressions are similar. We are going to analyze postfix evaluation first, because its easier to understand and implement. 

Let's look at the following expression in infix form and analyze its convertion into postfix form:

A * B + C * D - E
-|

As we know in infix form the operator is written in between operands and we want to convert to postfix in which operator is written after operands. We need to go step-by-step just the way we would go in evaluation of infix. We need to go in order of precedence and in each step we need to identify operands of an operator and we need to bring the operator in front of the operands. What we can actually do is we can first resolve operator precedence and put paranthesis at appropriate places. 

IN the given expression we must first do the multiplication, then we'll do the second multiplication then we will perform the addition and finally the subtraction:

A * B + C * D - E ⇒ (A * B) + C * D - E ⇒ (A * B) + (C * D) - E ⇒ {(A * B) + (C * D)} - E
-|

Now to convert into reverse polish notation (i.e. postfix), we will go one operator at a time. Operands for the first multiplication are 'A' and 'B'. So A * B will become A B * . Next we will need to look at the second multiplication, which will be converted similarly to the previous one as C D * . After the both multiplications we can do the change for the addition operator. The two operands for the addition are the two expressions in postfix from the two multiplications. So we are plasing the plus operator after the two new expressions. Finally for the last operator the operands are one complex expression and a variable 'E' . So this is how it will look like after the transformation:

{(A * B) + (C * D)} - E ⇒ (A B * ) + (C D * ) - E ⇒ {(A B * )(C D * ) +} - E ⇒ {(A B * )(C D * ) +} E - 
-|

Finally when we are done with all the operators we can get rid of all the paranthesis. They are not needed in postfix expression:

A B * C D * + E -
-|

OK, now we have the upper post expression and we want to evaluate it. For the purposes of that let's say we have the following values for the variables:

A=2|B=3|C=5|D=4|E=9
-|-|-|-|-

So we have the following expression in terms of values to evaluate:

2 3 * 5 4 * + 9 -
-|

We will first quickly examine how we can evaluate a postfix expression manually. What we need to do is to scan the expression from left to right and find the first occurence of an operator. Now, remember that in postfix expressions operands of an operator will always lie to its left. For the first operator, the preceding two entities will always be operands. We need to look for the first occuranse of the following pattern: *operand, operand, operator* in the expression and after that we can apply the operator on the two operands and reduce the expression:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<op1><op2><operator>:2,3*5,4*+9-\Rightarrow{6,5,4*+9-}">
  
We need to repeat this process until we are done with all the operators. Once again we need to scan the expression from left to right and look for the first operator, if the expression is correct it will be preceeded by two values. So basically we need to look for first ocurrence of this pattern: operand, operand, operator. So now we can reduce again:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<op1><op2><operator>:2,3*5,4*+9-\Rightarrow{6,5,4*+9-}\Rightarrow{6,20+9-}"> 

*(we are using comma as delimiter)*

Once again we will look for the first occurance of operand, operand and operator. We will go on like this until we are done with all the operators.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<op1><op2><operator>:2,3*5,4*+9-\Rightarrow{6,5,4*+9-}\Rightarrow{6,20+9-}\Rightarrow{26,9-}\Rightarrow{17}">

Тhe first operator to appear will always be preceeded by two values (not expressions). If we give this some thought we will be able to understand why. 

So if we have to do this programatically, if we have to evaluate a postfix expression given to us in a string like the above ones and let's say operands and operators are separated by space or some other delimeter like comma also to separate operands and operator, what we can do is we can parse the string from left to right. In each step in the parsing (in each step in the scanning process) we can get a token that will either be an operator or an operand. What we can do is - as we parse from left to right, we can keep track of all the operands seen so far:

*we will mark with ' the current position of the scanner*

2 3 '* 5 4 * + 9 - 
-|
List: 2, 3

So we are keeping all the operands seen so far in the string. When we scan an operator, as in our case a multiplication operator, we should be applied to last two operans to the left of it (preceding it). Because we already have the elements stored in this list, all we need to do is to pick the last two from the list and perform the operation. It should be 2 * 3 adn with this multiplication we have reduced the expression (because 2 3 * has now become 6, it has become an operand that can be used by an operator later). Next in the scanning we have an operand 5 and we will push it into the list, and after that again we well push 4 for the same reason we pushed 5 before that:

2 3 * 5 4 '* + 9 -  
-|
List: 6, 5, 4

And after that we will have the multiplication operator. We it should be applied to the last two operands in the reduced expression (and we should put the result back into the list):

2 3 * 5 4 * '+ 9 -   
-|
List: 6, 20

Now, for the following scanning we have an operator again and we should take out the last two elements from the list and we should put the result back:

2 3 * 5 4 * + 9 '-  
-|
List: 26

Next we have an operand followed by an operator subtraction (we will perform the subtraction and put the result back into the list):

2 3 * 5 4 * + 9 - ' 
-|
List: 17

Finally when we are done with scanning the whole expression we will have only one element left in the list and this will be the final answer. This is an efficient algorithm. We are doing only one pass on the string representing the expression and we have our result. The list that we are using here if we could notice is being used in a special way. We are inserting operands one at a time from one side and then to perform an operation we are taking out operand from the same side. Whatever is coming in last is getting out first. This whole thing that we're doing here with the list can be done efficiently with a **stack**, which is nothing but a special kind of list in which elements are inserted and removed from the same side in which whatever gets in last comes out first. It's called **Last In First Out (LIFO)** structure. 

So let's write a pseudocode for the above algorithm (function with a string argument):

```cpp
EvaluatePostfix(expression)
{
      Create a stack S
      // assuming for simplicity that each operand or operator in the expression 
      // will be of only one character
      for i = 0 to length(expression)-1
      {
            if expression[i] is operand
                Push(expression[i])
            else if expression[i] is operator
                OP2 = Pop()
                OP1 = Pop() // Pop() both removes and returns the element from the stack
                store the values of the operands in some variables (OP2 and OP1 in our case)
                res = Perform(expression[i],OP1,OP2) // storing the output in a variable res
                Push(res)
      }  
      return top of stack
}
```
In our actual implementation we will have to take care of some parsing locic. Operand can be a number of multiple digits and then we will have delimiter like space or comma, so we will have to take care of that also. Parsing operand or operator will be some task.

This was postfix evaluation. Let's now see how we can do prefix evaluation:

Convertion:

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<op1><operator><op2>:2*3+5*4-9\Rightarrow{\{(2*3)+(5*4)\}-9}\Rightarrow{\{(*23)+(*54)\}-9}\Rightarrow{\{(*23)(*54)\}-9}\Rightarrow{-\{(*23)(*54)\}9}\Rightarrow{-+*23*549}"> 

Calculation: just like the postfix, only this time we will scan from right to left.

[Evaluation OF Postfix Expression Implemented with C++](https://github.com/andy489/Data_Structures_and_Algorithms_CPP/blob/master/Evaluation%20Of%20Postfix%20exp.cpp)
