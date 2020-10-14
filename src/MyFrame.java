
import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame
{
    private JPanel panel;
    private JButton[][] board = new JButton[3][3];
    private JMenuItem resetGame;
    private JMenuItem quitGame;
    private JMenu menu;
    private JMenuBar menuBar;
    private String currentPlayer;
    private int fullBoardCheck;


    public MyFrame ()
    {
        currentPlayer="X";
        fullBoardCheck = 0;
        setLayout(new BorderLayout());

        panel = new JPanel();
        panel.setLayout(new GridLayout(3,3));
        add(panel,BorderLayout.CENTER);

        createMenuBar();
        addButton();
    }

    public void addButton()
    {
        for (int i = 0; i <3 ; i++)
        {
            for (int j = 0; j <3; j++)
            {
                JButton button = new JButton("");
                button.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
                button.addActionListener(e ->
                {
                    if (!(button.getText().equals(""))){}

                    else
                    {
                        button.setText(currentPlayer);
                        button.setEnabled(false);
                        fullBoardCheck++;
                        hasWinner();
                        switchPlayer();
                    }
                });
                board[i][j]=button;
                panel.add(button);
            }
        }
    }

    public void hasWinner()
    {
        if (board[0][0].getText().equals(currentPlayer)&&board[0][1].getText().equals(currentPlayer)&&board[0][2].getText().equals(currentPlayer))
        {JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (board[1][0].getText().equals(currentPlayer)&&board[1][1].getText().equals(currentPlayer)&&board[1][2].getText().equals(currentPlayer))
        {JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (board[2][0].getText().equals(currentPlayer)&&board[2][1].getText().equals(currentPlayer)&&board[2][2].getText().equals(currentPlayer))
        {JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (board[0][0].getText().equals(currentPlayer)&&board[1][0].getText().equals(currentPlayer)&&board[2][0].getText().equals(currentPlayer))
        {JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (board[0][1].getText().equals(currentPlayer)&&board[1][1].getText().equals(currentPlayer)&&board[2][1].getText().equals(currentPlayer))
        {JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (board[0][2].getText().equals(currentPlayer)&&board[1][2].getText().equals(currentPlayer)&&board[2][2].getText().equals(currentPlayer))
        {JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (board[0][0].getText().equals(currentPlayer)&&board[1][1].getText().equals(currentPlayer)&&board[2][2].getText().equals(currentPlayer))
        {JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (board[0][2].getText().equals(currentPlayer)&&board[1][1].getText().equals(currentPlayer)&&board[2][0].getText().equals(currentPlayer))
        { JOptionPane.showMessageDialog(null,"Gracz "+currentPlayer+" wygrywa");resetBoard();}
        if (fullBoardCheck==9)
        {JOptionPane.showMessageDialog(null,"No winner");resetBoard();}
    }
    public void resetBoard()
    {
        for (int i = 0; i <3 ; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j].setText("");
                board[i][j].setEnabled(true);
            }
        }
        currentPlayer="O";
        fullBoardCheck=0;
    }
    public void switchPlayer()
    {
        if (currentPlayer.equals("X"))
        {
            currentPlayer="O";
        }
        else
        {
            currentPlayer="X";
        }
    }
    public void createMenuBar()
    {
        menuBar = new JMenuBar();
        menuBar.setBorder(BorderFactory.createEtchedBorder());
        setJMenuBar(menuBar);
        menu = new JMenu("File");
        menu.setMnemonic('F');
        menuBar.add(menu);
        resetGame = new JMenuItem("Reset");
        resetGame.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
        quitGame = new JMenuItem("Quit");
        quitGame.setAccelerator(KeyStroke.getKeyStroke("ctrl Q"));
        menu.add(resetGame);
        menu.add(quitGame);
        resetGame.addActionListener(e -> resetBoard());
        quitGame.addActionListener(e -> System.exit(0));
    }
}
