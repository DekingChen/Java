/**
 * 
 */
package dk.main;

import dk.lib.MyException;

/**
 * @author Administrator
 *
 */
public class Index04 extends Show {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		show("start...");
		try{
			throw new MyException("�Զ����쳣��");
		}catch(MyException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			show("ok");
		}
		show("end");
		
		
	}

}
