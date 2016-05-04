/**
 * 
 */
package dk.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import dk.card.Card;
import dk.card.CardList;
import dk.card.Player;
import dk.card.PlayerList;
import dk.card.RuleOf21;

/**
 * @author Administrator
 *
 */
public class Index05 extends Show {
	
	public static Scanner scanner = new Scanner(System.in);
	
	/**
	 * ���õ�������
	 * @param args
	 */
	public static void main(String[] args) {
		
		show("�Ƿ�ʼ��Ϸ?0/1");
		int isStart = scanner.nextInt();
		if(isStart==1){
			show("��ѡ����Ϸ?0���˿��ƱȽϴ�С��Ϸ/1:21����Ϸ");
			int gameType = scanner.nextInt();
			switch(gameType){
			case 0:startGame();break;
			case 1:startGameOf21();	break;
			default:
				show("��Ϸ�����ڣ�����");
				break;
			}
			
		}	
		else{
			show("�˳���Ϸ��");
		}
		
		
	}
	
	//����21����Ϸ
	public static void startGameOf21(){	
		show("��ʮһ�����Ϸ�ȽϵĻ�������:");
		PlayerList.setRule("1.������ĸ���ֻ�������ƣ�A+X(A,10,J,Q,K)������");
		PlayerList.setRule("2.�������Ƶĵ����������͵���21����󣬳���21�����С���Դ�����21>20>....1>22>23...50����ȥ1�е����������������1�е���ϣ��������1������ı��������ķ����󣬼�ʹ�Է���21�㡿");
		PlayerList.setRule("3.�����2������£��������ܵ�����������������5���Ƶ���ұȲ���5�����Ƶ���Ҵ�");
		PlayerList.setRule("4.�ܵ�����ֻ��52�ţ�û�д�С��");
		PlayerList.setRule("4.��A���Ե�����1����11���á�");
		PlayerList.setRule("5.���ĸ��������������Ϊ5�š�");
		PlayerList.printRules();
			int players = 3;//Ĭ�������Ŀ
			int cardofplay = 2;//Ĭ��ÿ����ҵ�������Ŀ
			try {
					show("��ʼ���������Ϣ:");
					for(int i=0;i<players;i++){
						show("�������"+(i+1)+"���������:");
						String name = scanner.next();
						Player p =new Player("00"+i,name);
						PlayerList.addplayer(p);
					}
					show("һ��û��ϴ���ƣ�");
					CardList.generateCard();//����һ���˿�
					CardList.printCardList();//��ӡ�˿�
					show("========================================");
					show("��ʼϴ�ƣ�........ϴ����......ϴ�����");
					CardList.shuffleCard();//ϴ��
					show("========================================");
					show("��ʼ���ƣ�........������......�������");					
					CardList.dealCard(players,cardofplay);//����
					PlayerList.shuffleCardToPlayer();//����ҷ���
					for(int i=0;i<players;i++){
						Player player = PlayerList.playerlist.get(i);
						show("��"+(i+1)+"��ҵķ��ƽ��:\t\n"+player.showCard());
						boolean isContinue = true;
						int count = 2;
						while(isContinue){
							show("�Ƿ�Ҫ��?0/1");
							int isGo = scanner.nextInt();
							if(isGo==1&&count<=4){
								count++;
								PlayerList.getOneCard(i);
								show("��"+(i+1)+"λ��ҵ�Ҫ�ƺ���:\t\n"+player.showCard());
							}else{
								isContinue=false;
							}
						}
						show("===============��"+(i+1)+"λ���Ҫ�ƽ���================");

					}
					show("========================================");
					show("Ҫ�ƽ�����");
					PlayerList.showCard();//��ʾ�����������Ϣ
					show("========================================");
					show("�ȽϽ��������ʾӮ����Ϣ");
					PlayerList.showWinnerOf21();//��ʾ����Ӯ��
					show("========================================");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
	//�����Ƚ��˿˴�С��Ϸ
	public static void startGame(){
		show("��Ϸ��������:");
		PlayerList.setRule("1.������Ҫ�������");
		PlayerList.setRule("2.������ҵ�����������������52����");
		PlayerList.setRule("3.�Ƚ�����������������Ƶ㣬�����Ƶ�������һ�ʤ");
		PlayerList.setRule("4.�ܵ�����ֻ��52�ţ�û�д�С��");
		PlayerList.setRule("5.������A��󣬷���3��С��������ͬʱ���Ƚϻ�ɫ�����ҽϴ�");
		PlayerList.printRules();
		show("���������������");
		int players = 2;//Ĭ�������Ŀ
		int cardofplay = 2;//Ĭ��ÿ����ҵ�������Ŀ
		try {
			 players = scanner.nextInt();
				while(players<2){
					show("�����������������");
					show("����������������");
					players = scanner.nextInt();
				}
			
				show("������ÿ����ҳ��е�������");	
				cardofplay = scanner.nextInt();
				while(cardofplay*players>52){
					show("���*����������Χ����������������");
					cardofplay = scanner.nextInt();
				}
				
				show("��ʼ���������Ϣ:");
				for(int i=0;i<players;i++){
					show("�������"+(i+1)+"���������:");
					String name = scanner.next();
					Player p =new Player("00"+i,name);
					PlayerList.addplayer(p);
				}
				show("һ��û��ϴ���ƣ�");
				CardList.generateCard();//����һ���˿�
				CardList.printCardList();//��ӡ�˿�
				show("========================================");
				show("��ʼϴ�ƣ�");
				CardList.shuffleCard();//ϴ��
				show("========================================");
				show("��ʼ���ƣ�........������......");
				CardList.dealCard(players,cardofplay);//����
				PlayerList.shuffleCardToPlayer();//����ҷ���
				show("���ƽ����");
				PlayerList.showCard();//��ʾ�����������Ϣ
				show("========================================");
				show("�ȽϽ�����Ƚ��Ƶ��С������ʾӮ����Ϣ");
				PlayerList.showWinner();//��ʾ����Ӯ��
				show("========================================");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	//�����Ϸ
	public static void clearGame(){
			CardList.clear();
			PlayerList.clear();
	}
	
	//���ԱȽ��˿���Ϸ
	public static void testGame(){
		try {
			show("һ��û��ϴ���ƣ�");
			CardList.generateCard();
			CardList.printCardList();
			show("========================================");
			show("��ʼ�����ң�");
			Player p =new Player("001","DekingChen");
			Player p1 =new Player("002","chenzhenquan");
			Player p2 =new Player("003","czq");
			PlayerList.addplayer(p);
			PlayerList.addplayer(p1);
			PlayerList.addplayer(p2);
			show("��ʼϴ�ƣ�");
			CardList.shuffleCard();
			show("========================================");
			show("��ʼ���ƣ�........������......");
			int players =  PlayerList.size();//�����Ŀ
			int cardofsum = 3;//ÿ����ҵ�������Ŀ
			CardList.dealCard(players,cardofsum);
			PlayerList.shuffleCardToPlayer();
			show("���ƽ����");
			PlayerList.showCard();
			show("========================================");
			show("�ȽϽ�����Ƚ��Ƶ��С������ʾӮ����Ϣ");
			PlayerList.showWinner();
			show("========================================");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//����21����Ϸ
 	public static void testGame21(){
		List<Player> playerlist = new ArrayList<Player>();//����������б�	
		List<Card> list = new ArrayList<Card>();
		List<Card> list01 = new ArrayList<Card>();
		List<Card> list02 = new ArrayList<Card>();
		//���1�Ƶ�
		Card c = new Card(8,1);
		Card cc =new Card(1,2);
		list.add(c);
		list.add(cc);
		//���2�Ƶ�
		Card a = new Card(4,1);
		Card aa = new Card(4,2);
		Card b = new Card(4,3);
		Card bb = new Card(4,4);
		Card bbb = new Card(5,4);
		list01.add(a);
		list01.add(aa);
		list01.add(b);
		list01.add(bb);
		list01.add(bbb);
		//���3�Ƶ�
				Card d = new Card(10,2);
				Card dd = new Card(1,3);
				list02.add(d);
				list02.add(dd);
		//�������
		Player p =new Player("001","DekingChen");
		Player p1 =new Player("002","chenzhenquan");
		Player p2 =new Player("003","czq");
		p.setPoker(list);
		p1.setPoker(list01);
		p2.setPoker(list02);
		playerlist.add(p);
		playerlist.add(p1);
		playerlist.add(p2);
		Collections.sort(playerlist,new RuleOf21());
		for(Player pp:playerlist){
			show(pp.showCard());
		}
	
	}
	
}
