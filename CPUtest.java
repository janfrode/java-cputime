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
				for (i=0;i<300000000;i++) j = i*7; 
				cputime = cpuCount() - cputime;
				System.out.print("CPUTIME:\t");
				System.out.println(cputime);
				cputime = cpuCount();
				for (i=0;i<300000000;i++) j = i*7; 
				cputime = cpuCount() - cputime;
				System.out.print("CPUTIME:\t");
				System.out.println(cputime);

             }
         }
