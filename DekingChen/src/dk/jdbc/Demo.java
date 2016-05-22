package dk.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dk.main.Show;
import dk.or.EntityVauleAndCheatBean;

public class Demo extends Show{

	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;
	private static Statement st;

	public static void main(String[] args) {
		   //8:1-7
		   //count(492,1,7);
		  // 9:2-8
		 // count(493,2,7);
		  sql = "select * from count_or";
		  db1 =  new DBHelper(sql);
			try {
				ret = db1.pst.executeQuery();//执行语句，得到结果集
				int daydiff = 1;
				while (ret.next()) {
					daydiff = ret.getInt(6);
					show(daydiff);
					if(daydiff>7){
						int id = ret.getInt(1);
						count(id, daydiff-7, daydiff-1);
					}
				}
				ret.close();
				db1.close();//关闭连接
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public static List<EntityVauleAndCheatBean>   getEntity(){
		List<EntityVauleAndCheatBean> list = new ArrayList<EntityVauleAndCheatBean>();
		sql = "select *from test limit 0,10";//SQL语句
		db1 = new DBHelper(sql);//创建DBHelper对象
		boolean ischeat =true;
		try {	
			ret = db1.pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {				
				float user_id = ret.getFloat(2);
				int type = ret.getInt(3);
				if(type==1){
					ischeat=false;
				}
				show(user_id);
				EntityVauleAndCheatBean ev = new EntityVauleAndCheatBean("feature",user_id,ischeat);
				list.add(ev);
			}//显示数据
			ret.close();
			db1.close();//关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public static void count(int id ,int start,int end){
		sql = "select *from count_or limit "+start+","+end;//SQL语句
		sql = "select * from count_or where daydiff>="+start+" and"+" daydiff<="+end;
		DBHelper db2 = new DBHelper(sql);//创建DBHelper对象
		int uckc = 0;
		int uclc = 0;
		int uctc = 0;
		int ubc  = 0;
		try {	
			ret = db2.pst.executeQuery();//执行语句，得到结果集
			while (ret.next()) {				
				int type = ret.getInt(4);
				switch(type){
				case 1: uckc++;break;
				case 2: uclc++;break;
				case 3: uctc++;break;
				case 4: ubc++;break;
				}
			}//显示数据
			sql = "update count_or set UCKC="+uckc+",UCLC="+uclc+",UCTC="+uctc+",UBC="+ubc+" where id="+id;
			show(sql);
			st =  db1.conn.createStatement();
	        st.executeUpdate(sql);  
			//ret.close();
			//db1.close();//关闭连接
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

