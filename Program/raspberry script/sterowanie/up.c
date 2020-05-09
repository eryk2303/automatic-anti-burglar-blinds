#include <stdio.h> 
#include <wiringPi.h> 
#include <wiringSerial.h> 
 
int main(int argc, char **argv) 
{ 
   
    char send = '1'; 
 
    
    int serial; 
 
   
    serial=serialOpen("/dev/ttyS0",9600); 

    serialPutchar(serial, send); 
 

    serialFlush(serial); 


    serialClose(serial); 
 

    return 0; 
}
