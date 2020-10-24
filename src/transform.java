import java.io.*;
import java.util.Arrays;
/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: transform
*/

public class transform {
    public static void main(String[] args) throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("transform.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
    int dimensions = Integer.parseInt(f.readLine());
    char[][] original = new char[dimensions][dimensions];
    for(int i = 0; i < dimensions; i++) {
        String current = f.readLine();
        for (int j = 0; j < dimensions; j++) {
            original[i][j] = current.charAt(j);
        }
    }
        System.out.println(Arrays.deepToString(original));
    char[][] trans = new char[dimensions][dimensions];
    for(int i = 0; i < dimensions; i++) {
        String current1 = f.readLine();
        for (int j = 0; j < dimensions; j++) {
            trans[i][j] = current1.charAt(j);
        }
    }
        System.out.println(Arrays.deepToString(trans));
        System.out.println(Arrays.deepToString(rotate(original)));
    if(Arrays.deepEquals(rotate(original) , trans)){
        out.print(1);
    } else if(Arrays.deepEquals(rotate(rotate(original)), trans)){
        out.print(2);
    } else if(Arrays.deepEquals(rotate(rotate(rotate(original))) , trans)){
        out.print(3);
    }else if(Arrays.deepEquals(reflect(original) , trans)){
        out.print(4);
    }else if(Arrays.deepEquals(rotate(reflect(original)) , trans) || Arrays.deepEquals(rotate(rotate(reflect(original))) , trans )
            || Arrays.deepEquals(rotate(rotate(reflect(original))) , trans)){
        out.print(5);
    }else if(Arrays.deepEquals(original , trans)){
        out.print(6);
    } else{
        out.print(7);
    }
    out.println();
    out.close();





    }

    public static char[][] rotate(char[][] original){
        int n = original.length;
        char[][] ret = new char[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                ret[i][j] = original[n-j-1][i];
            }
        }
        return ret;
    }

    public static char[][] reflect(char[][] original){
        int n = original.length;
        char[][] ret = new char[n][n];
        for(int i = 0; i < n;i++){
            for(int j = 0; j < n;j++){
                ret[i][n-1-j] = original[i][j];
            }
        }
        return ret;
    }
}
