package BackTracking.CombinationSum2_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> resList=new ArrayList<List<Integer>>();
        if(target<=0)
        	return resList;
        
        Arrays.sort(candidates);
        List<Integer> tmpList=new ArrayList<Integer>();
        helper(resList,tmpList,candidates,target,0);
        
        return resList;
    }
    
    public void helper(List<List<Integer>> resList, List<Integer> tmpList, int[] candidates, int target, int start){
    	if(target==0){
    		resList.add(new ArrayList<Integer>(tmpList));
    		return;
    	}
    	
    	for(int i=start; i<candidates.length; i++){
    		if(candidates[i]<=target){
    			if(i>0 && candidates[i]==candidates[i-1] && i!=start)
    				continue;
    			tmpList.add(candidates[i]);
    			helper(resList,tmpList,candidates,target-candidates[i],i+1);
    			tmpList.remove(tmpList.size()-1);
    		}else
    			return;
    	}
    }
}
