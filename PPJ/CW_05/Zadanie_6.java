package CW_05;

/* Zamienić pętle na WHILE

int s = 0;
for(int i =1; i<- 10; i++){
    s = s+ i;
}
*/

public class Zadanie_6{
    public static void main(String[] args){
        int s = 0;
        int i = 1;

        while(i < 11){
            s = s+i;
            i++;
        }

        System.out.println(s);
        System.out.println(i);

        
    }
}