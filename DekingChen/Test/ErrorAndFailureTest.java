import static org.junit.Assert.*;

import org.junit.Test;

import dk.junit.Calculate;


public class ErrorAndFailureTest {

	/*
	 * 1.Failureһ���ɵ�Ԫ����ʹ�õĶ��Է����ж�ʧ��������ģ��⾭��ʾ ���Ե㷢��������
	 * ������˵��������Ľ��������Ԥ�ڵĲ�һ����
	 * 2.error���ɴ����쳣����ģ������Բ����ڲ��Դ��뱾��Ĵ���Ҳ�����Ǳ����Դ����е�
	 * һ�����ص�bug
	 * 3.����������������֤�����ǶԵģ���������֤����û�д�
	 */
	@Test
	public void testAdd() {
		assertEquals(5, new Calculate().add(3,3));
	}

	@Test(expected=ArithmeticException.class)
	public void testDivide() {
		assertEquals(3, new Calculate().divide(6, 0));
	}

}
