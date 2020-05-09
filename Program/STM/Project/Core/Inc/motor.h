/**
  ******************************************************************************
  * File Name          : motor.h
  * Description        : This file provides code for the configuration
  *                     of the motor
  ******************************************************************************
  */

/* Includes ------------------------------------------------------------------*/




#include "main.h"


/**
 * value for setting position
 */
uint8_t set_position;

/**
 * actual position
 */
uint8_t position;
/**
 * value to chosse auto mode
 */
uint8_t control;

int dir;
/**
 * helper variable to include the number of steps in one iteration
 */
int count_position = 0;
/**
 * motor can go down in auto mode
 */
int auto_down;
/**
 * motor can go up in auto mode
 */
int auto_up;
/**
 * work permit
 */
uint8_t admin = 1;

/**
 * function that sends commands to the engine
 */
void move_motor();

/**
 * function to execution comand from uart
 */
void new_data(uint8_t new);

/**
 * homeing up blind function
 */
void home_up();
/**
 * homeing down blind function
 */
void home_down();

/**
 * function to execution comand from fotodetector
 */
void auto_fotodetector(uint8_t auto_foto);

/**
 * work permit
 */
void admin_pc(uint8_t able);
