#include "main.h"


uint8_t set_position;
uint8_t position;
uint8_t control;
int dir;
int count_position = 0;
int auto_down;
int auto_up;

void move_motor();

void new_data(uint8_t new);

void home_up();

void home_down();


void auto_fotodetector(uint8_t auto_foto);
