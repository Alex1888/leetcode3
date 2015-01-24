package zz;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res=new LinkedList<List<Integer>>();
		if(candidates==null||candidates.length==0 || target<=0){
			return res;
		}
		Arrays.sort(candidates);
		helper(0,new LinkedList<Integer>(),candidates,res,target);
		return res;
	}
	
	public void helper(int index, List<Integer> buf,int[] candidates, List<List<Integer>> res, int target){
		if(target==0){
			res.add(new LinkedList<Integer>(buf));
			return;
		}
		if(index==candidates.length){
			return;
		}
		if(candidates[index]>target){
			return;
		}
		
		int next=index+1;
		while(next<candidates.length && candidates[next]==candidates[index]){
			next++;
		}
		helper(next,buf,candidates,res,target);
		for(int i=0;i<next-index;i++){
			buf.add(candidates[index]);
			target-=candidates[index];
			helper(next,buf,candidates,res,target);
		}
		for(int i=0;i<next-index;i++){
			buf.remove(buf.size()-1);
		}
	}
}
