package com.peace.arrays;

public class MedianTwoArrays {
	

	private static class SubArray {
		private int [] underlying;
		private int start;
		private int size;
		
		private static SubArray fromArray(int [] a) {
			SubArray s = new SubArray();
			s.underlying = a;
			s.size = a.length;
			s.start = 0 ;
			return s;
		}
		
		private SubArray toArray(int i , int j) {
			if(i > j ) throw new IllegalArgumentException();
			if (j > this.size ) throw new IndexOutOfBoundsException();
			SubArray s = new SubArray();
			s.underlying = this.underlying;
			s.start = this.start + i;
			s.size = j - i;
			return s;
		}
	}
}
