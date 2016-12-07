/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Overrideveloper
 */
public class AddressBook_AddEntry extends javax.swing.JFrame{
    
    private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JPanel jPanel3;
	private javax.swing.JPanel jPanel4;
	private javax.swing.JPanel jPanel5;

	public AddressBook_AddEntry(){
		super("Add Entry");

		setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);

		setResizable(true);

		jLabel1 = new javax.swing.JLabel("Contact Name: ");
		jLabel2 = new javax.swing.JLabel("Contact Address: ");
		jLabel3 = new javax.swing.JLabel("Contact Tel. No.: ");
		jLabel4 = new javax.swing.JLabel("Contact Email: ");

		jTextField1 = new javax.swing.JTextField(15);
		jTextField2 = new javax.swing.JTextField(30);
		jTextField3 = new javax.swing.JTextField(10);
		jTextField4 = new javax.swing.JTextField(15);
		jButton1 = new javax.swing.JButton("Add Entry");
		jButton2 = new javax.swing.JButton("Cancel");

		jPanel1 = new javax.swing.JPanel(new java.awt.GridLayout(4,1,1,5));

		jPanel1.add(jLabel1);
		jPanel1.add(jLabel2);
		jPanel1.add(jLabel3);
		jPanel1.add(jLabel4);

		jPanel2 = new javax.swing.JPanel(new java.awt.GridLayout(4, 1));

		jPanel2.add(jTextField1);
		jPanel2.add(jTextField2);
		jPanel2.add(jTextField3);
		jPanel2.add(jTextField4);

		jPanel3 = new javax.swing.JPanel(new java.awt.FlowLayout());

		jPanel3.add(jPanel1);
		jPanel3.add(jPanel2);

		jPanel4 = new javax.swing.JPanel(new java.awt.FlowLayout());

		jPanel4.add(jButton1);
		jPanel4.add(jButton2);
		
		jButton1.addActionListener(new java.awt.event.ActionListener() {   
			public void actionPerformed(java.awt.event.ActionEvent e) {  
				AddressBookUI.addEntry(new AddressBook(jTextField1.getText(), jTextField2.getText(), jTextField3.getText(), jTextField4.getText()));
			} 
		});
		
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(true);
				dispose();
			}
		});  
		
		
		jPanel5 = new javax.swing.JPanel(new java.awt.BorderLayout());  
		jPanel5.add(jPanel3, java.awt.BorderLayout.CENTER);  
		jPanel5.add(jPanel4, java.awt.BorderLayout.SOUTH);  
		getContentPane().add(jPanel5);  
		pack();  
		setVisible(true);
        }
		public static void main(String args[]){
			javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
			new AddressBook_AddEntry().setVisible(true);
	}					
}
