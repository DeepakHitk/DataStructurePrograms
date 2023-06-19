package HashMapAndHeap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());
        // write your code here
        PriorityQueue<Integer> pq = new PriorityQueue();
        int j;
        for (j = 0 ; j < k ; j++){
            pq.add(arr[j]);
        }
        while (j < arr.length){
            if(pq.peek() < arr[j]){
                pq.remove();
                pq.add(arr[j]);
            }
            j++;
        }


        while (pq.size() > 0){
            System.out.println(pq.remove());
        }

    }
}
