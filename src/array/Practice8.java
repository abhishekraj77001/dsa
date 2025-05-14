package array;

import java.util.*;

public class Practice8 {


    // Need To Check more
    static int minimumConferenceRoomRequired(int[][]  intervals)
    {
        int maxConferenceRoomCount=0;

        Arrays.sort(intervals, Comparator.comparingInt(x->x[0]));

        for(int i=0;i<intervals.length;i++)
        {
            int count=1;
            for(int j=0;j<intervals.length;j++)
            {
                if(j!=i && intervals[i][1]>intervals[j][0] && intervals[i][0] < intervals[j][1])
                {
                    count++;
                }
            }
            maxConferenceRoomCount= Math.max(count,maxConferenceRoomCount);
        }

        return maxConferenceRoomCount;
    }


    static int minimumConferenceRoomRequired2(int[][]  intervals)
    {
        int[] startTime=new int[intervals.length];
        int[] endTime=new int[intervals.length];

        for(int i=0;i<intervals.length;i++)
        {
            startTime[i]=intervals[i][0];
            endTime[i]=intervals[i][1];
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);


        int sIndex=0,eIndex=0;
        int maxRoom=0;
        int room=0;

        while (sIndex<startTime.length)
        {

            if(startTime[sIndex]<=endTime[eIndex])
            {
                room++;
                maxRoom=Math.max(room,maxRoom);
                sIndex++;
            }
            else {
                room--;
                eIndex++;
            }

        }
        return maxRoom;
    }

    static public int minMeetingRooms(int[][] intervals) {

        //create list of start and end timings, both sorted in ascending order
        List<Integer> startTimings = new ArrayList<>();
        List<Integer> endTimings = new ArrayList<>();

        for(int i=0; i<intervals.length; i++){
            startTimings.add(intervals[i][0]);
            endTimings.add(intervals[i][1]);
        }

        Collections.sort(startTimings);
        Collections.sort(endTimings);

        //current number of rooms
        int rooms = 0;

        //track max rooms
        int maxRooms=1;

        //i -> start timings
        //j -> end timings
        int i=0, j=0;

        //check all meetings using start timing
        while(i<startTimings.size()){

            //if meeting needs to start before current end
            if(startTimings.get(i) < endTimings.get(j)){

                //we need +1 room
                rooms++;

                //move to next start
                i++;

                //meeting has ended, so reduce rooms by 1
            }else{
                rooms--;
                j++;
            }

            //update max
            maxRooms = Math.max(maxRooms, rooms);

        }

        return maxRooms;

    }

    public static void main(String[] args) {

        /*
        You are given an array of meeting time intervals intervals where intervals[i] = [start_i, end_i],
        representing the start and end times of the ith meeting in a 24-hour format (only hours, no minutes).
         Determine the minimum number of conference rooms required.
 Input: intervals = [[0, 1], [1, 2], [2, 3]]
 Output: 1
 Input: intervals = [[7, 10],[6,8], [2, 4]]
 Output: 2
 Input: intervals = [[9, 10], [9, 11], [10, 11], [10, 12]]
 Output: 3
 Input: intervals = [[8, 9], [8, 10], [9, 10], [9, 11], [10, 11]]
 Output: 3
         */

        System.out.println(minimumConferenceRoomRequired2(new int[][]{{0, 1}, {1, 2}, {2, 3}}));
        System.out.println(minimumConferenceRoomRequired2(new int[][]{{7, 10}, {6, 8}, {2, 4}}));
        System.out.println(minimumConferenceRoomRequired2(new int[][]{{9, 10}, {9, 11}, {10, 11},{10,12}}));
        System.out.println(minimumConferenceRoomRequired2(new int[][]{{8, 9}, {8, 10}, {9, 11},{10,11}}));



    }
}
