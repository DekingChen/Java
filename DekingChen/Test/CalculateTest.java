import static org.junit.Assert.*;

import org.junit.Test;

import dk.junit.Calculate;


public class CalculateTest {

	/*
	 * 1.���Է����ϱ���ʹ��@Test��������
	 * 2.���Է�������ʹ��public void �������Σ����ܴ��κεĲ���
	 * 3.�½�һ��Դ����Ŀ¼��������ǵĲ��Դ���
	 * 4.������İ�Ӧ�úͱ������ౣ��һ��
	 * 5.���Ե�Ԫ�е�ÿ������������Զ������ԣ����Է����䲻�����κε�����
	 * 6.������ʹ��Test��Ϊ�����ĺ�׺�����Ǳ��룩
	 * 7.���Է���ʹ��test��Ϊ��������ǰ׺�����Ǳ��룩
	 */
	@Test
	public void testAdd() {
		assertEquals(8, new Calculate().add(3,3));
	}
	
	@Test
	public void testSubtract() {
		assertEquals(3, new Calculate().subtract(5,2));
	}
	
	@Test
	public void testMultiply() {
		assertEquals(4, new Calculate().multiply(2, 2));
	}
	
	@Test
	public void testDivide() {
		assertEquals(3, new Calculate().divide(6, 2));
	}
}
