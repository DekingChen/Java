package dk.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleOf21 implements Rule {

	
	

	@Override
	
	/* 二十一点的游戏比较的基本规则：
	 * 1.如果博弈各方只有两张牌：A+X(A,10,J,Q,K)组合最大，
	 * 2.所有手牌的点数加起来和等于21的最大，超过21点的最小，以此类推21>20>....1>22>23...50【除去1中的情况，即不存在有1中的组合，如果存在1中情况的比其他博弈方都大，即使对方是21点】
	 * 3.如果在2请情况下，当手牌总点数有相等情况，则有5张牌的玩家比不是5张手牌的玩家大
	 * 4.牌A可以当做点1、点11来用
	 * 5.博弈各方手上牌数最多为5张
	 */
	public int compare(Player o1,Player o2) {
		return compare21(o1.getPoker(),o2.getPoker());
	}
	
	public int compare21(List<Card>o1, List<Card>o2){
			if(this.getPoints(o1)>this.getPoints(o2))
				return -1;
			else if(this.getPoints(o1)<this.getPoints(o2))
				return 1;
			else 
				return 0;
	}
	
	//获取玩家手牌的点数--按照规则进行计算
	public int getPoints(List<Card> list){
		int points=0,i=points;
		int indexA = -1;
		
		//如果博弈方只有两张牌并且存在A+X(A,10,J,Q,K)的情况，将点数设置为最大值66666
		if(list.size()==2){
			//判断是否存在A牌
			for(int j=1;j<=4;j++){
				Card c = new  Card(1,j);
				indexA = list.indexOf(c);
				if(indexA!=-1){
					//如果存在A牌，判断是否存在A,10,J,Q,K牌
					indexA = (indexA==0)?1:0;
					Card b = list.get(indexA);
					if(b.getNumber()>=10)//代表A,10,J,Q,K牌
					{
						points = 66666;//将点数设置为最大值66666
						return points;	
					}	
				}
					
			}	
		}
		
			//判断是否存在A牌
			if(list.size()>2)
				for(int j=1;j<=4;j++){
					Card c = new  Card(1,j);
					indexA = list.indexOf(c);
					if(indexA!=-1)
						break;
				}
			//如果博弈方的牌数=>2张牌且不是A+X(A,10,J,Q,K)情况
			//不存在A牌
			if(indexA==-1){
				for(Card c:list){
					i = c.getNumber();
				if(i>10){
					//J,Q,K都当做10点计算
					i=10;
				  }
					points+=i;
				}
			}else{
			//存在A牌	
			 points = this.getContainsA(list);//计算包含A牌的所有可能情况，并返回最佳情况
			}
		if(list.size()==5){
			//小5龙，将points值设置为55555
			points = (points<21)?55555:points;
		}
			points = (points>21&&points!=55555)?-1:points;
		
		
		return points;
	}
	
	//返回含有A牌的手牌最好的结果
	public int getContainsA(List<Card> list){
		int countofA = 1;//记录A牌的数目
		int points = 0,i=0;
		for(Card c:list){
			if(c.getNumber()==14)
				countofA++;
			else{
				i = c.getNumber();
				if(i>10){
					//J,Q,K都当做10点计算
					i=10;
				  }
					points+=i;
				}			
		}
		int listofA[] = this.getTreeofA(countofA);
		for(int j=0;j<listofA.length;j++){
			int max = points+listofA[j];
			if(max==21)
				return max;
			listofA[j]=max;
		}
		Arrays.sort(listofA);
		if(listofA[listofA.length-1]<21)
			return points;
		else
			return this.getMaxFromA(listofA);//为了防止选到了超出21的数
	}
	
	//从列表中找到最佳点数
	public int getMaxFromA(int[] Alist){
		for(int i=Alist.length-1;i>0;i--){
			int j =Alist[i];
			if(j<21)
				return j;
		}
		return -1;
	}
	
	//构造牌A树
	public int[] getTreeofA(int level){
		//结果结合取决于level层次
		//A牌可以被当做的情况
		if(level==1){
			int resultA[] ={1,11};
			return resultA;
		}else if(level==2){
			int resultA[] ={2,12,22};
			return resultA;
		}else if(level==3){
			int resultA[] ={3,13,23};
			return resultA;
		}else{
			int resultA[] ={4,14,24,34};
			return resultA;
		}
		
		
	}

}
