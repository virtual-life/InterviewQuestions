/**
 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 Time - O( log(k) * n )
 k is number of list and n is number of total elements.
 */

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());

        for(ListNode l : lists){
            if (l != null)
                queue.add(l);
        }
        ListNode head = new ListNode(0);
        ListNode p = head;
        while(!queue.isEmpty()){
            ListNode n = queue.poll();
            p.next = n;

            if(n.next != null){
                queue.add(n.next);
            }

            p = p.next;
        }

        return head.next;
    }
}

class ListNodeComparator implements Comparator<ListNode>{
    public int compare(ListNode n1, ListNode n2){
        if(n1.val>n2.val){
            return 1;
        }if(n1.val <n2.val){
            return -1;
        }else{
            return 0;
        }
    }
}


// For Arrays 


public class Solution{    

 public static List<Integer> mergeKArrays(int[][] arrays) {
      if (arrays == null || arrays.length == 0) {
          throw new IllegalArgumentException("Invalid input!");
      }     
      // priority queue is heap in Java
      PriorityQueue<HeapItem> pq = new PriorityQueue<HeapItem>();             
      // add arrays to the heap
      int total=0;
      for (int i = 0; i < arrays.length; i++) {
          pq.add(new HeapItem(arrays[i], 0));
          total = total + arr[i].length;
      }
  
      List<Integer> result = new ArrayList<Integer> (total);  
  
      while (!pq.isEmpty()) {             
          HeapItem current = pq.remove();
          result.add(current.array[current.index]);                       
          if (current.index < current.array.length-1) {  
             current.index++;
             pq.add(current);  
          }
     }
     return result;
 }
 
  public static class HeapItem implements Comparable<HeapItem>{               
      int[] array;                
      int index;        // the index of current element               
      public HeapItem(int[] arr, int index) {
           this.array = arr;
           this.index = index;
      }  
  
      @Override
      public int compareTo(HeapItem h){
          if(this.array[this.index] > h.array[h.index]){
              return 1;
          }else if(this.array[this.index] < h.array[h.index]){
              return -1;
          }else{
              return 0;
          }
      }
 }
 
}

