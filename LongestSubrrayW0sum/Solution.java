class Solution{
	
	public int longestSubarrayW0Sum(int[] array){
		Map<Integer, Integer> map = new HashMap();
		int sum = 0;
		int len = 0;
		for(int i=0; i<array.length; i++){
			sum+= array[i];
			if(sum == 0){
				len = i + 1;
			}
			else if(map.containesKey(sum)){
				len = Math.max(len, i-map.get(sum));
			}else{
				map.put(sum, i);
			}
		}
		return len;
	}


}