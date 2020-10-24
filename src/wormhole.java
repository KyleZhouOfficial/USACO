import java.io.*;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: wormhole
*/
public class wormhole {
    static int N;
    static int MAX_N = 12;
    static int[] X = new int[MAX_N + 1];
    static int[] Y = new int[MAX_N + 1];
    static int[] partner = new int[MAX_N + 1];
    static int[] next_on_right = new int[MAX_N + 1];



    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        N = Integer.parseInt(f.readLine());


        for(int i = 1; i <= N;i++){
            String[] str = f.readLine().split(" ");
            X[i] = Integer.parseInt(str[0]);
            Y[i] = Integer.parseInt(str[1]);
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if((X[j] > X[i]) && Y[i] == Y[j]){
                    if(next_on_right[i] == 0 ||
                        X[j] - X[i] < X[next_on_right[i]] - X[i]){
                        next_on_right[i] = j;
                    }
                }
            }

        }

        out.println(solve());
        out.close();


    }

    private static boolean cycle_exists(){

        for(int start = 1; start <= N; start++){

            int pos = start;
            for(int count = 0; count < N; count++){
                pos = next_on_right[partner[pos]];
            }
            if(pos != 0){
                return true;
            }

        }
        return false;
    }

    /**
     *
     * @return
     */
    private static int solve(){
        int total = 0;
        int i;
        for(i = 1; i <= N; i++) {
            if (partner[i] == 0) break;
        }

        if(i > N){
            if(cycle_exists()) return 1;
            else return 0;
        }

        for(int j = i +1; j <= N; j++){
            if(partner[j] == 0){
                partner[j] = i;
                partner[i] = j;
                total += solve();
                partner[i] = partner[j] = 0;
            }
        }


        return total;

    }
}

