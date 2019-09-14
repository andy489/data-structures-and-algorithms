## Infix, Postfix, Prefix

### Evaluation of arithmetic and logical expressions

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
---|
2 + 3 = 5
4 + 6 * 2 = 4 + 12 = 16
