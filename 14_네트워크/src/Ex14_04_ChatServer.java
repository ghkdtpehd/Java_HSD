import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class Ex14_04_ChatServer extends JFrame implements ActionListener {
	BufferedReader in = null;
	BufferedWriter out = null;
	ServerSocket listener = null;
	Socket socket = null;
	JTextField serverMessage;
	JScrollPane spane;
	Receiver clientMessage;
	
	
	public Ex14_04_ChatServer() {
		setTitle("서버 채팅 창"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		clientMessage = new Receiver(); 
						// 클라이언트에서 받은 메시지를 출력할 컴포넌트
		clientMessage.setEditable(false); 
		
		Thread t = new Thread(clientMessage); 
		
		serverMessage = new JTextField();
		serverMessage.addActionListener(this);
		spane = new JScrollPane(clientMessage); 
		
		add(spane,BorderLayout.CENTER);
		add(serverMessage,BorderLayout.SOUTH);
		setSize(400, 200); 
		setVisible(true); 
		
		try {
			setupConnection();
		} catch (IOException e) {
			handleError(e.getMessage());
			e.printStackTrace();
		}
		t.start();
	}
	
	private void setupConnection() throws IOException {
		listener = new ServerSocket(9999); 
		socket = listener.accept(); 
		System.out.println("연결됨");
		in = new BufferedReader(new InputStreamReader(
				socket.getInputStream())); 
		
		out = new BufferedWriter(new OutputStreamWriter(
				socket.getOutputStream()));
	}
	
	public static void main(String[] args) {
		Ex14_04_ChatServer frame = new Ex14_04_ChatServer();
	}

	private static void handleError(String string) {
		System.out.println(string);
		System.exit(1); 
	}
	
	private class Receiver extends JTextArea implements Runnable {
		@Override
		public void run() { 
			String inputMessage=null;
			while (true) {
				try {
					inputMessage = in.readLine(); 
				} catch (IOException e) {
					handleError(e.getMessage());
					e.printStackTrace();
				}
				clientMessage.append("\n" + inputMessage);
				int pos = clientMessage.getText().length();
				clientMessage.setCaretPosition(pos); 
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource() == serverMessage) { 
			String outputMessage = serverMessage.getText(); 
			try {
				out.write("서버>" + outputMessage+"\n"); 
				out.flush(); 
				clientMessage.append("\n서버>" + outputMessage); 
				int pos = clientMessage.getText().length();
				clientMessage.setCaretPosition(pos); 
				serverMessage.setText(null);  
			} catch (IOException e1) {
				handleError(e1.getMessage());
				e1.printStackTrace();
			} 
		}
	}
}



