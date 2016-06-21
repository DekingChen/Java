import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import dk.junit.Calculate;


public class AnotationTest {

	/*
	 * @Test:��һ����ͨ�ķ������γ�Ϊһ�����Է���
	 * 		@Test(expected=XX.class)
	 * 		@Test(timeout=���� )
	 * @BeforeClass�����������еķ�������ǰ��ִ�У�static����
	 * @AfterClass:���������еķ������н�����ִ�У�static����
	 * @Before������ÿһ�����Է���������ǰִ��һ��
	 * @After������ÿһ�����Է������к�ִ��һ��
	 * @Ignore:�����εĲ��Է����ᱻ��������������
	 * @RunWith:���Ը��Ĳ��������� org.junit.runner.Runner
	 */
	
	@Test(expected=ArithmeticException.class)
	public void testDivide() {
		assertEquals(3, new Calculate().divide(6, 0));
	}
	
	@Ignore("for some reason")
	@Test(timeout=2000)
	public void testWhile() {
		while(true) {
			System.out.println("run forever...");
		}
	}
	
	@Test(timeout=3000)
	public void testReadFile(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
