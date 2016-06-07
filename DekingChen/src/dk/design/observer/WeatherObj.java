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
		//1.�Ƶ�ģʽ
		System.out.println("��ģ�ͣ�"+objName+"�յ�����Ϣ��Ŀ�����͹�������"+arg);
		//2.����ģʽ
		System.out.println("��ģ�ͣ�"+objName+"�յ�����Ϣ��������Ŀ�������ȥ��ȥ���ݣ���ȡ��������"+((Weather)o).getWeatherContents());
	}

}
