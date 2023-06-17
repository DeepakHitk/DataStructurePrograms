package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public static String  arr[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wzyz"};
    public static void main(String[] args) {
        System.out.println(getCombination(""));
    }
    public static List<String> getCombination(String str){

        List<String> output = new ArrayList<String>();
        //Base condition
        if(str.length() == 0){
            return output;
        }

        char c = str.charAt(0);
        String ros = str.length() > 1 ? str.substring(1) : "";

        List<String> list = getCombination(ros);
        if(list.isEmpty()){
            list.add("");
        }

        for(String listStr: list){
            String charStr = arr[c - '0'];
            for(int i = 0; i < charStr.length(); i++){
                output.add(charStr.charAt(i) + listStr);
            }
        }
        return output;

    }
}
