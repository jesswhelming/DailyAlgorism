package com.codingTest.string;

public class String_charAt_01 {
	public static void main(String[] args){
		String nums1 = "123";
		String nums2 = "888";
		
		String rtn = new String_charAt_01().slove(nums1, nums2);
		
		System.out.println(rtn);
	}

	private String slove(String nums1, String nums2) {
		int carry = 0;
		
		int num1Length = nums1.length() - 1;
		int num2Length = nums2.length() - 1;
		StringBuilder sb = new StringBuilder();
		
		while(num1Length >=0 || num2Length >=0){
			int n1=0, n2=0;
			if(num1Length >= 0)
				n1 = nums1.charAt(num1Length) - '0';
			if(num2Length >= 0)
				n2 = nums2.charAt(num2Length) - '0';
			int sum = n1 + n2 +carry;
			
			carry = sum/10;
			sb.append(sum%10);
			num1Length--;
			num2Length--;
			
		}
		if(carry != 0) sb.append(carry);
		return sb.reverse().toString();
	}

	
}
