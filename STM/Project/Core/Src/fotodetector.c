
/**
  ******************************************************************************
  * File Name          : fotodetector.c
  * Description        : This file provides code for the configuration
  *                      of the fotodetector.
  ******************************************************************************

  */

#include "fotodetector.h"


uint8_t get_value_fotodetector()
{
		HAL_ADC_Start(&hadc);
		HAL_ADC_PollForConversion(&hadc, HAL_MAX_DELAY);
		fotodetector_value = HAL_ADC_GetValue(&hadc);

		 return fotodetector_value;

}
