package dk.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RuleOf21 implements Rule {

	
	

	@Override
	
	/* ��ʮһ�����Ϸ�ȽϵĻ�������
	 * 1.������ĸ���ֻ�������ƣ�A+X(A,10,J,Q,K)������
	 * 2.�������Ƶĵ����������͵���21����󣬳���21�����С���Դ�����21>20>....1>22>23...50����ȥ1�е����������������1�е���ϣ��������1������ı��������ķ����󣬼�ʹ�Է���21�㡿
	 * 3.�����2������£��������ܵ�����������������5���Ƶ���ұȲ���5�����Ƶ���Ҵ�
	 * 4.��A���Ե�����1����11����
	 * 5.���ĸ��������������Ϊ5��
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
	
	//��ȡ������Ƶĵ���--���չ�����м���
	public int getPoints(List<Card> list){
		int points=0,i=points;
		int indexA = -1;
		
		//������ķ�ֻ�������Ʋ��Ҵ���A+X(A,10,J,Q,K)�����������������Ϊ���ֵ66666
		if(list.size()==2){
			//�ж��Ƿ����A��
			for(int j=1;j<=4;j++){
				Card c = new  Card(1,j);
				indexA = list.indexOf(c);
				if(indexA!=-1){
					//�������A�ƣ��ж��Ƿ����A,10,J,Q,K��
					indexA = (indexA==0)?1:0;
					Card b = list.get(indexA);
					if(b.getNumber()>=10)//����A,10,J,Q,K��
					{
						points = 66666;//����������Ϊ���ֵ66666
						return points;	
					}	
				}
					
			}	
		}
		
			//�ж��Ƿ����A��
			if(list.size()>2)
				for(int j=1;j<=4;j++){
					Card c = new  Card(1,j);
					indexA = list.indexOf(c);
					if(indexA!=-1)
						break;
				}
			//������ķ�������=>2�����Ҳ���A+X(A,10,J,Q,K)���
			//������A��
			if(indexA==-1){
				for(Card c:list){
					i = c.getNumber();
				if(i>10){
					//J,Q,K������10�����
					i=10;
				  }
					points+=i;
				}
			}else{
			//����A��	
			 points = this.getContainsA(list);//�������A�Ƶ����п��������������������
			}
		if(list.size()==5){
			//С5������pointsֵ����Ϊ55555
			points = (points<21)?55555:points;
		}
			points = (points>21&&points!=55555)?-1:points;
		
		
		return points;
	}
	
	//���غ���A�Ƶ�������õĽ��
	public int getContainsA(List<Card> list){
		int countofA = 1;//��¼A�Ƶ���Ŀ
		int points = 0,i=0;
		for(Card c:list){
			if(c.getNumber()==14)
				countofA++;
			else{
				i = c.getNumber();
				if(i>10){
					//J,Q,K������10�����
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
			return this.getMaxFromA(listofA);//Ϊ�˷�ֹѡ���˳���21����
	}
	
	//���б����ҵ���ѵ���
	public int getMaxFromA(int[] Alist){
		for(int i=Alist.length-1;i>0;i--){
			int j =Alist[i];
			if(j<21)
				return j;
		}
		return -1;
	}
	
	//������A��
	public int[] getTreeofA(int level){
		//������ȡ����level���
		//A�ƿ��Ա����������
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
