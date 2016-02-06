package org.c02.iot;

import java.awt.Color;
import java.io.IOException;

import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleException;

public class InternetButtonImpl implements InternetButtonApi {

	ParticleApiWrapper wrapper;

	public InternetButtonImpl(ParticleApiWrapper wrapperInstance) {
		wrapper = wrapperInstance;
	}

	public int getButtonCounter(ButtonDirection button) {
		String variable = String.format("countButton%d", (button.ordinal()+1));
		try {
			return wrapper.readVariable(variable);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			e.printStackTrace();
		}
	}

	public void allLedsOff() {
		try {
			wrapper.callMethod("ledsOff",null);
		} catch (ParticleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void playSound()
	{
		try {
			wrapper.callMethod("play", null);
		} catch (ParticleException e) {
			e.printStackTrace();
		}
		
	}

	public void resetButtonCounters() {
		try {
			wrapper.callMethod("reset",null);
		} catch (ParticleException e) {
			e.printStackTrace();
		}
	}
	
	public int getXVal()
	{
		try {
			return wrapper.readVariable("xValue");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int getYVal()
	{
		try {
			return wrapper.readVariable("yValue");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	public int getZVal()
	{
		try {
			return wrapper.readVariable("zValue");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
