package chegg;

//A Java program to implement SSTF disk scheduling algorithm

//program creater

//program complete date

import java.util.Arrays;

class node {

//"distance" is the difference(distance) between the head position and the target track number

//(a target track means that the track has a request on)

//"accessed" is true if a request on the current track

//(a current track means that the head is on the track now)

int distance = 0;

boolean accessed = false;

}


public class SSTF {

//"calculateDifference" calculates the difference (distance) between each target track number and the head position and saves the difference (distance) in each element of "diff[]"

//"queue[]" includes track numbers with requests on

//"head" is the head position (the current track number)

public static void calculateDifference(int queue[], int head, node diff[]){

//please complete this part
	for(int i=0;i<diff.length;i++)
	{
		diff[i].distance=Math.abs(queue[i]-head);
	}

}

//"findMin" finds the index of the element with the minimum distance from the current track in the "diff[]"

public static int findMin(node diff[]){

int index = -1, minimum = Integer.MAX_VALUE;

for (int i = 0; i < diff.length; i++){

if (!diff[i].accessed && minimum > diff[i].distance){

//please complete this part
	minimum=diff[i].distance;
	index=i;
	

}

}

return index;

}

public static void shortestSeekTimeFirst(int request[], int head){

node diff[] = new node[request.length];

for (int i = 0; i < diff.length; i++)

diff[i] = new node();

//"seek_count" is the total seeking distance

int seek_count = 0;

//"seek_sequence" stores the seeking sequence

int[] seek_sequence = new int[request.length + 1];

for (int i = 0; i < request.length; i++) {

//Complete the following part
	seek_sequence[i]=head;
	calculateDifference(request, head, diff);
	int index=findMin(diff);
	diff[index].accessed=true;
	seek_count=seek_count+diff[index].distance; //calculate total count
	head=request[index];//accessed track is new head now

}

//for the last accessed track

seek_sequence[seek_sequence.length - 1] = head;

System.out.println("Total seeking distance is " + seek_count);

System.out.println("The seeking sequence (include the original head position) is "+ Arrays.toString(seek_sequence));

}

public static void main(String[] args){

//request array

int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114 };

//set the current head position as "50"

shortestSeekTimeFirst(arr, 50);

}

}
