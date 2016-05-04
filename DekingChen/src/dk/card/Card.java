/**
 * 
 */
package dk.card;

/**
 * @author Administrator
 * 扑克类
 */
public class Card implements Comparable<Card>{
	private int number;//牌的点数--1到13
	private int type;//牌的花色--4种花色：♠(黑桃):4  ♥(红桃):3 ♣(梅花):2  方块:1
	
	public Card() {
		super();
	}
	public Card(int number, int type){
		if(number==1)
			number=14;
		this.number = number;
		this.type = type;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
		result = prime * result + type;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (number != other.number)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	@Override
	public int compareTo(Card o) {
		if(this.number>o.number)
			return -1;
		else if(this.number<o.number)
			return 1;
		else
			if(this.type>o.type)
				return -1;
			else if(this.type<o.type)
				return 1;
			
		return 0;
	}
	
	public String toString(){
		String str ="";
		switch(this.type){
		case 1: str = "方块";break;
		case 2: str = "梅花";break;
		case 3: str = "红桃";break;
		case 4: str = "黑桃";break;
		}
		String n="";
		switch(this.number){
		case 14:n="A";break;
		case 11:n="J";break;
		case 12:n="Q";break;
		case 13:n="K";break;
		default:n=this.number+"";
		}
		return str+n;
	}
	
	
}
