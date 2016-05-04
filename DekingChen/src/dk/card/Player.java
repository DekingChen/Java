/**
 * 
 */
package dk.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * �����
 */
public class Player implements Comparable<Player>{
	private String id;//���id
	private String name;//�������
	private List<Card> poker;//�������
	private Card max;//���������
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
		return "���Id��"+this.id+"\t���������"+this.name;
	}
	
	//���̯��
	public String showCard(){
		String msg="";
		for(Card c:this.poker){
			msg+=c.toString()+" ";
		}
		return this.toString()+"\t\n"+"�������Ϣ��\t\n"+msg;
	}
	@Override
	public int compareTo(Player o) {
		return this.max.compareTo(o.getMax());
	}
	
	
}
