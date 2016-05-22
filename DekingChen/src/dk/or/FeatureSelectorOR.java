
package dk.or;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import dk.jdbc.DBHelper;
import dk.main.Show;

//import org.hibernate.mapping.Array;



/**
 * Feature Selector for OR and fthr
 * 参见算法Feature Selector
 * @author feng
 * 2016年2月23日
 */
public class FeatureSelectorOR extends Show{
	//private  final double MAXCONSTANT=100000000.0d;
	
	/**
	 * @author feng
	 * @param domainValues feature的御值
	 * @param CO 作弊数量
	 * @param NCO 非作弊数量
	 * @param isBigger true >=;false <=
	 * @return
	 * 2016年2月23日 下午6:10:22
	 */
	private List<EvidenceThreshold> getCandidateThresholdList(List<EntityVauleAndCheatBean> evcbList,int CO,int NCO,boolean isBigger) {
		int coc=0;	
		int ncoc=0;	
		double p1,p2,or,tempValue;
		Set<EvidenceThreshold> orSet = new HashSet<EvidenceThreshold>();//不要重複
		List<Double> domainValues = getDomainValues(evcbList);
		
		for (Double thr : domainValues) {
			p1=0;
			p2=0;	
			or=0;
			coc=0;
			ncoc=0;
			for (EntityVauleAndCheatBean evcb : evcbList) {
				tempValue=evcb.getThresholdValue();
				if(isBigger){	//  >=
					if (tempValue>=thr) {
						if (evcb.isCheat()) coc++;
						else if(!evcb.isCheat()) ncoc++;
					}
				}else{	//  <=
					if (tempValue<=thr) {
						if (evcb.isCheat()) coc++;
						else if(!evcb.isCheat()) ncoc++;
					}
				}
			}
	
			p1=coc/(double)CO;
			p2=ncoc/(double)NCO;
			if (p1>p2) {	//第一次判斷，要p1>p2,否則or＜=1,跳過
				if(p1!=1&&p2!=0){//非極值
					or= (p1/(1-p1))/(p2/(1-p2));
				}else{//極值
//					if (thr>domainValues.get((int)(domainValues.size()*0.95))||thr<domainValues.get((int)(domainValues.size()*0.05))) {
//						or = 2;
//					}else {
//						or=MAXCONSTANT;
//					}
					continue;
				}
			}else{
				continue;
			}
			
			if (or>=2) {	//只接受or>2的
				orSet.add(new EvidenceThreshold(evcbList.get(0).getName(), isBigger, thr, p1, p2, or));
			}
		}
		List<EvidenceThreshold> orList=new ArrayList<EvidenceThreshold>(orSet);
		return orList;
	}
	public List<Double> getDomainValues(List<EntityVauleAndCheatBean> el){
		HashSet<Double> ds=new HashSet<Double>();//set去重複
 		for (EntityVauleAndCheatBean e : el) {
			ds.add(e.getThresholdValue());
		}
		ArrayList<Double> domainValuesList = new ArrayList<Double>(ds);
		Collections.sort(domainValuesList);
		return domainValuesList;
	}
	private EvidenceThreshold getTheBestThresholdForAfeature(List<EvidenceThreshold> orList) {
		if (orList==null||orList.size()==0) return null;
		Collections.sort(orList);
		Collections.reverse(orList);
		return orList.get(0);
	}
	
	/**
	 * 
	 * @param evcbList
	 * @return
	 * @author feng
	 * 2016年5月16日 下午12:20:06
	 */
	private EvidenceThreshold findThresholdAndType(List<EntityVauleAndCheatBean> evcbList){
		//先計算作弊 不作弊數量
		int CO=getCO(evcbList); 
		int NCO=getNCO(evcbList);
		//取比threshold大的值，計算出所有域值對應的OR
		List<EvidenceThreshold> orBiggerList=getCandidateThresholdList(evcbList,CO,NCO,true);
		//取比threshold小的值，再次計算出所有域值對應的OR
		List<EvidenceThreshold> orSmallerList=getCandidateThresholdList(evcbList,CO,NCO,false);
		
		//分別找到出兩種情況下最佳的or
		EvidenceThreshold orBigger=getTheBestThresholdForAfeature(orBiggerList);
		EvidenceThreshold orSmaller=getTheBestThresholdForAfeature(orSmallerList);
		
		//找到兩者最好的那一個
		if (orBigger==null&&orSmaller==null) {
			return null;
		}
		EvidenceThreshold result;
		if(orBigger!=null&&orBigger.compareTo(orSmaller)==1){
			result=orBigger;
			result.setIsPositive(true);
		}else {	
			result=orSmaller;
			result.setIsPositive(false);
		}
		return result;
	}
		
	private int getCO(List<EntityVauleAndCheatBean> evcbList){
		int co=0;
		for (EntityVauleAndCheatBean e : evcbList) {
			if (e.isCheat()) {
				co++;
			}
		}		
		return co;
	}
	
	private int getNCO(List<EntityVauleAndCheatBean> evcbList) {
		int nco=0;
		for (EntityVauleAndCheatBean e : evcbList) {
			if (!e.isCheat()) {
				nco++;
			}
		}		
		return nco;
	}
	
	/**
	 * 方法入口
	 * @param evcblist
	 * @return
	 * @author feng
	 * 2016年4月8日 下午5:16:01
	 */
	public EvidenceThreshold caculateFeature(List<EntityVauleAndCheatBean> evcblist){
		EvidenceThreshold orV2=null;
		if (evcblist!=null&&!evcblist.isEmpty()) {
			orV2=findThresholdAndType(evcblist);
		}
		return orV2;
	}	

	public static void main(String args[]) {
		show("starting...");
		FeatureSelectorOR featureSelectorOR = new FeatureSelectorOR();
		//getEntity();
		String namelist[] = {"click","cart","add","buy","UCKC","UCLC","UCTC","UBC","UCKBR","UCLBR","UCTBR","UAKC","UACL","UACT","UAB","UVCK","UVCL","UVCT","UVB"};
		int featurecount =namelist.length;	
		int recordSize = 1413;
		List<EvidenceThreshold> result = new ArrayList<EvidenceThreshold>(featurecount);
		for (int i = 0; i < featurecount; i++) {
			show("运行第"+i+"次");
			//List<EntityVauleAndCheatBean> es = FeatureSelectorOR.generateEntitys("feature"+i,recordSize,i);
			List<EntityVauleAndCheatBean> es = getEntity(7+i,namelist[i]);
			EvidenceThreshold o2 = featureSelectorOR.caculateFeature(es);
			//show(o2);
			if (o2!=null) 	result.add(o2);	
		}
		Collections.sort(result);
		for (EvidenceThreshold evidenceThreshold : result) {
			System.out.println(evidenceThreshold);
		}
		show("end!");
		
	}
	
	public static List<EntityVauleAndCheatBean>   getEntity(int index,String name){
		 String sql = null;
		 DBHelper db1 = null;
		 ResultSet ret = null;
		List<EntityVauleAndCheatBean> list = new ArrayList<EntityVauleAndCheatBean>();
		sql = "select *from count_or01 where id>=1939";//SQL语句
		sql = "select *from count_or_5 where id>=295";//SQL语句
		db1 = new DBHelper(sql);//创建DBHelper对象
		boolean ischeat =true;
		try {	
			ret = db1.pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {				
				double item_id = ret.getDouble(index);
				int type = ret.getInt(4);
				if(type==1){
					ischeat = false;
				}else{
					ischeat =true;
				}
				//show("item_id=="+item_id+"=="+ischeat);
				list.add(new EntityVauleAndCheatBean("feature:"+name+index,item_id,ischeat));
			}//显示数据
			ret.close();
			db1.close();//关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	private static List<EntityVauleAndCheatBean> generateEntitys(String featurename,int size,int index) {
		Random random = new Random(index);
		List<EntityVauleAndCheatBean> es = new ArrayList<EntityVauleAndCheatBean>(size);
		for (int i = 0; i < size; i++) {
			//EntityVauleAndCheatBean evv = new EntityVauleAndCheatBean(featurename, random.nextDouble()*10, random.nextBoolean()&&random.nextBoolean());
			es.add(new EntityVauleAndCheatBean(featurename, random.nextDouble()*10, random.nextBoolean()&&random.nextBoolean()));
		}
		/*for(EntityVauleAndCheatBean ev :es){
			show(ev.getName()+"=="+ev.getThresholdValue()+"=="+ev.isCheat());
		}*/
		return es;
	}

}

