class Solution {
    Map<Integer, List<Integer>> coursemap=new HashMap();
    Set<Integer> visited= new HashSet();
    Set<Integer> cycle= new HashSet();
    int [] result;
    int i=0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses <1){
             return new int[0]; 
        }
        for(int[] course: prerequisites){
            coursemap.putIfAbsent(course[0], new LinkedList());
            coursemap.get(course[0]).add(course[1]);
        }
        result= new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(! dfs(i)){
                return new int[0];
            }
        }
        return result;
    }
    private boolean dfs(Integer course){
        if(cycle.contains(course)){
            return false;
        }
        if(visited.contains(course)){
            return true;
        }
        cycle.add(course);
         List<Integer> coursePrerequisites= coursemap.get(course);
        if(coursePrerequisites!=null && !coursePrerequisites.isEmpty()){
            for(Integer prerequisite: coursePrerequisites){
                if(! dfs(prerequisite)){
                    return false;
                }
            }
        }
       
        cycle.remove(course);
        visited.add(course);
        result[i++]=course;
        return true;
    }
}