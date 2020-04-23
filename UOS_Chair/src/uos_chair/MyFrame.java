package uos_chair;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.util.Timer;
import java.util.TimerTask;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


@SuppressWarnings("serial")

public class MyFrame extends JFrame{

	private static JButton jb[] = new JButton[12];
	private static int count = 0;
	private static boolean flag[] = new boolean[12];
	private static boolean c_flag = false;
	private static Socket socket;
	
	public MyFrame() throws IOException{

		Toolkit kit = Toolkit.getDefaultToolkit();		
		Dimension screenSize = kit.getScreenSize();
		Dimension frameSize = this.getSize();
		setPreferredSize(new Dimension(1000, 400));
		setLocation((screenSize.width-frameSize.width)/2, (screenSize.height-frameSize.height)/2);	// È­¸é °¡¿îµ¥ Ã¢ÀÌ ¶ß°Ô ÁöÁ¤
		setResizable(false);
		pack();
		
		setTitle("UOS Chair Server");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(new TAdapter());
		
		GridLayout gl1 = new GridLayout(2, 6);
		JPanel jp = new JPanel();
		JPanel jp2 = new JPanel();
		Font f = new Font("±¼¸²", Font.BOLD, 15);
	
		jp.setLayout(gl1);
		jp.setBounds(10, 10, 975, 350);
		
		for(int i=0; i<12; i++){
			flag[i]=false;
			jb[i] = new JButton("" + (i+1));
			jb[i].setFont(f);
			jb[i].setBackground(Color.WHITE);
			jp.add(jb[i]);
		}
		
		jb[0].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[0]==true){
					flag[0]=false;
					jb[0].setText("1");
					jb[0].setBackground(Color.WHITE);
				}
				else{
					flag[0]=true;
					jb[0].setText("Âø¼®Áß");
					jb[0].setBackground(Color.orange);
				}
				c_flag=false;
			}
		});
		
		jb[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[1]==true){
					flag[1]=false;
					jb[1].setText("2");
					jb[1].setBackground(Color.WHITE);
				}
				else{
					flag[1]=true;
					jb[1].setText("Âø¼®Áß");
					jb[1].setBackground(Color.orange);
				}
			}
		});

		jb[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[2]==true){
					flag[2]=false;
					jb[2].setText("3");
					jb[2].setBackground(Color.WHITE);
				}
				else{
					flag[2]=true;
					jb[2].setText("Âø¼®Áß");
					jb[2].setBackground(Color.orange);
				}
			}
		});
		
		jb[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[3]==true){
					flag[3]=false;
					jb[3].setText("4");
					jb[3].setBackground(Color.WHITE);
				}
				else{
					flag[3]=true;
					jb[3].setText("Âø¼®Áß");
					jb[3].setBackground(Color.orange);
				}
			}
		});
		
		jb[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[4]==true){
					flag[4]=false;
					jb[4].setText("5");
					jb[4].setBackground(Color.WHITE);
				}
				else{
					flag[4]=true;
					jb[4].setText("Âø¼®Áß");
					jb[4].setBackground(Color.orange);
				}
			}
		});
		
		jb[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[5]==true){
					flag[5]=false;
					jb[5].setText("6");
					jb[5].setBackground(Color.WHITE);
				}
				else{
					flag[5]=true;
					jb[5].setText("Âø¼®Áß");
					jb[5].setBackground(Color.orange);
				}
			}
		});
		
		jb[6].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[6]==true){
					flag[6]=false;
					jb[6].setText("7");
					jb[6].setBackground(Color.WHITE);
				}
				else{
					flag[6]=true;
					jb[6].setText("Âø¼®Áß");
					jb[6].setBackground(Color.orange);
				}
			}
		});
		
		jb[7].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[7]==true){
					flag[7]=false;
					jb[7].setText("8");
					jb[7].setBackground(Color.WHITE);
				}
				else{
					flag[7]=true;
					jb[7].setText("Âø¼®Áß");
					jb[7].setBackground(Color.orange);
				}
			}
		});
		
		jb[8].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[8]==true){
					flag[8]=false;
					jb[8].setText("9");
					jb[8].setBackground(Color.WHITE);
				}
				else{
					flag[8]=true;
					jb[8].setText("Âø¼®Áß");
					jb[8].setBackground(Color.orange);
				}
			}
		});
		
		jb[9].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[9]==true){
					flag[9]=false;
					jb[9].setText("10");
					jb[9].setBackground(Color.WHITE);
				}
				else{
					flag[9]=true;
					jb[9].setText("Âø¼®Áß");
					jb[9].setBackground(Color.orange);
				}
			}
		});
		
		jb[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[10]==true){
					flag[10]=false;
					jb[10].setText("11");
					jb[10].setBackground(Color.WHITE);
				}
				else{
					flag[10]=true;
					jb[10].setText("Âø¼®Áß");
					jb[10].setBackground(Color.orange);
				}
			}
		});
		
		jb[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(flag[11]==true){
					flag[11]=false;
					jb[11].setText("12");
					jb[11].setBackground(Color.WHITE);
				}
				else{
					flag[11]=true;
					jb[11].setText("Âø¼®Áß");
					jb[11].setBackground(Color.orange);
				}
			}
		});
		
		add(jp);
		add(jp2);
		
		@SuppressWarnings("resource")
		ServerSocket serversocket = new ServerSocket(45000); 
		count = 0;
		socket = serversocket.accept(); 
		
		Timer timer = new Timer();
		TimerTask timertask = new TimerTask() {
			@Override
			public void run(){
				try {

					InputStream in = socket.getInputStream();
					DataInputStream din = new DataInputStream(in); 
					if(din.readBoolean()==true&&flag[0]==true){
						jb[0].setText("Âø¼®Áß");
						count=0;
					}
					else if(din.readBoolean()==false&&flag[0]==true){
						jb[0].setText("ÀÚ¸®ºñ¿ò (" + count + "ÃÊ)");
						count++;
						if(count>10){
							c_flag=true;
							flag[0]=false;
						}
					}
					else if(c_flag==true){
						jb[0].setText(1+" (½Ã°£ ¸¸·á)");
						jb[0].setBackground(Color.YELLOW);
						count=0;
					}
					else if(flag[0]==false){
						jb[0].setText("" + 1);
						jb[0].setBackground(Color.WHITE);
						count=0;
					}
						
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		timer.schedule(timertask, 0, 500);
		
		this.setFocusable(true);
	}
	
	private class TAdapter extends KeyAdapter{
		
		@Override
		public void keyPressed(KeyEvent e){
			
			int keyCode = e.getKeyCode();
			switch (keyCode) {
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;
			}
		}
	}
}
