import java.awt.*;
import java.sql.*;
import java.util.StringTokenizer;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Test2 extends JFrame{
	private JPanel p_nord,p_centre, p_sud,p_est; 
    private TextArea tA;
    private String keeper;
    private StringTokenizer tAContent;
	private JMenuBar jmb;
    private JLabel l_Titre,statusLabel,testingLabel,testingLabel2;
    private Connection cn;
    private Statement st = null; 
    private ResultSet rs = null;
    private int selectedRows = 0;

	public Test2() {
		this.setTitle("ma fenetre"); 
        this.setLayout(new BorderLayout());
        this.setSize(1000, 1000);
		p_nord = new JPanel();
		l_Titre = new JLabel("TOP PANEL"); 
		l_Titre.setFont(new Font(null, Font.BOLD, 15)); 
		l_Titre.setForeground(Color.WHITE); 
		p_nord.setBackground(Color.darkGray); 
		p_nord.add(l_Titre); 
		this.add(p_nord, BorderLayout.NORTH);		
		p_centre = new JPanel(); 
        tA = new TextArea(100,100);
        //tAContent = new StringTokenizer(tA.getText());
        this.add(p_centre);
        p_sud = new JPanel();
        p_sud.setBackground(Color.LIGHT_GRAY);
        statusLabel = new JLabel();
        p_sud.add(statusLabel);
        this.add(p_sud, BorderLayout.SOUTH);
        p_est = new JPanel();
        testingLabel = new JLabel();
        testingLabel2 = new JLabel();
       // testingLabel.setText("MERCI");
        p_est.add(testingLabel);
        p_est.add(testingLabel2);
        this.add(p_est, BorderLayout.EAST);
    }
        public void showTextListenerDemo(){
            tA.addTextListener(new CustomTextListener());
            Button hiddenButton = new Button("hidden");
            hiddenButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                   // statusLabel.setText("Vous avez ecrit : "+tA.getText());
                    testingLabel.setText(" IS : "+tAContent.nextToken());
                   // testingLabel.setText("Vous avez ecrit : "+tA.getText());
                }
            });
            p_centre.add(tA);
            p_centre.add(hiddenButton);
            this.setVisible(true);
        }

		
		class CustomTextListener implements TextListener {
	      	public void textValueChanged(TextEvent e) {
        statusLabel.setText("Entered text: " + 			tA.getText());






         //if (statusLabel.getText().equals("MERCI")) {
            //testingLabel2.setText("SAME " + 			statusLabel.getText()); 
            tAContent = new StringTokenizer(tA.getText());



        String url = "jdbc:mysql://localhost/projet_java";
        String login = "root";
        String passwd = "";
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url, login, passwd);
            st = cn.createStatement();
            while(tAContent.hasMoreTokens()){
              //  testingLabel.setText(" IS : "+tAContent.nextToken());
            String sql = "SELECT renseigner FROM mot WHERE renseigner ='"+tAContent.nextToken()+"'";
            rs = st.executeQuery(sql);
              if(rs.next()){
                testingLabel2.setText(tAContent.nextToken()+" Est dedans");
            }
            else{
                testingLabel2.setText(tAContent.nextToken()+" est Inconnue");}
            }
            
        }
        catch(SQLException ep){
            ep.printStackTrace();
        }
        catch(ClassNotFoundException ep){
            ep.printStackTrace();
        }
        finally{
            try{
                cn.close();
                st.close();
            }
            catch (SQLException ep){
                ep.printStackTrace();
            }
        }

        /*    try {
                st = cn.createStatement();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            while(tAContent.hasMoreTokens()){
               
                String sql = "SELECT * FROM mot where mot LIKE "+tAContent.nextToken()+"%";
                try {
                    selectedRows = st.executeUpdate(sql);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (selectedRows < 1) {
                }
            }
         //}           
      }
   */
    }
    

    
	
}

}

