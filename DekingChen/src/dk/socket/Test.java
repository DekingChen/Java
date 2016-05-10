/**
 * 
 */
package dk.socket;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class Test extends Show{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String serverName = args[0];
	      int port = Integer.parseInt(args[1]);
	      show(serverName);
	      show(port);

	}

}
