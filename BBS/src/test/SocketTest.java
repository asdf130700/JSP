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

			// timeout 걸리는 시간보다 길게 sleep 을 걸어서 확인 함

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
