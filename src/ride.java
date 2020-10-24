import java.io.*;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: ride
*/

class ride {

        public static void main (String [] args) throws IOException {
            // Use BufferedReader rather than RandomAccessFile; it's much faster
            BufferedReader f = new BufferedReader(new FileReader("ride.in"));
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));

            // Get line, break into tokens
            String i1 = f.readLine();
            String i2 = f.readLine();
            // second integer
            if(getValue(i1) % 47 == getValue(i2) % 47){
                out.println("GO");
            } else{
                out.println("STAY");
            }
            out.close();
        }

        public static int getValue(String str){
            int product = 1;
            for(int i = 0; i < str.length(); i++){
                product *= ((int)str.charAt(i)) - 64;
            }
            return product;
        }
    }
