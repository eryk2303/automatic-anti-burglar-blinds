import serial
ser = serial.Serial('/dev/ttyUSB0')       
ser.write(b'1')     
ser.close()  