package dk.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * 牌表操作类
 */
public class CardList {
	public static List<Card> cardlist = new ArrayList<Card>(52);//储存扑克牌
	public static List<ArrayList<Card>> poker;//储存发牌结果
	
	//生成一副牌
	public static void generateCard() {
		for(int i=1;i<=13;i++){
			for(int j=1;j<=4;j++){
				Card c = new Card(i,j);
				cardlist.add(c);
			}
		}
		
	}
	
	//打印一副牌
	public static void printCardList(){
		System.out.print("[");
		for(Card c:cardlist){
			System.out.print(c.toString()+"  ");
		}
		System.out.println("]");
	}
	
	//洗牌
	public static void shuffleCard(){
		List<Card> scard = new ArrayList<Card>(52);
		Card c;
		Random random = new Random();
		for(int i=1;i<=52;i++){
			
			do{
				 c = cardlist.get(random.nextInt(52));
			}while(scard.contains(c));
			scard.add(c);
		}
		cardlist.clear();
		cardlist = scard;
		printCardList();
	}
	
	
	/**
	 * 发牌
	 * @param i number of player
	 * @param j number of card
	 * @return
	 */
	public static List<ArrayList<Card>> dealCard(int i,int j){ 
		try{
			if(i<=1){
				throw new Exception("发牌规则有误：玩家至少为2人，请重新定义规则！");
			}
			if(i*j>52){
				throw new Exception("发牌规则有误：牌数超出扑克张数，请重新定义规则！");
			}
			
			poker = new ArrayList<ArrayList<Card>>(i);//储存玩家发到的牌
			
			//生成玩家手中的牌列表
			for(int h=0;h<i;h++){
				ArrayList<Card> player_card_list = new ArrayList<Card>(j);
				poker.add(player_card_list);
				
			}
			//给每个玩家发牌
			for(int k=0;k<j;k++){
				for(int d=0;d<i;d++){
					ArrayList<Card> player_card_list = poker.get(d);
					Card card = getCard();					
					player_card_list.add(card);
				}
			}
					
		}catch(Exception e){
			e.printStackTrace();
		}
		return poker;
	}
	
	//抓取一张牌
	public static Card getCard(){
		return cardlist.remove(0);
	}
	
	
	//获取一位玩家的牌
	public static ArrayList<Card> getPoker(){
		return poker.remove(0);
	}
	
	public static void clear(){
		cardlist.clear();
		poker.clear();
		printCardList();
		
	}
	
	
}
