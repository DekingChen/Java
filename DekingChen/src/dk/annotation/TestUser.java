/**
 * 
 */
package dk.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import dk.main.Show;

/**
 * @author Administrator
 *
 */
public class TestUser extends Show{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		User user = new User();
		user.setName("DekingChen");
		user.setAge(18);
		user.setCity("GuangZhou");
		user.setEmail("DekingChen@qq.com,chenzhenquan@163.com");
		show(query(user));
		Department depart = new Department();
		depart.setId("DK技术部门");
		depart.setSum(100);
		show(query(depart));

	}
	
	public static String query(Object user) throws Exception{
		StringBuilder sb = new StringBuilder();
		//Get Class
		Class<? extends Object> c = user.getClass();
		//Get Table Name
		boolean isExists = c.isAnnotationPresent(Table.class);
		if(!isExists){
			return null;
		}
		Table t=(Table)c.getAnnotation(Table.class);
		String tableName = t.table();
		sb.append("select * from").append(tableName).append("where 1=1 ");
		//Get all columns
		Field[] farr = c.getDeclaredFields();
		for(Field field:farr){
			boolean isField = field.isAnnotationPresent(Column.class);
			if(!isField){
				continue;
			}
			Column column = field.getAnnotation(Column.class);
			@SuppressWarnings("unused")
			String columnName = (String)column.column();
			String fieldName = field.getName();
			String getMethodName ="get"+fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
			Object fieldValue = null;
			try {
				Method getMethod = c.getMethod(getMethodName);
				fieldValue =  getMethod.invoke(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(fieldValue==null||(fieldValue instanceof Integer && (Integer)fieldValue==0)){
				continue;
			}
			sb.append("and ").append(fieldName).append("=");
			if(fieldValue instanceof String){
				if(((String) fieldValue).contains(",")){
					sb.append(" in(");
					String[] arr = ((String) fieldValue).split(",");
					for(String s:arr){
						sb.append("'").append(s).append("'").append(",");
					}
					sb.deleteCharAt(sb.length()-1);
					sb.append(")");
				}else{
					sb.append("'").append(fieldValue).append("'");
				}
			
			}else{
				sb.append(fieldValue);
			}
		}
 		return sb.toString();
	}

}
