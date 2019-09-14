## Infix, Postfix, Prefix

### Arithmetic and logical expressions syntax

- 2 + 3
- A - B
- (P * 2)

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<operand><operator><operand>">

Operand -> object in which operation is performed

An expression can have constants, variables and symbols that can be operators or paranthesis and all these components must be arranged according to a set of grammer rules. We should also be able to parse and evaluate expression according to this grammer. All these expressions that we have written above have a common structure. We have an operator in between two operands. Operand by definition is an object or value on which operation is performed. In the first expression 2+3, 2 and 3 are operands and + is operator, in the second expression A and B are operands and - is operator, in the third expression P is a variable and 2 is a constant, but they both are operands and * is operator (asteriks used for multiplication). This is the most common way of writing an expression, but this is not the only way. This way of writing an expression in which we write an operator in between operands is called infix notation. Operand doesn't always have to be a constant or variable. Operand can be an expression itself. In this forth expression that we have written:
- (2 + 3) * 4

-one of the operands of multiplication operator is an expression itself, another operand is a constant. We can have a further complex expression. In this fifth expression that we have written:
- (P + Q) * (R + S)

-here both the operands of multiplication operator are expressions. We have three operators in this expression. For the first plus operator variables P and Q are operands, for the second plus operator we have R and S  as operands and for the asteriks multiplication operator we have the first operand to be the first expression and the second operand to be the second expression. While evaluating expressions with multiple operators, operations will have to be performed in certain order. Like in the forth example - we will first have to perform the addition and then only we can perform multiplication. In the fifth expression - first we will have to perform the two additions and then we can perform the multiplication. As we can see in all these expressions operator is placed in between operands. This is the syntax that we are following. One thing that we must point out here is that troughout this analysis, we are going to talk only about binary operators. An operator that requires exactly two operands is called a binary operator. Technically we can have an operator that may require just one operand or maybe more than two operands but we are talking only about expressions with binary operators.

Let us now see what are the rules we need to apply to evaluate such expressions written in this syntax that we are calling infix notation. For an expression with just one operator we can simply apply that operator. For an expression with multiple operators and no paranthesis like 4 + 6 * 2, we need to decide an order in which operator should be applied. In the example expression if we perform the addition first then it will reduce to 10 * 2 nd finally evaluate as 20 but if we perform the multiplication first
then the expression will reduce to 4 + 12 and finally evaluate to 16. So basically, we can look at this expression in two ways.

Infix
-|
2 + 3 = 5
4 + 6 * 2 = 4 + 12 = 16

We can say that operands for addition operator are 4 and 6 and operands for multiplication are the expression 4 + 6 and the constant 2 or we can say that all operands for multiplication are 6 and 2 and operands for addition operation are four and the expression 6 * 2. There is some ambiguity here but if we remember our high school mathematics this problem is resolved by following operator precedence rules. In an algebraic expression this is the precedence that we follow:

Order of operation|Symbols|Direction|Example
-|-|-|-
1.) Parantheses| ( ) { } [ ]|| (4 + 6) * 2 => 10 * 2 = 20
2.) Exponents|^|Right to Left|2^3^2 => 2^9 => 512
3.) Multiplication and division|* /|Left to Right| 6 * 4 / 2 => 24 / 2 => 12
4.) Addition and Subtraction|+ -|Left to Right|4-2+1 => 2 + 1 = 3 or 4 + 6 * 2 => 4 + 12 => 16

- Another example: 2* 6 / 2 - 3 + 7 => 12 / 2 - 3 + 7 => 6 - 3 + 7 => 3 + 7 => 10

This *"left to right"* and *"right to left"* rule for operators with equal precedence is better termed as operator associativity. If in case of multiple operators with equal precedence we go from left to right then we say that operators are *left* associative and if we go from right to left we say that operators are *right* associative. While evaluating an expression in infix form, we first need to look at precedence, and then to resolve conflict among operator with equal precedence, we need to see associativity. All in all we need to do so many things just to parse and evaluate an infix expression. The use of paranthesis becomes really important, because that's how we can control the order in which operation should be performed. Paranthesis add explicit intent that operations should be performed in this order and also improved readability of expression. 

- {(2 * 6) / 2} - (3 + 7) = -4, most often we write infix expressions using a lot of paranthesis 

Even though *infix* notation is the most common way of writing expressions, it's not very easy to parse and evaluate an infix expression without ambiguity. So mathematicians and logicians studied this problem and came up with 2 other ways of writing expressions that are paranthesis free and can be passed without ambiguity, without requiring to take care of any of these operator precedence or associativity rules. These two ways are *postfix* and *prefix* notations.

Prefix notation was proposed earlier in year 1924 by Polish logician [Jan Łukasiewicz](https://en.wikipedia.org/wiki/Jan_Łukasiewicz). Prefix notation is also known as [Polish notation](https://en.wikipedia.org/wiki/Polish_notation). In prefix notation, operator is placed before operands.

prefix: <img src="https://latex.codecogs.com/svg.latex?\Large&space;<operator><operand><operand>">

Infix|Prefix|Postfix 
-|-|-
2 + 3 | + 2 3 | 2 3 +
P - Q | - P Q | P Q -
a + b * c| + a * b c | b c a * +

postfix: <img src="https://latex.codecogs.com/svg.latex?\Large&space;<operator><operand><operand>">

Postfix notation is also known as [reverse polish notation](https://en.wikipedia.org/wiki/Reverse_Polish_notation
). This syntax was proposed in 1950s by some computer scientists. In postfix notaton operator is placed after operands. Programmatically, postfix expression is easiest to parse and least costly in terms of time and memory to evaluate, and that's why this was actually invented. Prefix expression can also be evaluated in similar time and memory, but the algorithm to parse and evaluate postfix expression is really straightforward and intuitive and that;s why its prederred for computation using machines.

In prefix and postfix form an operand can be associated with only one operator. So we do not have this ambiguity, while parsing and evaluating prefix and postfix expressions we do not need extra information. We do not need all the operator precedence and associativity rules. To separate the operands we can use a space or some other delimiter like a comma. That's how you would tipically store prefix or postfix in a string when you'll have to write a program.

To convert an expression from infix to any of these other two forms, we need to go step-by-step just the way we would go in evaluation. Let's pick a random expression in infix form: A + B * C . We should first convert the part that should be evaluated first, so we should go in order of precedence. We can also first put all the implicit paranthesis. So here we will first convert B * C . A + B * C => A + (* B C) => + A(* B C) = > + A * B C . We can use paranthesis in intermediate steps and once we are done with all the steps we can erase the paranthesis. 

Let's now do the same thing for postfix. We will first do the conversion for multiplication operator and then in next step we will do it for addition and after that we can get rid of all the paranthesis: A + (B * C) => A + (B C * ) => A( B C * ) + => A B C * + .

Paranthesis surely adds readability to any of these expressions/forms, but if we are not bothered about human readability, then for a machine we are actually saving some memory that would be used to store paranthesis information. Infix expression definitely is most human readable, but prefix and postfix are good for machines.

