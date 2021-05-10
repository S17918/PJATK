/*
Write a Java program to print the result of the following operations.
Test Data:
a. -5 + 8 * 6
b. (55+9) % 9
c. 20 + -3*5 / 8
d. 5 + 15 / 3 * 2 - 8 % 3
Expected Output :
43
1
19
13
*/

package JAVA_BASIC_1.ex_004;

public class main{
    public static void main(String[] args){
        System.out.println(-5+8*6);
        System.out.println((55+9)%9);
        System.out.println(20+(-3*5)/8);
        System.out.println(5+((15/3)*2) - (8%3));
    }
}