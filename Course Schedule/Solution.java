class Solution {
     Map<Integer, List<Integer>> coursesMap=new HashMap();
     Set<Integer> visited= new HashSet();
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int[] course: prerequisites){
            coursesMap.putIfAbsent(course[0], new LinkedList());
            coursesMap.get(course[0]).add(course[1]);
        }
        for(int i=0; i<numCourses; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(Integer course){
        if(visited.contains(course)){
            return false;
        }
        List<Integer> coursePrerequisites= coursesMap.get(course);
        if(coursePrerequisites==null || coursePrerequisites.isEmpty()){
            return true;
        }
        visited.add(course);

        for(Integer prerequisite: coursePrerequisites){
            if(! dfs(prerequisite)){
                return false;
            }
        }
        visited.remove(course);
        coursesMap.replace(course, null);
        return true;
    }
}