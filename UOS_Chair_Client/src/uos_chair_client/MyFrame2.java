package uos_chair_client;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

@SuppressWarnings("serial")

public class MyFrame2 extends JFrame{

	private JButton jb = new JButton("Click Me");
	private boolean flag = false;
	//static String IP = "127.0.0.1";
	static String IP = "172.16.167.180";//서버 IP 주소 입력 
	//static String IP = "10.0.22.160";
	private static Socket socket;
	
	public MyFrame2() throws UnknownHostException, IOException{

		Toolkit kit = Toolkit.getDefaultToolkit();		
		Dimension screenSize = kit.getScreenSize();
		Dimension frameSize = this.getSize();
		setPreferredSize(new Dimension(screenSize.width, screenSize.height)); //screenSize.width, screenSize.height
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);	// 화면 가운데 창이 뜨게 지정
		setResizable(false);
		pack();
		
		setTitle("UOS Chair Client");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setFocusable(true);
		
		jb.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				flag = true; 
				jb.setText("Clicked");
			}
			public void mouseReleased(MouseEvent e){ 
				flag = false;
				jb.setText("Click Me");
			}
		});

		add(jb);

		socket = new Socket(IP,45000);
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {
			
			@Override
			public void run(){
				// TODO Auto-generated method stub
				try {
					OutputStream out = socket.getOutputStream(); 
					DataOutputStream dou = new DataOutputStream(out); 
					dou.writeBoolean(flag);

				} catch (UnknownHostException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		timer.schedule(timertask, 0, 500);
	}
}
