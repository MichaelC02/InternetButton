package org.c02.iot.examples;

import java.awt.Color;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

public class LedSetRed {

	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		InternetButtonApi button = new InternetButtonImpl(api);
		button.allLedsOff();
		button.resetButtonCounters();
		
		int count = 0;
		while (true)
		{
			count = button.getButtonCounter(ButtonDirection.North);
			int red = (count*10)%255;
			String rgb = String.format("%03d000000", red);
			button.setLed(1, Color.decode(rgb));
			Thread.sleep(100);
			
		}

		
	}

}
