import java.io.*;
/*
   ID: kyle.yi1
   LANG: JAVA
   PROG:dualpal
*/

public class dualpal {
        public static void main(String[] args) throws IOException {
            BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
            String[] array = f.readLine().split(" ");
            int amount = Integer.parseInt(array[0]);
            int limit = Integer.parseInt(array[1]) + 1;
            int count = 0;
            int count1 = 0;




            while(count1 < amount){
                for (int i = 2; i <= 10; i++){
                    if(baseChanger(limit, i).equals(reverse(baseChanger(limit, i)))
                            &&  Long.parseLong(baseChanger(limit, i)) % 10 != 0){
                        count++;
                    }
                }
                if(count >= 2){
                    out.println(limit);
                    count1++;
                }
                limit++;
                count = 0;
            }

            out.close();
        }

        private static String baseChanger(int number, int base){
            String str = "";
            int digit = 0;

            while(number >= base){
                digit = number % base;
                str = digit + str;
                number -= digit;
                number /= base;
            }
            str = number + str;
            return str;

        }

        private static String reverse(String number){
            String str = "";
            for(int i = 0; i < number.length(); i++){
                str = number.charAt(i) + str;
            }
            return str;
        }
    }

