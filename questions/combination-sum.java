/**
Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 

Time - O((n+k)!) where n is the size of candidates, 
      and k is the max repeated times for each candidates
Space - O(m) where m is the size of array for the solution.

*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        helper(candidates, result, new ArrayList<Integer>(), 0, target);
        return result;        
    }
    
    private void helper(int[] candidates, List<List<Integer>> result, ArrayList<Integer> list, int cur, int target) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = cur; i < candidates.length && candidates[i] <= target; i++) {
            list.add(candidates[i]);
            helper(candidates, result, list, i, target - candidates[i]);
            list.remove(list.size() - 1);
        }
    }
}