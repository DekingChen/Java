/**
 * 
 */
package dk.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * 玩家类
 */
public class Player implements Comparable<Player>{
	private String id;//玩家id
	private String name;//玩家姓名
	private List<Card> poker;//玩家手牌
	private Card max;//玩家最大的牌
	public Player(String id ,String name){
		this.id = id;
		this.name = name;
		this.setPoker(new ArrayList<Card>());
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Card> getPoker() {
		return poker;
	}
	
	public Card getMax() {
		return max;
	}
	public void setMax(Card max) {
		this.max = max;
	}
	public void setPoker(List<Card> poker) {
		this.poker = poker;
		Collections.sort(this.poker);
		for(Card c :this.poker){
			this.setMax(c);
			break;
		}
	}
	public String toString(){
		return "玩家Id："+this.id+"\t玩家姓名："+this.name;
	}
	
	//玩家摊牌
	public String showCard(){
		String msg="";
		for(Card c:this.poker){
			msg+=c.toString()+" ";
		}
		return this.toString()+"\t\n"+"玩家牌信息：\t\n"+msg;
	}
	@Override
	public int compareTo(Player o) {
		return this.max.compareTo(o.getMax());
	}
	
	
}
