package dk.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Administrator
 * �Ʊ������
 */
public class CardList {
	public static List<Card> cardlist = new ArrayList<Card>(52);//�����˿���
	public static List<ArrayList<Card>> poker;//���淢�ƽ��
	
	//����һ����
	public static void generateCard() {
		for(int i=1;i<=13;i++){
			for(int j=1;j<=4;j++){
				Card c = new Card(i,j);
				cardlist.add(c);
			}
		}
		
	}
	
	//��ӡһ����
	public static void printCardList(){
		System.out.print("[");
		for(Card c:cardlist){
			System.out.print(c.toString()+"  ");
		}
		System.out.println("]");
	}
	
	//ϴ��
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
	 * ����
	 * @param i number of player
	 * @param j number of card
	 * @return
	 */
	public static List<ArrayList<Card>> dealCard(int i,int j){ 
		try{
			if(i<=1){
				throw new Exception("���ƹ��������������Ϊ2�ˣ������¶������");
			}
			if(i*j>52){
				throw new Exception("���ƹ����������������˿������������¶������");
			}
			
			poker = new ArrayList<ArrayList<Card>>(i);//������ҷ�������
			
			//����������е����б�
			for(int h=0;h<i;h++){
				ArrayList<Card> player_card_list = new ArrayList<Card>(j);
				poker.add(player_card_list);
				
			}
			//��ÿ����ҷ���
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
	
	//ץȡһ����
	public static Card getCard(){
		return cardlist.remove(0);
	}
	
	
	//��ȡһλ��ҵ���
	public static ArrayList<Card> getPoker(){
		return poker.remove(0);
	}
	
	public static void clear(){
		cardlist.clear();
		poker.clear();
		printCardList();
		
	}
	
	
}
