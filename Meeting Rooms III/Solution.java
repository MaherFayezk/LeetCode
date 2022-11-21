class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] meetingsPerRoom=new int[n];
        PriorityQueue<Integer> freeRooms=new PriorityQueue(
            IntStream.range(0,n)
                    .boxed()
                    .collect(Collectors.toList()));
        var runningMeetings=new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        Arrays.sort(meetings, (m1,m2)->m1[0]-m2[0]);
        for(int[] meeting: meetings){
            while(!runningMeetings.isEmpty() && runningMeetings.peek()[0]<=meeting[0]){
                freeRooms.add(runningMeetings.poll()[1]);
            }
            int delay= meeting[0];
            if(freeRooms.isEmpty()){
                var endedMeeting= runningMeetings.poll();
                delay=endedMeeting[0];
                freeRooms.add(endedMeeting[1]);
            }
            var room= freeRooms.poll();
            meetingsPerRoom[room]++;
            runningMeetings.add(new int[]{delay+meeting[1]-meeting[0], room});

        }
        var maxIdx = 0;
		for (int r = 0; r < meetingsPerRoom.length; r++)
			if (meetingsPerRoom[maxIdx] < meetingsPerRoom[r])
				maxIdx = r;

		return maxIdx;
    }
}