import java.io.*;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: Chapter1.palsquare
*/
public class palsquare {

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        int base = Integer.parseInt(f.readLine());
        String palindrome = "";
        for(int i =1; i <= 300; i++){
            palindrome = baseChanger((int)Math.pow(i, 2), base);
            if(palindrome.equals(reverse(palindrome))){
                out.print(baseChanger(i, base) + " " + palindrome);
                out.println();
            }

        }
        out.close();


    }

    private static String baseChanger(int number, int base){
        String str = "";
        int digit = 0;

        while(number >= base){
            digit = number % base;
            if(digit > 9){
                str = (char) (digit + 55) + str;
            } else{
                str = digit + str;
            }
            number -= digit;
            number /= base;
        }
        if(number > 9){
            str = (char) (number + 55) + str;
        } else{
            str = number + str;
        }
        return str;

    }


    private static String reverse(String str){
        String reversed = "";
        for(int i = 0; i < str.length(); i++){
            reversed = str.charAt(i) + reversed;
        }
        return reversed;
    }
}
