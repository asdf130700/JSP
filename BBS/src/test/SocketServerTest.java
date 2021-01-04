package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServerSocket ssocket = null;
		Socket socket = null;

		try {
			ssocket = new ServerSocket(2000);
			System.out.println("Start=========");
			socket = ssocket.accept();
			System.out.println("connected!!!!!!");
			socket.setSoTimeout(2000);
			// 타임 아웃 설정

			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			reader.readLine();

		} catch (Exception e) {
			e.printStackTrace();
			// java.net.SocketTimeoutException: Read timed out 이렇게 에러가 발생함

		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
