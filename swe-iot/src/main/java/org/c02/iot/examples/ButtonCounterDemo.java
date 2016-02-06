package org.c02.iot.examples;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.InternetButtonApi.ButtonDirection;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

public class ButtonCounterDemo
{
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);
	
	private static void SetLedCounter(InternetButtonApi btn, int counter)
	{
		btn.allLedsOff();
		
		for (int i=1;i<=counter;i++)
		{
			btn.setLed(i, Color.PINK);
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		InternetButtonApi button = new InternetButtonImpl(api);
		
		int count;
		
		count = button.getButtonCounter(ButtonDirection.North);
		SetLedCounter(button, count);
		
		count = button.getButtonCounter(ButtonDirection.South);
		SetLedCounter(button, count);
		
		count = button.getButtonCounter(ButtonDirection.East);
		SetLedCounter(button, count);
		
		count = button.getButtonCounter(ButtonDirection.West);
		SetLedCounter(button, count);
		
		button.resetButtonCounters();
	}
}
