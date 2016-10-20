/**
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples:

Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]

*/


public class Solution {

    
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> vo = new  TreeMap<Integer, List<Integer>>();
    
        printVO(root,vo);
        
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        Set<Integer> i = vo.keySet();
		for (int keys : i) {
		    List<Integer> c = vo.get(keys);
		    System.out.println(c);
			ll.add(c);
		}
        return ll;
        
    }
    
    public void printVO(TreeNode root, TreeMap<Integer, List<Integer>> vo){
         if (root == null)
            return;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> volevel = new LinkedList<Integer>();
        
        queue.add(root);
        volevel.add(0);
        
        int levelNodes = 0;
        
        while(!queue.isEmpty()){
            levelNodes = queue.size();
            while(levelNodes > 0){
                TreeNode node = queue.poll();
                Integer hd = volevel.poll();
                if(vo.containsKey(hd)){
                    List<Integer> ml = vo.get(hd);
                    ml.add(node.val);
                    vo.put(hd,ml);
                }else{
                    List<Integer> l=new ArrayList<Integer>();
                    l.add(node.val);
                    vo.put(hd,l);
                }
                if(node.left != null){
                    queue.add(node.left);
                    volevel.add(hd-1);
                }
                if(node.right != null){
                    queue.add(node.right);
                    volevel.add(hd+1);
                }
                
                levelNodes--;
            }
        }

    }
}