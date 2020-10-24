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
        BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int mountains = Integer.parseInt(f.readLine());
        int[] array = new int[mountains];
        int changeHigh = 0;
        int changeLow = 0;
        int total = 0;
        int j = mountains - 1;


        //read input
        for(int i = 0; i < mountains; i++){
            array[i] = Integer.parseInt(f.readLine());
        }
        Arrays.sort(array);


        //algorithm to check if diff is > 17
        for(int i = 0; i < mountains; i++){
                while(array[j] - array[i] > 17){
                    array[j]--;
                    changeHigh++;
                    if(array[j] - array[i] <= 17) break;
                    array[i]++;
                    changeLow++;
                    if(array[j] - array[i] <= 17) break;
                }
                total += Math.pow(changeHigh, 2) + Math.pow(changeLow, 2);
                j--;
        }








        out.println(total);
        out.close();
    }

}
