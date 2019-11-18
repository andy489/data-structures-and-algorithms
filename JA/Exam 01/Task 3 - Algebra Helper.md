## Task 3 – Algebra Helper 

Little Ibrahim has some trouble with his math homework. He tries to learn some equation by heart. Help him out!<br> 
Ibrahim remembers the equations in his head by memorizing their **result**. He has good visual memory and utilizes it. He arranges the equations in his head in **descending** order by their **result**.<br>
If two or more equations have the same result he keeps their order from the input. The first one remains first, second one – second, etc … <br>
An equation will only be constructed from a 2 integers and an operating between the 2 integers. <br>
NOTE: only the following 5 operations should be supported:<br> 
- + (sum) 
- - (subtraction)  
- * (multiplication) 
- / (integer division) 
- % (integer modulo) 
NOTE 2: there will be no brackets. Nothing fancy – just 2 integers and an operation between them. 
#### Input 
First a single integers (N) indicating how many equations will follow (each on a different line).<br> 
Next read (N) lines of equations. Each equation contains a number, after that an operations and then another number – always in that order. 
#### Restrictions 
Time limit: 250ms (0.25s)<br>
Memory limit: 16 MB 
#### Examples 
Input|Output
-|-
3<br>1 / 2<br>1 * 2<br>1 + 2|1 + 2<br>1 * 2<br>1 / 2 
4<br>2 * 0<br>6 % 4<br>5 + 3<br>2 – 6|5 + 3<br>6 % 4<br>2 * 0<br>2 – 6
4<br>2 * 13<br>6 % 3<br>20 + 6<br>2 – 2|2 * 13<br>20 + 6<br>6 % 3<br>2 – 2 
