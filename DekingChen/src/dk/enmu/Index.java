/**
 * 
 */
package dk.enmu;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class Index extends Show{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	 show(State.Update.getName());
	 show(State.Update.getIndex());	
	 State.Update.showMsg();
	 show(ColorEnum.blue);
	}

}
