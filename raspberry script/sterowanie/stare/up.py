import serial
ser = serial.Serial ("/dev/ttyS0", 9600)      
ser.write("1")     
ser.close()  