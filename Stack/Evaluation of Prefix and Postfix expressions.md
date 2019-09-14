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

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<op1><op2><operator>:2,3*5,4*+9-\Rightarrow{6,5,4*+9-}\Rightarrow{6,20+9-}"> *(we are using comma as delimiter)*

Once again we will look for the first occurance of operand, operand and operator. We will go on like this until we are done with all the operators.

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<op1><op2><operator>:2,3*5,4*+9-\Rightarrow{6,5,4*+9-}\Rightarrow{6,20+9-}\Rightarrow{26,9-}\Rightarrow{17}">
