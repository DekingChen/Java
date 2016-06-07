package dk.design.observer;

import java.util.Observable;
import java.util.Observer;

public class WeatherObj implements Observer {

	private String objName;
	
	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	@Override
	public void update(Observable o, Object arg) {
		//1.推的模式
		System.out.println("推模型："+objName+"收到了消息，目标推送过来的是"+arg);
		//2.拉的模式
		System.out.println("拉模型："+objName+"收到了消息，主动到目标对象中去拉去数据，拉取的内容是"+((Weather)o).getWeatherContents());
	}

}
