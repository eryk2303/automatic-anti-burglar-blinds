import serial
# Open serial port
ser = serial.Serial('/dev/ttyUSB0')
# Send UART data
ser.write(b'1')
#close serial port
ser.close()  
