package dk.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Administrator
 * ��������б�
 */
public class PlayerList {
	
	public static List<Player> playerlist = new ArrayList<Player>();//����������б�
	public static int sum;
	public static List<String> rules = new ArrayList<String>();
	public PlayerList(){
		
	}
	
	public static void setRule(String rule){
		rules.add(rule);
	}
	
	public static String getRules(){
		String str="";
		for(String s:rules){
			str+=s+"\t\n";
		}
		return str;
	}
	
	public static void printRules(){
		show(getRules());
	}
	
	//������
	public static boolean addplayer(Player player){
		show("�����ң�"+player.toString());
		show("----------------------------------------");
		sum++;
		return playerlist.add(player);
	}
	
	//��������ҷ���
	public static void shuffleCardToPlayer(){
			for(Player player:playerlist){
				player.setPoker(CardList.getPoker());
			}
	}
	//���Ҫ��һ����
	public static boolean  getOneCard(int i){
		Player p = playerlist.get(i);
		return p.getPoker().add(CardList.getCard());
	}
	
	//��ʾ���ƽ��
	public static void showCard(){
		for(Player player:playerlist){
			show(player.showCard());
			show("----------------------------------------");
		}
	}
	
	//�Ƚ��Ƶ��С������ʾӮ����Ϣ
	public static void showWinner(){
		Collections.sort(playerlist,new RuleOfComparateCard());
		Player p = playerlist.get(0);
		show(p.showCard());
		show("����Ӯ���ǣ�"+p.getName());
	}
	//�Ƚ�21��Ĵ�С
	public static void showWinnerOf21(){
		Collections.sort(playerlist,new RuleOf21());
		Player p = playerlist.get(0);
		show(p.showCard());
		show("����Ӯ���ǣ�"+p.getName());
	}
	
	//�������
	public static int size(){
		return sum;
	}
	
	public static void show(Object obj){
		System.out.println(obj.toString());
	}
	
	public static void clear(){
		playerlist.clear();
		sum = 0 ;
	}
	
	
}
