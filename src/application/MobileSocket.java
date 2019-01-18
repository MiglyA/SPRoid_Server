package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MobileSocket {

	ServerSocket server = null;
	Socket socket = null;
	static PrintWriter output;
	static BufferedReader input;
	static String result = null;

	private void buffer() { // buffer変数作成
		try {
			// socket送信
			output = new PrintWriter(socket.getOutputStream(), true);
			// socket受け取り
			input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// 受け取りスレッドを立てる
			new Thread(new Runnable() {
				@Override
				public void run() {
					// 受信
					try {
						while (true) {
							result = input.readLine();
						}
					} catch (IOException e) {
						System.out.println("stop");
					}
				}
			}).start();

		} catch (IOException e) {
			System.out.println("Error CreateBuffer\n" + e);
		}
	}

	public void server(int port) {

		try {
			// serverの設定
			server = new ServerSocket();
			server.bind(new InetSocketAddress("localhost", port));

			System.out.println("接続待ち");
			// 応答待機、応答後接続
			socket = server.accept();

			buffer();

		} catch (IOException e) {
			System.out.println("Error Connection\n" + e);
		}

		System.out.println("connected");

	}

	public void client(int port) {

		while (socket == null) { // 繋がるまで
			try {
				socket = new Socket("localhost", port);
				buffer();
			} catch (IOException e) {
				System.out.print(".");
			}
		}

		System.out.println("connected");
	}

	public void publishe(String s) {
		// 送信
		if(output != null) output.println(s);
	}

	public String subscribe() {
		// 受信結果
		String def = null;

		if (result != null) {
			def = result;
			result = null;
		}
		return def;
	}

}
