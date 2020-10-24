import java.io.*;
/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: combo
*/
public class combo {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("combo.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));

        int numbersOnDial = Integer.parseInt(f.readLine());
        int[] lock1 = new int[3];
        int[] lock2 = new int[3];
        int starter = 250;


        if(numbersOnDial < 5){
            out.println( (int) Math.pow(numbersOnDial, 3));
            out.close();
            System.exit(0);
        }




        String[] str = f.readLine().split(" ");

        for(int i = 0; i < 3; i++){
            lock1[i] = Integer.parseInt(str[i]);
        }

        str = f.readLine().split(" ");

        for(int i = 0; i < 3; i++){
            lock2[i] = Integer.parseInt(str[i]);
        }

        out.println(250 - (intWrap(lock1[0] ,lock2[0], numbersOnDial)
                * intWrap(lock1[1] ,lock2[1], numbersOnDial)
                * intWrap(lock1[2] ,lock2[2], numbersOnDial)));
        out.close();








    }

    private static int intWrap(int number, int number1, int numbersOnDial){
        if(Math.max(number, number1) - Math.min(number, number1) > numbersOnDial / 2){
            if(numbersOnDial - (Math.max(number, number1) - Math.min(number, number1)) < 5){
                return 5 - (numbersOnDial - (Math.max(number, number1) - Math.min(number, number1)));
            }
        } else{
            if((Math.max(number, number1) - Math.min(number, number1)) < 5){
                return 5 - (Math.max(number, number1) - Math.min(number, number1));
            }
        }

        return 0;

    }
}
