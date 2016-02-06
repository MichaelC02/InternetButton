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
															 ((colorRGB & 0x0F00) >> 16),
															 ((colorRGB & 0x00F0) >> 8),
															 ((colorRGB & 0x000F)));
		try {
			wrapper.callMethod("led", parameter);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
	}

	public void allLedsOff() {
		// TODO Auto-generated method stub

	}

	public void playSound() {
		// TODO Auto-generated method stub

	}

	public void resetButtonCounters() {
		// TODO Auto-generated method stub
		
	}

}
