package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Mazepaths {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int dr = scn.nextInt();
        int dc = scn.nextInt();
        System.out.println(getMazePaths(0,0,dr-1, dc-1));
    }

    // sr - source row
    // sc - source column
    // dr - destination row
    // dc - destination column
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        ArrayList<String> outPaths = new ArrayList<String >();
        //base condition
        if(sr == dr && sc == dc){
            outPaths.add("");
        }

        if(sc != dc){
            ArrayList<String> mazePaths1 = getMazePaths(sr, sc + 1, dr, dc);
            for (String str: mazePaths1){
                outPaths.add("h" + str);
            }
        }
        if(sr != dr) {
            ArrayList<String> mazePaths2 = getMazePaths(sr + 1, sc, dr, dc);
            for (String str : mazePaths2) {
                outPaths.add("v" + str);
            }
        }
        return outPaths;
    }
}
