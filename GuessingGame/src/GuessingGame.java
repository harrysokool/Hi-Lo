import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int number;
	private int count = 1;
	
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);

			if (guess < number)
	            message = guess + " is too low. Try again.";
	        else if (guess > number)
	            message = guess + " is too high. Try again.";
	        else {
	            message = guess + " is correct. You win after " + count + " tries! Let's play again!";
	            count = 1;
	            newGame();
	        }
		} catch(Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			count++;
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	
	public void newGame() {
		number = (int) (Math.random() * 100 + 1);
	}
	
	public GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Harry's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(6, 78, 278, 30);
		getContentPane().add(lblNewLabel_1);
		
		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(6, 209, 438, 16);
		getContentPane().add(lblOutput);
		
		JLabel lblNewLabel = new JLabel("Harry's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 6, 438, 36);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(163, 144, 117, 29);
		getContentPane().add(btnNewButton);
		
		txtGuess = new JTextField();
		txtGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
		});
		txtGuess.setBounds(296, 80, 55, 26);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
	}

	public static void main(String[] args) {
		GuessingGame theGame = new GuessingGame();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
