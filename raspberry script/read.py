import serial
ser = serial.Serial('/dev/ttyUSB0')       
temperature = ser.read(2)
print(temperature)
ser.close()    