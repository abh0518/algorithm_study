import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * http://algospot.com/judge/problem/read/LUNCHBOX
 * 
 * 전략
 * 1. 이상적인 최적의 점심시간은 Sum(microwaveTimes) + Min(eatTimes)
 * 2. 제일 처음에 가장 최적인 어떤 a를 선택해서 제일 앞에 배치하였고 나머진 n-1개가 남았을 때,
 *    해당 n-1개라는 상황에서 가장 최적의 선택을 하는 것이 답을 찾는 길이다. (a는 n-1개의 상황에 영향을 주지 않음). 
 * 3. Sum(microwaveTimes)은 줄일 수가 없지만,
 *    Min(eatTimes)은 eatTime이 오래 걸리는 것을 앞에 배치는 방법으로 줄일 수 있다.
 * 4. 식사시간이 같다면, microwaveTime이 작은 것을 앞에 배치한다.
 * 
 * @author laeyoung
 */
public class Main {

	public static void main(String args[]) throws FileNotFoundException {
		Main main = new Main();
		
		Scanner sc = new Scanner(new File("input.txt"));
//		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			List<Participant> participants = new ArrayList<Main.Participant>();
			List<Integer> microwaveTimeList = new ArrayList<Integer>();
			List<Integer> eatTimeList = new ArrayList<Integer>();
			
			int numParticipant = sc.nextInt();
			for (int i = 0; i < numParticipant; i++) {
				microwaveTimeList.add(sc.nextInt());
			}
			for (int i = 0; i < numParticipant; i++) {
				eatTimeList.add(sc.nextInt());
			}
			
			for (int i = 0; i < numParticipant; i++) {
				participants.add(main.new Participant(microwaveTimeList.get(i), eatTimeList.get(i)));
			}
			
			Collections.sort(participants);
			int minLunchTime = findMinLunchTime(participants, 0);
			System.out.println(minLunchTime);
		}
		
		sc.close();
	}
	
	public static int findMinLunchTime(List<Participant> participants, int index) {
		Participant target = participants.get(index);
		
		if (participants.size()-1 == index) {
			return target.getMicrowaveTime() + target.getEatTime(); 
		}
		
		int targetSum = target.getMicrowaveTime() + target.getEatTime();
		int subMinLunchTime = target.getMicrowaveTime() + findMinLunchTime(participants, index+1);
		
		return Math.max(targetSum, subMinLunchTime);
	}
	
	public class Participant implements Comparable<Participant>{
		private int microwaveTime;
		private int eatTime;
		
		public Participant(int microwaveTime, int eatTime) {
			this.microwaveTime = microwaveTime;
			this.eatTime = eatTime;
		}
		
		public int getMicrowaveTime() {
			return microwaveTime;
		}
		
		public int getEatTime() {
			return eatTime;
		}
		
		public int getSumOfTime() {
			return microwaveTime + eatTime;
		}

		@Override
		public int compareTo(Participant p) {
			if (eatTime > p.getEatTime()) {
				return -1;
			} else if (eatTime == p.getEatTime()) {
				if (microwaveTime >= p.getEatTime()) {
					return -1;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
}