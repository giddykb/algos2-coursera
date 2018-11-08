package com.peace.arrays;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
    // TODO Auto-generated method stub

		char a1 [] = {'A', 'B', 'C', 'D' ,'E'};
		char a2 [] = {'F', 'G'};
		int k = 4;
		//When a1 and a2 lengths differ making sure that a1 always holds the bigger length array
		if(a1.length<a2.length){
			char []temp =a1;
			a1=a2;
			a2=temp;
		}
		char res []= solution(a1, a2, k);
		
		System.out.println(Arrays.toString(res));
	}

	public static char [] solution(char A1[],char A2[],int k){
		
		if(A1==null && A2 ==null) return null;
		if(A1==null)return A2;
		if(A2==null) return A1;
		
		
		int len1 = A1.length;
		int len2 = A2.length;
		int i,j;
		int leftPointerA1,rightPointerA1;
		int leftPointerA2,rightPointerA2;
		leftPointerA1 = 0;
		rightPointerA1 =k;
		rightPointerA2 = len2;
		leftPointerA2=len2-k<0?0:len2-k;
		
		char res [] = new char[len1+len2];
		int resL=0;
		while(leftPointerA1<len1 && leftPointerA2>=0){
			i=leftPointerA1;
			j=leftPointerA2;
			while(i<rightPointerA1){
					res[resL++]=A1[i++];
			}
			while(j<rightPointerA2){
				res[resL++]=A2[j++];
			}
			leftPointerA1= rightPointerA1;
			rightPointerA1 = rightPointerA1+k<len1?rightPointerA1+k :len1;
			rightPointerA2 = leftPointerA2;
			leftPointerA2 = leftPointerA2-k<0?0:leftPointerA2-k;
		}
		
		
	
		
		
		return res;
	}
	
	
}