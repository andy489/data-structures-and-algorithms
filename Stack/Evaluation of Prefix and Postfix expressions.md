### Evaluation of Prefix and Postfix expressions

Algorithms to evaluate prefix and postfix expressions are similar. We are going to analyze postfix evaluation first, because its easier to understand and implement. 

Let's look at the following expression in infix form and analyze its convertion into postfix form:

A * B + C * D - E
-|

As we know in infix form the operator is written in between operands and we want to convert to postfix in which operator is written after operands. We need to go step-by-step just the way we would go in evaluation of infix. We need to go in order of precedence and in each step we need to identify operands of an operator and we need to bring the operator in front of the operands. What we can actually do is we can first resolve operator precedence and put paranthesis at appropriate places. 

IN the given expression we must first do the multiplication, then we'll do the second multiplication then we will perform the addition and finally the subtraction:

A * B + C * D - E ⇒ (A * B) + C * D - E ⇒ (A * B) + (C * D) - E ⇒ {(A * B) + (C * D)} - E
-|

