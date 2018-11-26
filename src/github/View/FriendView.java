package github.View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import github.Model.Friend;
import github.Model.FriendDBAImpl;

public class FriendView extends JFrame {
	private JPanel contentPane;
	private JSplitPane splitPane;
	private JPanel panel;
	private JLabel lblName;
	private JLabel lblBirth;
	private JLabel lblPhone;
	private JLabel lblAddress;
	private JTextField tfName;
	private JTextField tfBirth;
	private JTextField tfPhone;
	private JTextField tfAddress;
	private JButton viewBtn;
	private JButton addBtn;
	private JSplitPane splitPane_1;
	private JPanel panel_1;
	private JComboBox cb1;
	private JTextField ft1;
	private JButton searchBtn;
	private String url,user,pwd;
	
	FriendDBAImpl dba = new FriendDBAImpl();
	private JTextField tfNum;
	private JButton selectBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JScrollPane scrollPane;
	private JTextArea ta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FriendView frame = new FriendView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FriendView() {
		setTitle("친구 관리 프로그램");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 593);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(getSplitPane(), BorderLayout.CENTER);
	}

	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setLeftComponent(getPanel());
			splitPane.setRightComponent(getSplitPane_1());
			splitPane.setDividerLocation(280);
		}
		return splitPane;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBorder(new TitledBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), "\uCE5C\uAD6C\uB4F1\uB85D", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel.setLayout(null);
			panel.add(getLblName());
			panel.add(getLblBirth());
			panel.add(getLblPhone());
			panel.add(getLblAddress());
			panel.add(getTfName());
			panel.add(getTfBirth());
			panel.add(getTfPhone());
			panel.add(getTfAddress());
			panel.add(getViewBtn());
			panel.add(getAddBtn());
			panel.add(getTfNum());
			panel.add(getSelectBtn());
			panel.add(getUpdateBtn());
			panel.add(getButton_1());
		}
		return panel;
	}
	private JLabel getLblName() {
		if (lblName == null) {
			lblName = new JLabel("이름");
			lblName.setHorizontalAlignment(SwingConstants.RIGHT);
			lblName.setBounds(12, 43, 57, 15);
		}
		return lblName;
	}
	private JLabel getLblBirth() {
		if (lblBirth == null) {
			lblBirth = new JLabel("생일");
			lblBirth.setHorizontalAlignment(SwingConstants.RIGHT);
			lblBirth.setBounds(12, 96, 57, 15);
		}
		return lblBirth;
	}
	private JLabel getLblPhone() {
		if (lblPhone == null) {
			lblPhone = new JLabel("전화번호");
			lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPhone.setBounds(12, 146, 57, 15);
		}
		return lblPhone;
	}
	private JLabel getLblAddress() {
		if (lblAddress == null) {
			lblAddress = new JLabel("주소");
			lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAddress.setBounds(12, 193, 57, 15);
		}
		return lblAddress;
	}
	private JTextField getTfName() {
		if (tfName == null) {
			tfName = new JTextField();
			tfName.setBounds(81, 40, 147, 21);
			tfName.setColumns(10);
		}
		return tfName;
	}
	private JTextField getTfBirth() {
		if (tfBirth == null) {
			tfBirth = new JTextField();
			tfBirth.setBounds(81, 93, 147, 21);
			tfBirth.setColumns(10);
		}
		return tfBirth;
	}
	private JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setBounds(81, 143, 147, 21);
			tfPhone.setColumns(10);
		}
		return tfPhone;
	}
	private JTextField getTfAddress() {
		if (tfAddress == null) {
			tfAddress = new JTextField();
			tfAddress.setBounds(81, 190, 147, 21);
			tfAddress.setColumns(10);
		}
		return tfAddress;
	}
	private JButton getViewBtn() {
		if (viewBtn == null) {
			viewBtn = new JButton("전체보기");
			viewBtn.setToolTipText("친구 목록을 보려면 클릭하세요.");
			viewBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<Friend> arr = dba.friendView();
					ta.setText("");
					tfName.setText("");
					tfBirth.setText("");
					tfPhone.setText("");
					tfAddress.setText("");
					tfNum.setText("");
					ft1.setText("");
					for(Friend f : arr) {
						ta.append("번호 : " + f.getNum() + "\n");
						ta.append("이름 : " + f.getName() + "\n");
						ta.append("생일 : " + f.getBirth() + "\n");
						ta.append("전화번호 : " + f.getPhone() + "\n");
						ta.append("주소 : " + f.getAddr() + "\n\n");
					}
				}
			});
			viewBtn.setBounds(30, 248, 97, 23);
		}
		return viewBtn;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("추가");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Friend f = new Friend();
					
					f.setName(tfName.getText());
					f.setBirth(tfBirth.getText());
					f.setPhone(tfPhone.getText());
					f.setAddr(tfAddress.getText());
					
					dba.friendInsert(f);
					
					tfName.setText("");
					tfBirth.setText("");
					tfPhone.setText("");
					tfAddress.setText("");
					tfNum.setText("");
					ft1.setText("");
					
					viewBtn.doClick();
				}
			});
			addBtn.setBounds(139, 248, 97, 23);
		}
		return addBtn;
	}
	private JSplitPane getSplitPane_1() {
		if (splitPane_1 == null) {
			splitPane_1 = new JSplitPane();
			splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane_1.setRightComponent(getPanel_1());
			splitPane_1.setLeftComponent(getScrollPane());
			splitPane_1.setDividerLocation(330);
		}
		return splitPane_1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.add(getCb1());
			panel_1.add(getFt1());
			panel_1.add(getSearchBtn());
		}
		return panel_1;
	}
	private JComboBox getCb1() {
		if (cb1 == null) {
			cb1 = new JComboBox();
			cb1.setModel(new DefaultComboBoxModel(new String[] {"이름", "생일", "전화번호", "주소"}));
			cb1.setBounds(12, 46, 55, 21);
		}
		return cb1;
	}
	private JTextField getFt1() {
		if (ft1 == null) {
			ft1 = new JTextField();
			ft1.setBounds(79, 46, 131, 21);
			ft1.setColumns(10);
		}
		return ft1;
	}
	private JButton getSearchBtn() {
		if (searchBtn == null) {
			searchBtn = new JButton("검색");
			searchBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ta.setText("");
					ArrayList<Friend> arr = dba.friendSearch(ft1.getText(),cb1.getSelectedIndex());
					for(int i=0;i<arr.size();i++) {
						ta.append("번호 : " + arr.get(i).getNum() + "\n");
						ta.append("이름 : " + arr.get(i).getName() + "\n");
						ta.append("생일 : " + arr.get(i).getBirth() + "\n");
						ta.append("전화번호 : " + arr.get(i).getPhone() + "\n");
						ta.append("주소 : " + arr.get(i).getAddr() + "\n\n");
					}

				}
			});
			searchBtn.setBounds(222, 45, 65, 23);
		}
		return searchBtn;
	}
	private JTextField getTfNum() {
		if (tfNum == null) {
			tfNum = new JTextField();
			tfNum.setBounds(30, 296, 77, 21);
			tfNum.setColumns(10);
		}
		return tfNum;
	}
	//상세보기
	private JButton getSelectBtn() {
		if (selectBtn == null) {
			selectBtn = new JButton("상세보기");
			selectBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						int num = Integer.parseInt(tfNum.getText());
						Friend f = dba.friendSelect(num);
						tfName.setText(f.getName());
						tfBirth.setText(f.getBirth());
						tfPhone.setText(f.getPhone());
						tfAddress.setText(f.getAddr());
						updateBtn.setEnabled(true);
						deleteBtn.setEnabled(true);
					}
					catch(NumberFormatException a){
						JOptionPane.showMessageDialog(null,"숫자를 입력하세요.");
					}
					catch(NullPointerException e2) {
						JOptionPane.showMessageDialog(null,"찾는 친구가 없습니다.");
					}
					
				}
			});
			selectBtn.setBounds(119, 295, 97, 23);
		}
		return selectBtn;
	}
	private JButton getUpdateBtn() {
		if (updateBtn == null) {
			updateBtn = new JButton("수정");
			updateBtn.setEnabled(false);
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = tfName.getText();
					String birth = tfBirth.getText();
					String phone = tfPhone.getText();
					String addr = tfAddress.getText();
					int num = Integer.parseInt(tfNum.getText());
					Friend f = new Friend();
					f.setName(name);
					f.setBirth(birth);
					f.setPhone(phone);
					f.setAddr(addr);
					f.setNum(num);
					dba.friendUpdate(f);
					
					viewBtn.doClick();

				}
			});
			updateBtn.setBounds(30, 339, 97, 23);
		}
		return updateBtn;
	}
	private JButton getButton_1() {
		if (deleteBtn == null) {
			deleteBtn = new JButton("삭제");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int result = JOptionPane.showConfirmDialog(null, 
							"삭제 하시겠습니까?", "삭제", JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.YES_OPTION) {
						int num = Integer.parseInt(tfNum.getText());
						String sql = "delete from friend where num ="+num;
						dba.friendDelete(num);
						ta.setText("");
						viewBtn.doClick();

					}
				}
			});
			deleteBtn.setEnabled(false);
			deleteBtn.setBounds(139, 339, 97, 23);
		}
		return deleteBtn;
	}
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTa());
		}
		return scrollPane;
	}
	private JTextArea getTa() {
		if (ta == null) {
			ta = new JTextArea();
			ta.setEditable(false);
			ta.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "\uC804\uCCB4\uBCF4\uAE30", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		}
		return ta;
	}
}
