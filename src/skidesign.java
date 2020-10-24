import java.io.*;
import java.util.Arrays;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: skidesign
*/
public class skidesign {
    public static void main(String[] args) throws IOException {
        //variables
//        BufferedReader f = new BufferedReader(new FileReader("test.in"));
//        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int mountains = Integer.parseInt(f.readLine());
        int[] array = new int[mountains];
        int[] array1 = new int[mountains];
        int changeHigh = 0;
        int changeLow = 0;
        int currHigh = 0;
        int currLow = 103;
        boolean moveHigh = true;
        boolean moveLow = true;
        int total = 0;
        int smallTotal = Integer.MAX_VALUE;
        int j = mountains - 1;



        //read input
        for(int i = 0; i < mountains; i++){
            array[i] = Integer.parseInt(f.readLine());
            array1[i] = array[i];
        }
        Arrays.sort(array);
        Arrays.sort(array1);


        if(array[j] - array[0] <= 17){
            out.println(0);
            out.close();
            System.exit(0);
        }
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        currLow = sum / array.length - 10;
        for(int i = currLow; i < currLow + 4; i++){

            while(array[j] - array[0] > 17) {
                changeLow = Math.abs(i - array[0]);
                changeHigh = Math.abs(i + 17 - array[j]);
                total += Math.pow(changeHigh, 2) + Math.pow(changeLow, 2);
                array[0] = i;
                array[j] = i + 17;
                Arrays.sort(array);
                changeHigh = 0;
                changeLow = 0;
            }
            if(total < smallTotal){
                smallTotal = total;
            }
            total = 0;
            array = array1.clone();
        }

        out.println(smallTotal);


        out.close();
    }

}
