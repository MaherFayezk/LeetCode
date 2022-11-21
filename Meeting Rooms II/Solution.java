/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        int[] start=new int[intervals.size()];
        int[] end=new int[intervals.size()];
        for(int i=0; i< intervals.size();i++){
            start[i]=intervals.get(i).start;
            end[i]=intervals.get(i).end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int numOfRooms=0;
        int count=0;
        int p1=0, p2=0;
        while(p1<start.length && p2<end.length){
            if(start[p1]<end[p2]){
                count++;
                p1++;
            }else {
                count--;
                p2++;
            }
            numOfRooms= Math.max(numOfRooms, count);
        }
        return numOfRooms;
    }
}