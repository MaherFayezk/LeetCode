import java.util.LinkedList;
class Solution {
//TC O(nlogn)
//SC O(n)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval->interval[0]));
        LinkedList<int[]> result=new LinkedList();
        
        for(int [] interval:intervals){
            if(result.isEmpty() || interval[0]>result.getLast()[1]){
                result.add(interval);
            }
            else {
                result.getLast()[1]=Math.max(interval[1],result.getLast()[1]);
            }
        }
        return result.toArray(new int [result.size()][]);
    }
}