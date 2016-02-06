package org.c02.iot.examples;

import java.awt.Color;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

public class LedSetAllColorsByAcceleration {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);
	
	public static void main(String[] args) throws InterruptedException
	{

		InternetButtonApi button = new InternetButtonImpl(api);
		button.allLedsOff();
		
		int xValue = 0;
		int yValue = 0;
		int zValue = 0;
		
		while (true)
		{
			xValue = button.getXVal();
			yValue = button.getYVal();
			zValue = button.getZVal();
			
			// XYZ-Werte zwischen -128 und 127
			// Keine negativen XYZ-Werte			
			Color color  = new Color(xValue+128, yValue+128, zValue+128);
			button.setLed(1, color);
		}
	}
}
