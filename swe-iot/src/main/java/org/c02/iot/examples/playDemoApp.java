package org.c02.iot.examples;


import org.c02.iot.InternetButtonApi;
import org.c02.iot.InternetButtonImpl;
import org.c02.iot.cloud.api.ParticleApiWrapper;
import org.c02.iot.cloud.api.ParticleApiWrapperImpl;
import org.c02.iot.cloud.examples.DemoConstants;

public class playDemoApp {
	
	static ParticleApiWrapper api = new ParticleApiWrapperImpl(DemoConstants.deviceId,
			DemoConstants.accessToken);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InternetButtonApi button = new InternetButtonImpl(api);
		
		button.playSound();

	}

}
