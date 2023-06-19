package HashMapAndHeap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HighestFreqChar {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Map<Character,Integer > map = new HashMap<Character,Integer>();
        int size = 0;
        char out = ' ';

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for(char ch : map.keySet()){
            if(map.get(ch) > size){
                size = map.get(ch);
                out = ch;
            }
        }
        System.out.println(out);
    }
}
