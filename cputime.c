/*
	cc -o libjnicputime.so -O -shared cputime.c -I/usr/java/include/
	-I/usr/java/include/irix
*/
/* Feature test switches */
#define _POSIX_SOURCE 1

/* System headers */
#include <sys/times.h>
#include <unistd.h>

/* Local headers */
#include "CPUtest.h"

/* Macros */
#define CLK_TCK ((clock_t)(sysconf(_SC_CLK_TCK)))

/* Functions */

JNIEXPORT jlong JNICALL Java_CPUtest_cpuCount (JNIEnv *env, jobject obj)
{
	struct tms tmsbuff;
	times(&tmsbuff);
	return (jlong)tmsbuff.tms_utime/CLK_TCK;
}
