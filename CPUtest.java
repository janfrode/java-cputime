import java.util.*;
import java.io.*;
import java.lang.*;


class CPUtest {
	public static  native long cpuCount();
	static {
		System.loadLibrary("jnicputime");
	}
	public static void main(String[] args) {
		long cputime;
		int i,j;
		cputime = cpuCount();
		System.out.println("Calculating Euler's number e raised to the power of a double value a few times.");
		for (i=0;i<50000000;i++) {
			double y;
			j = i*i; 
			y = Math.exp(j);
		}
		cputime = cpuCount() - cputime;
		System.out.print("That took " + cputime + " seconds of cputime\n");
	}
}
