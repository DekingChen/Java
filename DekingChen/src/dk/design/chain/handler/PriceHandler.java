/**
 * 
 */
package dk.design.chain.handler;

/**
 * @author Administrator
 *
 */
public abstract class PriceHandler {
	protected PriceHandler successor;

	public PriceHandler getSuccessor() {
		return successor;
	}

	public void setSuccessor(PriceHandler successor) {
		this.successor = successor;
	}
	public abstract void processDiscount(float discount);
}
