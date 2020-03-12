import serial
ser = serial.Serial('/dev/ttyUSB0')       
ser.write(b'4')     
ser.close()  