package test;

import java.net.Socket;

public class SocketTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Socket socket = new Socket("localhost", 2000);
			Thread.sleep(6000);

			// timeout �ɸ��� �ð����� ��� sleep �� �ɾ Ȯ�� ��

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
