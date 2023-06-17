package RecursionAndBacktracking;

import java.util.*;

public class StringSubsequence {
    public static void main(String[] args) throws Exception {

        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(gss(str));
    }

    public static ArrayList<String> gss(String str) {
        ArrayList<String> returnArray = new ArrayList<String>();
        String ros = "";
        if(str.length() == 0){
            returnArray.add("");
            return returnArray;
        }
        if(str.length() > 1){
            ros = str.substring(1);
        }
        ArrayList<String> gss = gss(ros);
        for (String string: gss){
            returnArray.add(str.charAt(0) + string);
            returnArray.add(string);
        }
        return returnArray;
    }
}
