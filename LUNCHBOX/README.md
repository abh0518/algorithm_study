# Microwaving Lunch Boxes (http://algospot.com/judge/problem/read/LUNCHBOX)

## 문제 정보

문제ID 시간제한 메모리제한 제출횟수 정답횟수 (비율)
LUNCHBOX 5000ms 65536kb 510 180 (35%)

출제자 출처 분류
Being Algospot 3주년 모의고사 보기

## 문제

After suffering from the deficit in summer camp, Ainu7 decided to supply lunch boxes instead of eating outside for Algospot.com winter camp.

He contacted the famous packed lunch company "Doosot" to prepare N lunch boxes for N participants. Due to the massive amount of order, Doosot was not able to prepare the same menu. Instead, they provided different N lunch boxes. Ainu7 put all the lunch boxes to a refrigerator.

The lunch time has come, and suddenly Ainu7 noticed that there is only one microwave available. As all lunch boxes are not the same, they need a different amount of time to microwave and eat. Specifically, i-th lunch box needs Mi seconds to microwave and Ei seconds to eat.

Ainu7 needs to schedule microwave usage order to minimize lunch time. Lunch time is defined as the duration from the beginning of microwaving of any lunch box to the end of eating for all participants. Write a computer program that finds minimum lunch time to help Ainu7. Note that substituting lunch while microwave is turned on is totally unnecessary, because the lunch will be cooled down.

## 입력

The first line of the input contains one integer T, the number of test cases.

Each test case consists of three lines. The first line of each test case contains N (1 <= N <= 10000), the number of the participants.

N integers will follow on the second line. They represent M1, M2, ..., MN.
Similarly, N integers will follow on the third line, representing E1, E2, ..., EN.

## 출력

For each test case, print the minimized lunch time in one line. It is guaranteed that the answer is always strictly less than 2^31.

## 예제 입력

<pre>
2
3
2 2 2
2 2 2
3
1 2 3
1 2 1
</pre>

## 예제 출력

<pre>
8
7
</pre>