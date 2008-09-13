

all:	libjnicputime.so

clean:	
	rm -f CPUtest.class CPUtest.h libjnicputime.so

CPUtest.class:	CPUtest.java
	javac CPUtest.java

CPUtest.h:	CPUtest.class
	javah -jni CPUtest

libjnicputime.so:	CPUtest.h cputime.c
	cc -o libjnicputime.so -O -shared cputime.c 

test:	libjnicputime.so
	@LD_LIBRARY_PATH=. java CPUtest
