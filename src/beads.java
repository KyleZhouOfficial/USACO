import java.io.*;

/*
   ID: kyle.yi1
   LANG: JAVA
   PROG: beads
*/
public class beads {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("test.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("test.out")));
        int beads = Integer.parseInt(f.readLine());
        String neaklace_org = f.readLine();


        char type;
        char color;
        int index;
        int max = 0;
        int fcount = 0;
        int bcount = 0;
        String neaklace = "";
        for(int i = 0; i < beads ; i++){
            fcount = 0;
            bcount = 0;
            neaklace = neaklace_org;


            index = i;
            if(index == beads){
                index = 0;
            }
            type = neaklace.charAt(index);
            int count = 0;
            while (type == 'w'){
                index++;
                fcount++;
                if(index == beads){
                    index = 0;
                }
                type = neaklace.charAt(index);
                count++;
                if(count == beads){
                    break;
                }
            }

            if(fcount == beads){
                max = fcount;
                break;
            }

            color = type;
            index++;
            if(index == beads){
                index = 0;
            }

            fcount++;
            count = 0;
            while(neaklace.charAt(index) == color || neaklace.charAt(index) == 'w'){
                if(neaklace.charAt(index) == 'w'){
                    neaklace = neaklace.substring(0, index) + color + neaklace.substring(index + 1);
                }
                index++;
                if(index == beads){
                    index = 0;
                }
                fcount++;
                count++;
                if(count == beads - 1){
                    break;
                }
            }
            if(fcount == beads){
                max = fcount;
                break;
            }






            if(i == 0){
                index = beads-1;
            }
            else{
                index = i-1;
            }

            type = neaklace.charAt(index);
            count = 0;
            while (type == 'w'){
                index--;
                bcount++;
                if(index == -1){
                    index = beads - 1;
                }
                type = neaklace.charAt(index);
                count++;
                if(count == beads){
                    break;
                }
            }
            color = type;
            index--;
            bcount++;
            if(index == -1){
                index = beads - 1;
            }
            count = 0;
            while(neaklace.charAt(index) == color || neaklace.charAt(index) == 'w'){
                index--;
                bcount++;
                if(index == -1){
                    index = beads - 1;
                }
                count++;
                if(count == beads){
                    break;
                }
            }

            if(fcount + bcount > max){
                max = fcount + bcount;

            }


        }
        out.print(max);
        out.println();
        out.close();

    }
}
