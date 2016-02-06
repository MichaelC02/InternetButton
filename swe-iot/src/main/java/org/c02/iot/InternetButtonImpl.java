package org.c02.iot;

import java.awt.Color;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonCounter(ButtonDirection button) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setLed(int postition, Color color) {
		int colorRGB = color.getRGB();
		
		String parameter = String.format("%02d%03d%03d%03d", postition,
															 ((colorRGB & 0x00FF0000) >> 16),
															 ((colorRGB & 0x0000FF00) >> 8),
															 ((colorRGB & 0x000000FF)));
		try {
			wrapper.callMethod("led", parameter);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	public void allLedsOff() {
		for(int i = 1; i <= 11; i++)
		{
			String parameter = String.format("%02d000000000", i);
			try {
				wrapper.callMethod("led", parameter);
			} catch (ParticleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub

	}

	public void playSound()
	{
		try {
			wrapper.callMethod("play", null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void resetButtonCounters() {
		// TODO Auto-generated method stub
		
	}

}
