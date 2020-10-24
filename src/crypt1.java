import java.io.*;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: crypt1
*/
public class crypt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

        int numbersInSet = Integer.parseInt(f.readLine());
        String[] str =  f.readLine().split(" ");
        int[] arr = new int[numbersInSet];
        int a;
        int b;
        int c;
        int d;
        int e;
        int count = 0;


        for(int i = 0; i < numbersInSet; i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        for(int a1 = 0; a1 < arr.length; a1++){
            a = arr[a1];
            for(int b1 = 0; b1 < arr.length; b1++){
                b = arr[b1];
                for(int c1 = 0; c1 < arr.length; c1++){
                    c = arr[c1];
                    for(int d1 = 0; d1 < arr.length; d1++){
                        d = arr[d1];
                        for(int e1 = 0; e1 < arr.length; e1++){
                            e = arr[e1];
                           if( calculate(a, b,c, d, e, arr)){
                               count++;

                           }
                        }
                    }
                }
            }
        }

        out.println(count);
        out.close();


    }

    private static boolean isInSet(int digit, int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(digit == arr[i]){
                return true;
            }
        }
        return false;
    }

    private static boolean calculate(int a, int b, int c, int d, int e, int[] arr){
        int top = a * 100 + b * 10 + c;
        int temp = top * e;
        int temp1 = top * d;
        int length = String.valueOf(temp).length();
        int temp2 = temp + temp1 * 10;

        if(String.valueOf(temp1).length() != 3 || String.valueOf(temp).length() != 3
        || String.valueOf(temp2).length() != 4){
            return false;
        }



        for(int i = 0; i < length; i++){
            if(isInSet(temp % 10, arr)){
                temp /= 10;
            } else{
                return false;
            }
        }

        length = String.valueOf(temp1).length();

        for(int i = 0; i < length; i++){
            if(isInSet(temp1 % 10, arr)){
                temp1 /= 10;
            } else{
                return false;
            }
        }



        length = String.valueOf(temp2).length();

        for(int i = 0; i < length; i++){
            if(isInSet(temp2 % 10, arr)){
                temp2 /= 10;
            } else{
                return false;
            }
        }

        return true;



    }
}
