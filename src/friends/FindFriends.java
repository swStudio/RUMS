package friends;
/**
 * �����û��ĶԻ���������ʾ�û�����Ҫ���ҵ��û���ѧ��
 */
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import client.ClientPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindFriends extends JDialog implements ActionListener {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel1 = new JPanel();
    JLabel infoLabel = new JLabel();
    JTextField userIdField = new JTextField();
    JButton findButton = new JButton();
    JPanel findPane = new JPanel();
    Border border1 = BorderFactory.createLineBorder(UIManager.getColor(
            "InternalFrame.inactiveTitleBackground"), 1);
    FlowLayout flowLayout1 = new FlowLayout();

    ClientPanel mainFrame = null;
    
    BorderLayout borderLayout1 = new BorderLayout();

    public FindFriends(JFrame owner, String title, boolean modal) {
        super(owner, title, modal);
    
        try {
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            InitialDialog();
            pack();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public FindFriends() {
        super(new JFrame(), "FindFriends", false, null);
    }

    private void InitialDialog() throws Exception {
        border1 = new TitledBorder(BorderFactory.createLineBorder(new Color(122,
                150, 223), 1), "�����û�");
        panel1.setLayout(borderLayout1);
        infoLabel.setText("��������Ҫ���ҵ�ѧ�ţ�");
        userIdField.setColumns(10);
        userIdField.addActionListener(this);
        findButton.setText("����");
        findButton.addActionListener(this);
        findPane.setLayout(flowLayout1);
        findPane.setBorder(border1);
        panel1.setBorder(null);
        getContentPane().add(panel1);
        findPane.add(infoLabel, null);
        findPane.add(userIdField, null);
        findPane.add(findButton, null);
        panel1.add(findPane, java.awt.BorderLayout.CENTER);
        pack();
    }

    public boolean isNum(String text) { //�ж������Ƿ�Ϊ����
        boolean error = false;
        try {
            Integer.parseInt(text);     //�������׳��쳣
        } catch (Exception e) {
            error = true;
        }
        if (error) {
            return false;              //��ʾ������
        } else {
            return true;               //��ʾ������
        }
    }

    public void findButton_actionPerformed(ActionEvent e) {
        String info = userIdField.getText().trim();
        if(info.equals("")||info == null){
            JOptionPane.showMessageDialog(this, "��������Ҫ���ҵ��û���ѧ��!");
        }else if(isNum(info)){
            this.setVisible(false);
            mainFrame.FindUsers(Integer.parseInt(info));
        } else {
            JOptionPane.showMessageDialog(this, "�Բ���,�������ѧ������!");
        }
    }

    public void userIdField_actionPerformed(ActionEvent e) {
    	findButton.doClick();
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == userIdField)
        	userIdField_actionPerformed(e);
        else if (e.getSource() == findButton)
        	findButton_actionPerformed(e);
    }  
    
    public static void main(String[] args) throws Exception {
    	FindFriends findFriends = new FindFriends();
    	findFriends.setVisible(true);
    	findFriends.InitialDialog();
    	findFriends.setLocation(500, 250);
	}
}