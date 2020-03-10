#include "motor.h"



void HAL_GPIO_EXTI_Callback(uint16_t GPIO_Pin)
{
	if(GPIO_Pin == END_DOWN_Pin)
	{

		set_position = position = 0;
		set_position = set_position + 5;
		auto_down = 1;
		auto_up = 0;

	}
	if(GPIO_Pin == END_HIGH_Pin)
		{
			set_position = position = 255;
			set_position = set_position - 5;
			auto_down = 0;
			auto_up = 1;
		}
}

void new_data(uint8_t new)
{
	set_position = position = 100;
	if(new == '1')
	{
		set_position += 5;

	}
	else if(new == '2')
	{
		set_position -= 5;

	}
	else if(new == '3')
		{
			home_up();

		}
	else if(new == '4')
		{
			home_down();

		}
	else if(new == '6')
		{

			control = 0;
		}
	else if(new == '5')
		{

			control = 1;
		}
}




void move_motor()
{

	if(set_position > position)
	{

		HAL_GPIO_WritePin(ENABLE_GPIO_Port, ENABLE_Pin, GPIO_PIN_RESET);
		HAL_GPIO_WritePin(DIR_GPIO_Port, DIR_Pin, GPIO_PIN_SET);
		HAL_Delay(1);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_SET);
		HAL_Delay(1);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_RESET);
		HAL_Delay(1);
		++count_position;
		if(count_position == 20)
		{
			++position;
			count_position = 0;
		}

	}

	 else if(set_position < position)
	{

		HAL_GPIO_WritePin(ENABLE_GPIO_Port, ENABLE_Pin, GPIO_PIN_RESET);
		HAL_GPIO_WritePin(DIR_GPIO_Port, DIR_Pin, GPIO_PIN_RESET);
		HAL_Delay(1);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_SET);
		HAL_Delay(1);
		HAL_GPIO_WritePin(STEP_GPIO_Port, STEP_Pin, GPIO_PIN_RESET);
		HAL_Delay(1);
		++count_position;
		if(count_position == 20)
		{
			--position;
			count_position = 0;

		}
	}
	else
	{
		HAL_GPIO_WritePin(ENABLE_GPIO_Port, ENABLE_Pin, GPIO_PIN_SET);
	}

}


void home_up()
{
	set_position = position = 0;
	set_position += 255;
}



void home_down()
{
	set_position = position = 255;
	set_position -= 255;
}

void auto_fotodetector(uint8_t auto_foto)
{

	if(control == 1)
	{
		if(auto_down == 0)
		{
			if(auto_foto < 190)
			{
				home_down();
			}
		}
		if(auto_up == 0)
		{
			if(auto_foto > 220)
			{
					home_up();
			}
		}
	}
}
