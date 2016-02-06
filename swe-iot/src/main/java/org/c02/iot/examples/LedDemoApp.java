package org.c02.iot.examples;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

public class LedDemoApp {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);
	
	public static void main(String[] args) throws IOException, InterruptedException
	{
		InternetButtonApi button = new InternetButtonImpl(api);
		button.setLed(1, Color.GREEN);
		button.setLed(2, Color.GREEN);
		button.setLed(3, Color.GREEN);
		button.setLed(4, Color.GREEN);
		button.setLed(5, Color.GREEN);
		button.setLed(6, Color.GREEN);
		button.setLed(7, Color.GREEN);
		button.setLed(8, Color.GREEN);
		button.setLed(9, Color.GREEN);
		button.setLed(10, Color.GREEN);
		button.setLed(11, Color.GREEN);
		
		button.setLed(1, Color.RED);
		button.setLed(3, Color.RED);
		button.setLed(5, Color.RED);
		button.setLed(7, Color.RED);
		button.setLed(9, Color.RED);
		button.setLed(11, Color.RED);
		
		button.setLed(2, Color.WHITE);
		button.setLed(4, Color.WHITE);
		button.setLed(6, Color.WHITE);
		button.setLed(8, Color.WHITE);
		button.setLed(10, Color.WHITE);
		
		int ledNumber = 1;
		for (int i = 1; i<=55; i++)
		{
			button.setLed(1, Color.WHITE);
			button.setLed(2, Color.WHITE);
			button.setLed(3, Color.WHITE);
			button.setLed(4, Color.WHITE);
			button.setLed(5, Color.WHITE);
			button.setLed(6, Color.WHITE);
			button.setLed(7, Color.WHITE);
			button.setLed(8, Color.WHITE);
			button.setLed(9, Color.WHITE);
			button.setLed(10, Color.WHITE);
			button.setLed(11, Color.WHITE);
			
			button.setLed(ledNumber, Color.BLACK);
			
			Thread.sleep(500);
			
			if (ledNumber == 11)
				ledNumber = 1;
			else
				ledNumber++;
		}
		
		button.allLedsOff();
	}

}