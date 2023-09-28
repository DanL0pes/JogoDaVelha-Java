import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class JogoVelha extends JDialog{
	
	private Container containerJogoVelha;
	private JTabbedPane tpJogoVelha;
	private JPanel pJogador1, pJogador2, pJogoVelha;
	private JLabel lbNomeJ1, lbNomeJ2, lbEscolha, lbVez, lbWinsX, lbWinsO;
	private JTextField txNomeJ1, txNomeJ2;
	private JButton btEscolhaJ1X, btEscolhaJ1O, btEscolhaJ2X, btEscolhaJ2O, btNext, btNextJ2, btResetGame, btPos[][] = new JButton[3][3];
	private ImageIcon imgX, imgO, imgXjogo, imgOjogo, imgJ1, imgJ2;
	private String nomeX, nomeO, nomeVencedor;
	private int vencedor, winsX=0,winsO=0;
	
	public JogoVelha() {
		this.setTitle("Jogo da Velha");
		this.setModal(true);
		this.setSize(700, 900);
		this.setResizable(false);
		
		containerJogoVelha = this.getContentPane();
		setLocationRelativeTo(containerJogoVelha);
		containerJogoVelha.setLayout(null);
		
		tpJogoVelha = new JTabbedPane();
		tpJogoVelha.setBounds(0,0,700,900);
		
		pJogador1 = new JPanel();
		pJogador1.setLayout(null);
		
		pJogador2 = new JPanel();
		pJogador2.setLayout(null);
		
		lbNomeJ1 = new JLabel();
		lbNomeJ1.setText("Digite seu Nome:");
		lbNomeJ1.setBounds(50, 20, 100, 20);
		pJogador1.add(lbNomeJ1);
		
		lbNomeJ2 = new JLabel();
		lbNomeJ2.setText("Digite seu Nome:");
		lbNomeJ2.setBounds(50, 20, 100, 20);
		pJogador2.add(lbNomeJ2);
		
		txNomeJ1 = new JTextField();
		txNomeJ1.setBounds(150,20,450,20);
		pJogador1.add(txNomeJ1);
		
		txNomeJ2 = new JTextField();
		txNomeJ2.setBounds(150,20,450,20);
		pJogador2.add(txNomeJ2);
		
		lbEscolha = new JLabel();
		lbEscolha.setText("Escolha seu simbolo:");
		lbEscolha.setBounds(50,60,150,20);
		pJogador1.add(lbEscolha);
		
		imgX = new ImageIcon(getClass().getResource("image/X.png"));
		imgO = new ImageIcon(getClass().getResource("image/O.png"));
		imgXjogo = new ImageIcon(getClass().getResource("image/Xjogo.png"));
		imgOjogo = new ImageIcon(getClass().getResource("image/Ojogo.png"));
		
		
		J1SelectX j1X = new J1SelectX();
		btEscolhaJ1X = new JButton(imgX);
		btEscolhaJ1X.setBounds(50,90, 275,275);
		btEscolhaJ1X.addActionListener(j1X);
		pJogador1.add(btEscolhaJ1X);
		
		J1SelectO j1O = new J1SelectO();
		btEscolhaJ1O = new JButton(imgO);
		btEscolhaJ1O.setBounds(350,90, 275,275);
		btEscolhaJ1O.addActionListener(j1O);
		pJogador1.add(btEscolhaJ1O);
		
		J2SelectX j2X = new J2SelectX();
		btEscolhaJ2X = new JButton(imgX);
		btEscolhaJ2X.setBounds(50,90, 275,275);
		btEscolhaJ2X.addActionListener(j2X);
		pJogador2.add(btEscolhaJ2X);
		
		J2SelectO j2O = new J2SelectO();
		btEscolhaJ2O = new JButton(imgO);
		btEscolhaJ2O.setBounds(350,90, 275,275);
		btEscolhaJ2O.addActionListener(j2O);
		pJogador2.add(btEscolhaJ2O);
		
		NextPageJ1 npJ1 = new NextPageJ1();
		btNext = new JButton();
		btNext.setBounds(250,500, 200, 100);
		btNext.setText("Próximo");
		btNext.addActionListener(npJ1);
		pJogador1.add(btNext);
		
		NextPageJ2 npJ2 = new NextPageJ2();
		btNextJ2 = new JButton();
		btNextJ2.setBounds(250,500, 200, 100);
		btNextJ2.setText("Jogar");
		btNextJ2.addActionListener(npJ2);
		pJogador2.add(btNextJ2);
		
		pJogoVelha = new JPanel();
		pJogoVelha.setLayout(null);
		
		int y=20;
		ClickButtonJogo clickButton = new ClickButtonJogo();
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				btPos[i][j] = new JButton();
				switch(j) {
				case 0:	
					btPos[i][j].setBounds(50,y,200,200);
					break;
				case 1:
					btPos[i][j].setBounds(250,y,200,200);
					break;
				case 2:
					btPos[i][j].setBounds(450,y,200,200);
					break;
				}
				btPos[i][j].addActionListener(clickButton);
				pJogoVelha.add(btPos[i][j]);
			}
			y= y+200;
		}
		
		lbVez = new JLabel();
		lbVez.setBounds(50,640, 600,30);
		lbVez.setFont(new Font("Century Gothic", Font.BOLD, 26));
		pJogoVelha.add(lbVez);
		
		lbWinsX = new JLabel();
		lbWinsX.setBounds(50, 690, 200, 20);
		lbWinsX.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbWinsX.setText(nomeX+" Wins: ");
		pJogoVelha.add(lbWinsX);
		
		lbWinsO = new JLabel();
		lbWinsO.setBounds(350, 690, 200, 20);
		lbWinsO.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lbWinsO.setText(nomeO+" Wins: ");
		pJogoVelha.add(lbWinsO);
		
		ButtonReset reset = new ButtonReset();
		btResetGame = new JButton();
		btResetGame.setBounds(50,720,600,100);
		btResetGame.setText("Reiniciar");
		btResetGame.addActionListener(reset);
		pJogoVelha.add(btResetGame);
		
		tpJogoVelha.addTab("Jogador 1", null, pJogador1, "1* Jogador");
		tpJogoVelha.addTab("Jogador 2", null, pJogador2, "2* Jogador");
		
		containerJogoVelha.add(tpJogoVelha);
		
		this.setVisible(true);
		this.setLayout(null);
	}
	
	private class J1SelectX implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			txNomeJ1.setEnabled(false);
			btEscolhaJ1X.setEnabled(false);
			btEscolhaJ1O.setVisible(false);
			btEscolhaJ2X.setVisible(false);
			btEscolhaJ2O.setEnabled(false);
			imgJ1 = imgX;
			imgJ2 = imgO;
		}
	}
	private class J1SelectO implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			txNomeJ1.setEnabled(false);
			btEscolhaJ1O.setEnabled(false);
			btEscolhaJ1X.setVisible(false);
			btEscolhaJ2O.setVisible(false);
			btEscolhaJ2X.setEnabled(false);
			imgJ1 = imgO;
			imgJ2 = imgX;
		}
	}
	
	private class J2SelectX implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			txNomeJ2.setEnabled(false);
			btEscolhaJ2X.setEnabled(false);
			btEscolhaJ2O.setVisible(false);
			btEscolhaJ1X.setVisible(false);
			btEscolhaJ1O.setEnabled(false);
			imgJ2 = imgX;
			imgJ1 = imgO;
		}
	}
	private class J2SelectO implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			txNomeJ2.setEnabled(false);
			btEscolhaJ2O.setEnabled(false);
			btEscolhaJ2X.setVisible(false);
			btEscolhaJ1O.setVisible(false);
			btEscolhaJ1X.setEnabled(false);
			imgJ2 = imgO;
			imgJ1 = imgX;
		}
	}
	
	private class NextPageJ1 implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			tpJogoVelha.setSelectedIndex(1);
		}
	}
	private class NextPageJ2 implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			if(imgJ1 == imgX) {
				nomeX = txNomeJ1.getText();
			}else if(imgJ1 == imgO) {
				nomeO = txNomeJ1.getText();
			}
			if(imgJ2 == imgX) {
				nomeX = txNomeJ2.getText();
			}else if(imgJ2 == imgO) {
				nomeO = txNomeJ2.getText();
			}
			lbVez.setText("Jogada do "+nomeX+":");
			tpJogoVelha.addTab("Jogo", null, pJogoVelha, "Jogo da Velha");
			tpJogoVelha.setSelectedIndex(2);
		}
	}
	private class ButtonReset implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Reset();
		}
	}
	private class ClickButtonJogo implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			for(int i=0; i<3;i++) {
				for(int j=0; j<3; j++) {
					if(source == btPos[i][j]) {
						if(lbVez.getText().equals("Jogada do "+nomeX+":")) {
							btPos[i][j].setIcon(imgXjogo);
							btPos[i][j].setEnabled(false);
							lbVez.setText("Jogada do "+nomeO+":");
						}else if(lbVez.getText().equals("Jogada do "+nomeO+":")) {
							btPos[i][j].setEnabled(false);
							btPos[i][j].setIcon(imgOjogo);
							lbVez.setText("Jogada do "+nomeX+":");
						}
					}
				}
			}
			
			int nuloButton = 0;
			 //x ganhando
			if(btPos[0][0].getIcon() == imgXjogo && btPos[0][1].getIcon() == imgXjogo && btPos[0][2].getIcon() == imgXjogo 
				|| btPos[1][0].getIcon() == imgXjogo && btPos[1][1].getIcon() == imgXjogo && btPos[1][2].getIcon() == imgXjogo
				|| btPos[2][0].getIcon() == imgXjogo && btPos[2][1].getIcon() == imgXjogo && btPos[2][2].getIcon() == imgXjogo
				|| btPos[0][0].getIcon() == imgXjogo && btPos[1][0].getIcon() == imgXjogo && btPos[2][0].getIcon() == imgXjogo
				|| btPos[0][1].getIcon() == imgXjogo && btPos[1][1].getIcon() == imgXjogo && btPos[2][1].getIcon() == imgXjogo
				|| btPos[0][2].getIcon() == imgXjogo && btPos[1][2].getIcon() == imgXjogo && btPos[2][2].getIcon() == imgXjogo
				|| btPos[0][0].getIcon() == imgXjogo && btPos[1][1].getIcon() == imgXjogo && btPos[2][2].getIcon() == imgXjogo
				|| btPos[0][2].getIcon() == imgXjogo && btPos[1][1].getIcon() == imgXjogo && btPos[2][0].getIcon() == imgXjogo) {
				winsX++;
				vencedor = 0;
				Win();
			}
			
			//o ganhando
			else if(btPos[0][0].getIcon() == imgOjogo && btPos[0][1].getIcon() == imgOjogo && btPos[0][2].getIcon() == imgOjogo
					|| btPos[1][0].getIcon() == imgOjogo && btPos[1][1].getIcon() == imgOjogo && btPos[1][2].getIcon() == imgOjogo
					|| btPos[2][0].getIcon() == imgOjogo && btPos[2][1].getIcon() == imgOjogo && btPos[2][2].getIcon() == imgOjogo
					|| btPos[0][0].getIcon() == imgOjogo && btPos[1][0].getIcon() == imgOjogo && btPos[2][0].getIcon() == imgOjogo
					|| btPos[0][1].getIcon() == imgOjogo && btPos[1][1].getIcon() == imgOjogo && btPos[2][1].getIcon() == imgOjogo
					|| btPos[0][2].getIcon() == imgOjogo && btPos[1][2].getIcon() == imgOjogo && btPos[2][2].getIcon() == imgOjogo
					|| btPos[0][0].getIcon() == imgOjogo && btPos[1][1].getIcon() == imgOjogo && btPos[2][2].getIcon() == imgOjogo
					|| btPos[0][2].getIcon() == imgOjogo && btPos[1][1].getIcon() == imgOjogo && btPos[2][0].getIcon() == imgOjogo) {
				winsO++;
				vencedor = 1;
				Win();
			}
			
			//Velha
			else {
				for(int i=0;i<3;i++) {
					for(int j=0;j<3;j++) {
						if(btPos[i][j].isEnabled()) {
						}else {
							nuloButton = nuloButton + 1;
						}
					}
				}
			}
			if(nuloButton == 9) {
				Velha();
			}
			lbWinsX.setText(nomeX+" Wins: "+winsX);
			lbWinsO.setText(nomeO+" Wins: "+winsO);
		}
	}
	
	private void Velha() {
		JOptionPane.showMessageDialog(this,"VELHA!", "Empate", JOptionPane.INFORMATION_MESSAGE);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				btPos[i][j].setIcon(null);
				btPos[i][j].setEnabled(true);
			}
		}
	}
	private void Win() {
		if(vencedor ==0) {
			nomeVencedor = nomeX;
		}else if(vencedor ==1) {
			nomeVencedor = nomeO;
		}
		JOptionPane.showMessageDialog(this,"Ganhador: "+nomeVencedor, "GANHADOR", JOptionPane.INFORMATION_MESSAGE);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				btPos[i][j].setIcon(null);
				btPos[i][j].setEnabled(true);
			}
		}
	}
	private void Reset() {
		winsX = 0;
		winsO = 0;
		lbWinsX.setText(nomeX+" Wins: "+winsX);
		lbWinsO.setText(nomeO+" Wins: "+winsO);
		JOptionPane.showMessageDialog(this,"Jogo reiniciado.", "Reiniciando Game", JOptionPane.INFORMATION_MESSAGE);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				btPos[i][j].setIcon(null);
				btPos[i][j].setEnabled(true);
			}
		}
	}
}