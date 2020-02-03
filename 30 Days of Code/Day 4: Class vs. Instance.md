https://www.hackerrank.com/challenges/30-class-vs-instance/problem
## Day 4: Class vs. Instance.

#### Objective
In this challenge, we're going to learn about the difference between a class and an instance; because this is an Object Oriented concept, it's only enabled in certain languages. Check out the [Tutorial](https://www.hackerrank.com/challenges/30-class-vs-instance/tutorial) tab for learning materials and an instructional video!

#### Task
Write a Person class with an instance variable, <img src="https://latex.codecogs.com/svg.latex?\Large&space;age">, and a constructor that takes an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge"> , as a parameter. The constructor must assign <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge"> to  <img src="https://latex.codecogs.com/svg.latex?\Large&space;age"> after confirming the argument passed as <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge"> is not negative; if a negative argument is passed as <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge"> , the constructor should set <img src="https://latex.codecogs.com/svg.latex?\Large&space;age"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> and print *Age is not valid, setting age to 0.*.<br> In addition, you must write the following instance methods:

1. *yearPasses()* should increase the <img src="https://latex.codecogs.com/svg.latex?\Large&space;age"> instance variable by **1**.<br>
2. *amIOld()* should perform the following conditional actions:<br>
- If <img src="https://latex.codecogs.com/svg.latex?\Large&space;age<13">, print *You are young.*.
- If <img src="https://latex.codecogs.com/svg.latex?\Large&space;age\ge{13}"> and <img src="https://latex.codecogs.com/svg.latex?\Large&space;age<18">, print *You are a teenager.*.
- Otherwise, print *You are old.*.

To help you learn by example and complete this challenge, much of the code is provided for you, but you'll be writing everything in the future. The code that creates each instance of your Person class is in the main method. Don't worry if you don't understand it all quite yet!

**Note:** Do not remove or alter the stub code in the editor.

#### Input Format

Input is handled for you by the stub code in the editor.

The first line contains an integer, <img src="https://latex.codecogs.com/svg.latex?\Large&space;T">(the number of test cases), and the <img src="https://latex.codecogs.com/svg.latex?\Large&space;T"> subsequent lines each contain an integer denoting the <img src="https://latex.codecogs.com/svg.latex?\Large&space;age"> of a Person instance.

#### Constraints

- <img src="https://latex.codecogs.com/svg.latex?\Large&space;1\le{T}\le{4}">
- <img src="https://latex.codecogs.com/svg.latex?\Large&space;-5\le{age}\le{30}">

#### Output Format

Complete the method definitions provided in the editor so they meet the specifications outlined above; the code to test your work is already in the editor. If your methods are implemented correctly, each test case will print <img src="https://latex.codecogs.com/svg.latex?\Large&space;2"> or <img src="https://latex.codecogs.com/svg.latex?\Large&space;3"> lines (depending on whether or not a valid <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge"> was passed to the constructor).

#### Sample Input
```
4
-1
10
16
18
```
#### Sample Output
```
Age is not valid, setting age to 0.
You are young.
You are young.

You are young.
You are a teenager.

You are a teenager.
You are old.

You are old.
You are old.
```
#### Explanation

Test Case 0: <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge=-1"><br>
Because <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge<0">, our code must set <img src="https://latex.codecogs.com/svg.latex?\Large&space;age"> to <img src="https://latex.codecogs.com/svg.latex?\Large&space;0"> and print the "*Age is not valid...*" message followed by the young message. Three years pass and <img src="https://latex.codecogs.com/svg.latex?\Large&space;age=3">, so we print the young message again.

Test Case 1:<img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge=10"><br>
Because , our code should print that the person is young. Three years pass and <img src="https://latex.codecogs.com/svg.latex?\Large&space;age=13">, so we print that the person is now a teenager.

Test Case 2:<img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge=16"><br>
Because <img src="https://latex.codecogs.com/svg.latex?\Large&space;13\le{initialAge}<18">, our code should print that the person is a teenager. Three years pass and <img src="https://latex.codecogs.com/svg.latex?\Large&space;age=19">, so we print that the person is old.

Test Case 3:<img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge=18"><br>
Because <img src="https://latex.codecogs.com/svg.latex?\Large&space;initialAge\ge{18}">, our code should print that the person is old. Three years pass and the person is still old at <img src="https://latex.codecogs.com/svg.latex?\Large&space;age=21">, so we print the old message again.

**The extra line at the end of the output is supposed to be there and is trimmed before being compared against the test case's expected output. If you're failing this challenge, check your logic and review your print statements for spelling errors.**
