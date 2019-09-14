## Infix, Postfix, Prefix

### Evaluation of arithmetic and logical expressions

- 2 + 3
- A - B
- (P * 2)

<img src="https://latex.codecogs.com/svg.latex?\Large&space;<operand><operator><operand>">

Operand -> object in which operation is performed

An expression can have constants, variables and symbols that can be operators or paranthesis and all these components must be arranged according to a set of grammer rules. We should also be able to parse and evaluate expression according to this grammer. All these expressions that we have written above have a common structure. We have an operator in between two operands. Operand by definition is an object or value on which operation is performed. In the first expression 2+3, 2 and 3 are operands and + is operator, in the second expression A and B are operands and - is operator, in the third expression P is a variable and 2 is a constant, but they both are operands and * is operator (asteriks used for multiplication). This is the most common way of writing an expression, but this is not the only way. This way of writing an expression in which we write an operator in between operands is called infix notation. Operand doesn't always have to be a constant or variable. Operand can be an expression itself. In this forth expression that we have written:
- (2 + 3) * 4

one of the operands of multiplication operator is an expression itself, another operand is a constant. We can have a further complex expression.
