
import javax.swing.JOptionPane;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *Description: Address Book Program
 * @author Overrideveloper
 */

public class AddressBookUI extends javax.swing.JPanel{
	private static javax.swing.JTable jTable;
	private javax.swing.JScrollPane jScrollPane;
	private static javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private static int rowCnt = 0;
	private static int selectedRow;

	public AddressBookUI() {
		jTable = new javax.swing.JTable(new AbstractTable());

		//Table Column size
		javax.swing.table.TableColumn column = null;
		for(int i = 0; i < 4; i++) {
			column = jTable.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(100);
			} else if(i == 1) {
				column.setPreferredWidth(150);
			} else if(i == 3) {
				column.setPreferredWidth(100);
			} else {
				column.setPreferredWidth(10);
			}
		}

		jScrollPane = new javax.swing.JScrollPane(jTable);

		jPanel1 = new javax.swing.JPanel(new java.awt.BorderLayout());

		jPanel1.add(jScrollPane, java.awt.BorderLayout.CENTER);

		jButton1 = new javax.swing.JButton("Add Entry");
		jButton2 = new javax.swing.JButton("Update Entry");
		jButton3 = new javax.swing.JButton("Delete Entry");
		jButton4 = new javax.swing.JButton("Close");

		jPanel2 = new javax.swing.JPanel(new java.awt.FlowLayout());

		jPanel2.add(jButton1);
		jPanel2.add(jButton2);
		jPanel2.add(jButton3);
		jPanel2.add(jButton4);

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				new AddressBook_AddEntry().setVisible(true);
                                
			}
		});

		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				new AddressBook_UpdateEntry(jTable.getValueAt(getSelectedRow(), 0).toString(),
								jTable.getValueAt(getSelectedRow(), 1).toString(),
								jTable.getValueAt(getSelectedRow(), 2).toString(),
								jTable.getValueAt(getSelectedRow(), 3).toString()).setVisible(true);
			}
		});

		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				removeEntry();
			}
		});

		jButton4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				setVisible(true);
                                //JOptionPane.showConfirmDialog(null, "Do You Want To Exit?");
				System.exit(0);
			}
		});

		jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);
		jPanel1.setPreferredSize(new java.awt.Dimension(750, 300));

		add(jPanel1);
	}

	public static void addEntry(AddressBook addressBook) {
		jTable.setValueAt(addressBook.GetContactName(), rowCnt, 0);
		jTable.setValueAt(addressBook.GetContactAddress(), rowCnt, 1);
		jTable.setValueAt(addressBook.GetContactTel(), rowCnt, 2);
		jTable.setValueAt(addressBook.GetContactEmail(), rowCnt, 3);

		rowCnt++;
                JOptionPane.showMessageDialog(jPanel1, "Contact Has Been Succesfully Added");
	}

	public static void editEntry(AddressBook addressBook) {
		jTable.setValueAt(addressBook.GetContactName(), getSelectedRow(), 0);
		jTable.setValueAt(addressBook.GetContactAddress(), getSelectedRow(), 1);
		jTable.setValueAt(addressBook.GetContactTel(), getSelectedRow(), 2);
		jTable.setValueAt(addressBook.GetContactEmail(), getSelectedRow(), 3);
                
                JOptionPane.showMessageDialog(jPanel1, "Contact Has Been Succesfully Updated");
	}

	public void removeEntry() {
		for(int i = getSelectedRow(); i < rowCnt; i++) {
			jTable.setValueAt(jTable.getValueAt(i + 1, 0), i, 0);
			jTable.setValueAt(jTable.getValueAt(i + 1, 1), i, 1);
			jTable.setValueAt(jTable.getValueAt(i + 1, 2), i, 2);
			jTable.setValueAt(jTable.getValueAt(i + 1, 3), i, 3);
		}
		rowCnt--;
                JOptionPane.showMessageDialog(jPanel1, "Contact Has Been Succesfully Deleted");
	}

	public static int getSelectedRow() {
		jTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

		javax.swing.ListSelectionModel rowSel = jTable.getSelectionModel();
		rowSel.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
			public void valueChanged(javax.swing.event.ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) return;

                                
				javax.swing.ListSelectionModel sel = (javax.swing.ListSelectionModel)e.getSource();
				if (!sel.isSelectionEmpty()) {
					selectedRow = sel.getMinSelectionIndex();
				}
			}
		});

		return selectedRow;
	}

                class AbstractTable extends javax.swing.table.AbstractTableModel {
		private String[] columnNames = { "Contact Name", "Contact Address", "Contact Tel No.", "Contact Email" };
		private Object[][] data = new Object [100][5];

		public int getColumnCount() {
			return columnNames.length;
		}

		public int getRowCount() {
			return data.length;
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}

		public Object getValueAt(int row, int col) {
                        return data[row][col];
                        
		}

		public void setValueAt(Object value, int row, int col) {
			data[row][col] = value;
			fireTableCellUpdated(row, col);
                }
                
           }
        
       
	public static void main(String args[]) {
                            
		javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);

		javax.swing.JFrame jFrame = new javax.swing.JFrame("Address Book");

		jFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);

		jFrame.setResizable(true);
                
                //jFrame.setLocationRelativeTo(null);

		jFrame.getContentPane().add(new AddressBookUI());

		jFrame.pack();
		jFrame.setVisible(true);
                                
	}
}