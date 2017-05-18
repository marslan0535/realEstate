package presentation;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayoutInfo;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import dataAccessLayer.DataAccessLayer;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.SortOrder;

import domain.House;
import domain.Office;

public class EstateAgentGuiDesign {

	private Object[][] data ;
	
	private Office office;
	
	private JFrame frame;
	private JTable table;
	private JPanel rightFirstPanel, rightSecondPanel, rightThirdPanel, rightFourthPanel, searchPanelPriceValueEnterPanel, rightBiggestPanel;
	private JPanel SearchPanelRoomValueEnterPanel, searchPanelSizeValueEnterPanel;
	
	private JTextField textFieldAddHouseRoom, textFieldAddHousePrice, textFieldAddHouseSize, textFieldAddHouseBathroom,
						textFieldRemoveId, textFieldSearchMaxValue, textFieldSearchMinValue;
	
	private JButton btnAddHouse, btnRemoveHouse, btnAscendingOrder, btnDescendingOrder, btnSearch;
	private JRadioButton rdbtnByPrice, rdbtnByRoom, rdbtnBySize;
	private JLabel lblHouseId,labelMaxValue, labelMinValue, messageScreen;
	private JCheckBox checkBoxAddHouseAirConditioner;

	
	public EstateAgentGuiDesign(Office office) {
		this.office = office;
		startDesign();
	}

	public void startDesign(){
		frame = new JFrame();
		frame.setBounds(100, 100, 820, 620);
		frame.setMinimumSize(new Dimension(820, 620));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane jScrollPane= createTable();
		
		rightBiggestPanel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(jScrollPane, GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightBiggestPanel, GroupLayout.PREFERRED_SIZE, 260, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(jScrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
						.addComponent(rightBiggestPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		rightFirstPanel = new JPanel();
		
		rightSecondPanel = new JPanel();
		
		rightThirdPanel = new JPanel();
		
		rightFourthPanel = new JPanel();
		
		messageScreen = new JLabel("");
		messageScreen.setOpaque(true);
		messageScreen.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_RightBiggestPanel = new GroupLayout(rightBiggestPanel);
		gl_RightBiggestPanel.setHorizontalGroup(
			gl_RightBiggestPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RightBiggestPanel.createSequentialGroup()
					.addGroup(gl_RightBiggestPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_RightBiggestPanel.createSequentialGroup()
							.addGap(21)
							.addGroup(gl_RightBiggestPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(rightSecondPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)
								.addComponent(rightFirstPanel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_RightBiggestPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(rightThirdPanel, GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE))
						.addGroup(gl_RightBiggestPanel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_RightBiggestPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(messageScreen, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
								.addComponent(rightFourthPanel, GroupLayout.PREFERRED_SIZE, 230, Short.MAX_VALUE))))
					.addGap(9))
		);
		gl_RightBiggestPanel.setVerticalGroup(
			gl_RightBiggestPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_RightBiggestPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rightFirstPanel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightSecondPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightThirdPanel, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(rightFourthPanel, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(messageScreen, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
		);
		
		rdbtnByPrice = new JRadioButton("By Price");
		rdbtnByPrice.setSelected(true);
		
		rdbtnByRoom = new JRadioButton("By Room");
		
		rdbtnBySize = new JRadioButton("By Size");
		
		searchPanelPriceValueEnterPanel = new JPanel();
			
		textFieldSearchMaxValue = new JTextField();
		textFieldSearchMaxValue.setColumns(10);
				
		SearchPanelRoomValueEnterPanel = new JPanel();
		
		searchPanelSizeValueEnterPanel = new JPanel();
		
		labelMaxValue = new JLabel("Max Value");
		
		textFieldSearchMaxValue = new JTextField();
		textFieldSearchMaxValue.setColumns(10);
		
		labelMinValue = new JLabel("Min Value");
		
		textFieldSearchMinValue = new JTextField();
		textFieldSearchMinValue.setColumns(10);
		GroupLayout gl_searchPanelSizeValueEnterPanel = new GroupLayout(searchPanelSizeValueEnterPanel);
		gl_searchPanelSizeValueEnterPanel.setHorizontalGroup(
			gl_searchPanelSizeValueEnterPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 143, Short.MAX_VALUE)
				.addGroup(gl_searchPanelSizeValueEnterPanel.createSequentialGroup()
					.addGroup(gl_searchPanelSizeValueEnterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_searchPanelSizeValueEnterPanel.createSequentialGroup()
							.addComponent(labelMaxValue, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textFieldSearchMaxValue, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_searchPanelSizeValueEnterPanel.createSequentialGroup()
							.addComponent(labelMinValue, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
							.addGap(4)
							.addComponent(textFieldSearchMinValue, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_searchPanelSizeValueEnterPanel.setVerticalGroup(
			gl_searchPanelSizeValueEnterPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 52, Short.MAX_VALUE)
				.addGroup(gl_searchPanelSizeValueEnterPanel.createSequentialGroup()
					.addGroup(gl_searchPanelSizeValueEnterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_searchPanelSizeValueEnterPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(labelMaxValue))
						.addComponent(textFieldSearchMaxValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_searchPanelSizeValueEnterPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_searchPanelSizeValueEnterPanel.createSequentialGroup()
							.addGap(3)
							.addComponent(labelMinValue))
						.addComponent(textFieldSearchMinValue, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		searchPanelSizeValueEnterPanel.setLayout(gl_searchPanelSizeValueEnterPanel);
		
		btnSearch = new JButton("Search");
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnByPrice);
		buttonGroup.add(rdbtnBySize);
		buttonGroup.add(rdbtnByRoom);
		
		
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = -1;
				if(rdbtnByPrice.isSelected()){
					row=1;
				}else if (rdbtnByRoom.isSelected()){
					row = 3;
				}else if (rdbtnBySize.isSelected()){
					row = 2;
				}
				
				try{
					int minValue= Integer.parseInt(textFieldSearchMinValue.getText());
					int maxValue= Integer.parseInt(textFieldSearchMaxValue.getText());
					if (maxValue>=minValue)
						newFilter(minValue, maxValue, row);
					else
						throw new Exception("");
				}catch (Exception e) {
					System.out.println(e.getMessage());
					messageScreen.setText("Invalid Input");
					messageScreen.setBackground(Color.RED);
				}
				
				
			}
		});JButton btnWriteThisTable = new JButton("Write This Table");
		btnWriteThisTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					DataAccessLayer data = new DataAccessLayer(table, "housing_updated");
					messageScreen.setBackground(Color.GREEN);
					messageScreen.setText("File Succefully Wrote!");
				} catch (IOException e1) {
					messageScreen.setBackground(Color.RED);
					messageScreen.setText(e1.getMessage());
				}
				
			}
		});
		GroupLayout gl_rightFourthPanel = new GroupLayout(rightFourthPanel);
		gl_rightFourthPanel.setHorizontalGroup(
			gl_rightFourthPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightFourthPanel.createSequentialGroup()
					.addGroup(gl_rightFourthPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rightFourthPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(searchPanelSizeValueEnterPanel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_rightFourthPanel.createSequentialGroup()
							.addGap(5)
							.addComponent(rdbtnByPrice)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnByRoom, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(rdbtnBySize, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(66))
						.addGroup(gl_rightFourthPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnWriteThisTable, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_rightFourthPanel.setVerticalGroup(
			gl_rightFourthPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_rightFourthPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_rightFourthPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnByPrice)
						.addComponent(rdbtnByRoom)
						.addComponent(rdbtnBySize))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(searchPanelSizeValueEnterPanel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnSearch)
					.addGap(18)
					.addComponent(btnWriteThisTable)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		rightFourthPanel.setLayout(gl_rightFourthPanel);
		
		JRadioButton rdbtnOrderByPrice = new JRadioButton("By  Price");
		rdbtnOrderByPrice.setSelected(true);
		
		JRadioButton rdbtnOrderByRoomNumber = new JRadioButton("By Room Number");
		
		JRadioButton rdbtnOrderBySize = new JRadioButton("By Size");
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnOrderByPrice);
		group.add(rdbtnOrderByRoomNumber);
		group.add(rdbtnOrderBySize);
		
		btnAscendingOrder = new JButton("Ascending Order");
		btnAscendingOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnOrderByPrice.isSelected()) {
					try {

						TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
						table.setRowSorter(sorter);
						
						List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
						sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
						sorter.setSortKeys(sortKeys);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				} else if (rdbtnOrderBySize.isSelected()){
					try {

						TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
						table.setRowSorter(sorter);
						
						List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
						sortKeys.add(new RowSorter.SortKey(2, SortOrder.ASCENDING));
						sorter.setSortKeys(sortKeys);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}else if (rdbtnOrderByRoomNumber.isSelected()){
					try {

						TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
						table.setRowSorter(sorter);
						
						List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
						sortKeys.add(new RowSorter.SortKey(3, SortOrder.ASCENDING));
						sorter.setSortKeys(sortKeys);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}					
				}
				
			}
		});
		
		btnDescendingOrder = new JButton("Descending Order");
		btnDescendingOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (rdbtnOrderByPrice.isSelected()) {
					try {

						TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
						table.setRowSorter(sorter);
						
						List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
						sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
						sorter.setSortKeys(sortKeys);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				} else if (rdbtnOrderBySize.isSelected()){
					try {
						
						TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
						table.setRowSorter(sorter);
						
						List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
						sortKeys.add(new RowSorter.SortKey(2, SortOrder.DESCENDING));
						sorter.setSortKeys(sortKeys);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
				}else if (rdbtnOrderByRoomNumber.isSelected()){
					try {
						TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
						table.setRowSorter(sorter);
						
						List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
						sortKeys.add(new RowSorter.SortKey(3, SortOrder.DESCENDING));
						sorter.setSortKeys(sortKeys);
						
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}					
				}
			

				
			}
		});
		GroupLayout gl_rightThirdPanel = new GroupLayout(rightThirdPanel);
		gl_rightThirdPanel.setHorizontalGroup(
			gl_rightThirdPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rightThirdPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_rightThirdPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnOrderByPrice)
						.addComponent(rdbtnOrderByRoomNumber)
						.addComponent(rdbtnOrderBySize))
					.addGap(122))
				.addGroup(Alignment.LEADING, gl_rightThirdPanel.createSequentialGroup()
					.addComponent(btnAscendingOrder, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_rightThirdPanel.createSequentialGroup()
					.addComponent(btnDescendingOrder, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_rightThirdPanel.setVerticalGroup(
			gl_rightThirdPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightThirdPanel.createSequentialGroup()
					.addComponent(rdbtnOrderByPrice)
					.addComponent(rdbtnOrderByRoomNumber)
					.addComponent(rdbtnOrderBySize)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnAscendingOrder)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDescendingOrder)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		rightThirdPanel.setLayout(gl_rightThirdPanel);
		
		textFieldRemoveId = new JTextField();
		textFieldRemoveId.setColumns(10);
		
		btnRemoveHouse = new JButton("Remove House");
		btnRemoveHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int houseId= -1;
				try{
					boolean deleted = false;
					houseId = Integer.parseInt(textFieldRemoveId.getText());
					for (int i=0; i<office.getHouseList().size();i++) {
						if(office.getHouseList().get(i).getId() == houseId-1){
							office.getHouseList().remove(i);
							deleted = true;
						}
					}
					
					for (int i =0; i< table.getModel().getRowCount() ; i++) {
						if (new Integer(houseId).equals(Integer.parseInt((String)table.getModel().getValueAt(i, 0)))){
							((DefaultTableModel) table.getModel()).removeRow(i);
						}
					}
					if (deleted) {
						messageScreen.setText("House removed succesfully");
						messageScreen.setBackground(Color.GREEN);						
					}else{
						messageScreen.setBackground(Color.RED);
						textFieldRemoveId.setBackground(Color.RED);
						messageScreen.setText("There is not such an ID.");
					}
				}catch(Exception e2){
					messageScreen.setBackground(Color.RED);
					System.out.println(e2.getMessage());
					textFieldRemoveId.setBackground(Color.RED);
				}
			}
		});
		
		lblHouseId = new JLabel("House Id");
		GroupLayout gl_rightSecondPanel = new GroupLayout(rightSecondPanel);
		gl_rightSecondPanel.setHorizontalGroup(
			gl_rightSecondPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_rightSecondPanel.createSequentialGroup()
					.addGroup(gl_rightSecondPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rightSecondPanel.createSequentialGroup()
							.addComponent(lblHouseId, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textFieldRemoveId, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnRemoveHouse, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_rightSecondPanel.setVerticalGroup(
			gl_rightSecondPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightSecondPanel.createSequentialGroup()
					.addGroup(gl_rightSecondPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFieldRemoveId, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHouseId))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRemoveHouse)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		rightSecondPanel.setLayout(gl_rightSecondPanel);
		

		textFieldAddHouseRoom = new JTextField();
		textFieldAddHouseRoom.setToolTipText("Room Number");
		
		textFieldAddHouseRoom.setColumns(10);

		textFieldAddHousePrice = new JTextField();
		textFieldAddHousePrice.setColumns(10);

		textFieldAddHouseBathroom = new JTextField();
		textFieldAddHouseBathroom.setColumns(10);
		
		checkBoxAddHouseAirConditioner = new JCheckBox("Is There Air Conditioner");
		
		textFieldAddHouseSize = new JTextField();
		textFieldAddHouseSize.setColumns(10);
		
		btnAddHouse = new JButton("Add House");
		btnAddHouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JComponent[] inputs = new JComponent[] {
				        new JLabel("Number Of Room"),
				        textFieldAddHouseRoom,
				        new JLabel("House Size"),
				        textFieldAddHouseSize,
				        new JLabel("Number of Bathroom"),
				        textFieldAddHouseBathroom,
				        checkBoxAddHouseAirConditioner,
				        new JLabel("House Price"),
				        textFieldAddHousePrice,
				        
				};
				int result = JOptionPane.showConfirmDialog(null, inputs, "Add New House", JOptionPane.PLAIN_MESSAGE);
				if (result == JOptionPane.OK_OPTION) {
					int housePrice=0;
					int houseRoom=0;
					int houseSize=0;
					int houseBathroom=0;
					boolean isOkay = true;
					try{
						houseRoom = Integer.parseInt(textFieldAddHouseRoom.getText());
					}catch (Exception e) {
						messageScreen.setBackground(Color.RED);
						messageScreen.setText("Invalid Input");
						isOkay = false;
					}
					
					try{
						housePrice = Integer.parseInt(textFieldAddHousePrice.getText());
					}catch (Exception e) {
						messageScreen.setBackground(Color.RED);
						messageScreen.setText("Invalid Input");
						isOkay = false;
					}	
					
					try{
						houseBathroom = Integer.parseInt(textFieldAddHouseBathroom.getText());
					}catch (Exception e) {
						messageScreen.setBackground(Color.RED);
						messageScreen.setText("Invalid Input");
						isOkay = false;
					}				

					try{
						houseSize = Integer.parseInt(textFieldAddHouseSize.getText());
					}catch (Exception e) {
						messageScreen.setBackground(Color.RED);
						messageScreen.setText("Invalid Input");
						isOkay = false;
					}
					if (isOkay) {
						House house = new House(housePrice, houseRoom, houseSize, houseBathroom, checkBoxAddHouseAirConditioner.isSelected());
						office.addHouse(house);
						messageScreen.setText("House added succesfully\n With ID: "+(house.getId()+1));
						messageScreen.setBackground(Color.GREEN);
						
						((DefaultTableModel) table.getModel()).addRow(new Object[]{office.getHouseList().get(office.getHouseList().size()-1).getId()+1, textFieldAddHousePrice.getText(),
								textFieldAddHouseSize.getText(), textFieldAddHouseRoom.getText(), textFieldAddHouseBathroom.getText(), checkBoxAddHouseAirConditioner.isSelected()});
						
					}
				}

			}
		});
		
		GroupLayout gl_rightFirstPanel = new GroupLayout(rightFirstPanel);
		gl_rightFirstPanel.setHorizontalGroup(
			gl_rightFirstPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_rightFirstPanel.createSequentialGroup()
					.addComponent(btnAddHouse, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		gl_rightFirstPanel.setVerticalGroup(
			gl_rightFirstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightFirstPanel.createSequentialGroup()
					.addComponent(btnAddHouse)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		rightFirstPanel.setLayout(gl_rightFirstPanel);
		rightBiggestPanel.setLayout(gl_RightBiggestPanel);
		frame.getContentPane().setLayout(groupLayout);
		
		frame.setVisible(true);
	}

	private JScrollPane createTable() {
		String[] columnNames = {"ID",
	            "PRICE",
	            "SIZE",
	            "ROOMs",
	            "BATHROOMs",
	            "A\DDR COND\DDT\DDONER"};
		
		data = new Object[office.getHouseList().size()][6];
		for (int i =0 ; i<office.getHouseList().size(); i++) {
			if(office.getHouseList().get(i).getId() < 9)
				data[i][0] = "0"+(office.getHouseList().get(i).getId()+1);
			else
				data[i][0] = String.valueOf(office.getHouseList().get(i).getId()+1);
			data[i][1] = (Integer)office.getHouseList().get(i).getPrice();
			data[i][2] = (Integer)office.getHouseList().get(i).getSize();
			data[i][3] = (Integer)office.getHouseList().get(i).getRoom();
			data[i][4] = (Integer)office.getHouseList().get(i).getBathroom();
			data[i][5] = office.getHouseList().get(i).isAirConditioner();
		}
		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		table = new JTable(dtm);
		table.setEnabled(false);
		table.setDragEnabled(false);
		for (int i=0; i<6;i++){
			table.getColumnModel().getColumn(i).setResizable(false);
		}
		
		
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		
		return scrollPane;
		
	}

	private void newFilter(int min, int max, int row) {
		for (int i =0; i< table.getModel().getRowCount() ; i++) {
			((DefaultTableModel) table.getModel()).removeRow(i);
			i--;
		}
		for(int i = 0; i<office.getHouseList().size(); i++){
			int listValue =0;
			switch (row) {
			case 1:
				listValue = office.getHouseList().get(i).getPrice();
				break;
			case 2:
				listValue = office.getHouseList().get(i).getSize();
				break;
			case 3:
				listValue = office.getHouseList().get(i).getRoom();
				break;
			}
			if (min <= listValue && max >= listValue){
				
				Object[] rowData = new Object[6];
				rowData[0] = String.valueOf(office.getHouseList().get(i).getId()+1);
				rowData[1] = office.getHouseList().get(i).getPrice();
				rowData[2] = office.getHouseList().get(i).getSize();
				rowData[3] = office.getHouseList().get(i).getRoom();
				rowData[4] = office.getHouseList().get(i).getBathroom();
				rowData[5] = office.getHouseList().get(i).isAirConditioner();
				
				((DefaultTableModel) table.getModel()).addRow(rowData);
			}
		}
		
	}
}
