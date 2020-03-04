#include "motor.h"



void HAL_GPIO_EXTI_Callback(uint16_t GPIO_Pin)
{
	if(GPIO_Pin == END_DOWN_Pin)
	{

		set_position = position = 0;
		set_position = set_position + 5;

	}
	if(GPIO_Pin == END_HIGH_Pin)
		{
			set_position = position = 255;
			set_position = set_position - 5;
		}
}

void new_data(uint8_t new)
{
	if(new == '1')
	{
		set_position += 5;
		control = 0;
	}
	else if(new == '2')
	{
		set_position += 5;
		control = 1;
	}
	else if(new == '3')
		{
			set_position -= 5;
			control = 0;
		}
	else if(new == '4')
		{
			set_position -= 5;
			control = 1;
		}
	else if(new == '5')
		{
			home_up();
			control = 0;
		}
	else if(new == '6')
		{
			home_up();
			control = 1;
		}
	else if(new == '7')
		{
			home_down();
			control = 0;
		}
	else if(new == '8')
		{
			home_down();
			control = 1;
		}
}




void move_motor()
{
	if(set_position > position)
	{
		HAL_GPIO_WritePin(DIR_GPIO_Port, DIR_Pin, GPIO_PIN_SET);
		HAL_Delay(100);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_SET);
		HAL_Delay(100);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_RESET);
		HAL_Delay(100);
		++position;
	}
	else if(set_position < position)
	{
		HAL_GPIO_WritePin(DIR_GPIO_Port, DIR_Pin, GPIO_PIN_RESET);
		HAL_Delay(100);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_SET);
		HAL_Delay(100);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_RESET);
		HAL_Delay(100);
		--position;
	}

}



void home_up()
{

}



void home_down()
{

}


