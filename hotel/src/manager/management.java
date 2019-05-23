package manager;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import dataBaseOperation.Operation;

//import java.sql.Date;

public class management extends JFrame {//������

	JPanel p2 = new JPanel();//�����
	JLabel label = new JLabel();//ͼ�� �ı���
	JLabel label2 = new JLabel();

	public int Countdays = 0;// ��ס����
	JButton btnBook = new JButton("Ԥ��");
	JButton btnRegister = new JButton("�Ǽ�");
	JButton btnAboutRoom = new JButton("������Ϣ");
	JButton btnChangeRoom = new JButton("������");
	JButton btnOtherService = new JButton("��������");
	JButton btnShowConsumption = new JButton("��������");
	JButton btnCheckOut = new JButton("����");

	static String sStartDate = null;// ��¼String������
	static String sEndDate = null;// ��¼String������
	static String sTempDate = null;// ע��������ʱ��¼�ַ���������

	static Date dStartDate = null;
	static Date dEndDate = null;
	static Date dTempDate = null;// ע��������ʱ��¼Date������

	public management() {
		setLayout(new GridLayout(3, 3));
		// add(btnBook);
		// add(btnRegister);
		// add(btnAboutRoom);
		// add(btnChangeRoom);
		// add(btnOtherService);
		// add(btnFind);
		setLayout(new GridLayout(1, 2));
		label.setIcon(new ImageIcon("src/image/new1.jpg"));
		label2.setIcon(new ImageIcon("src/image/user1.jpg"));
		// label.setIcon(new ImageIcon("src/image/new.jpg"));
		add(label);
		add(p2);
		p2.setLayout(new GridLayout(4, 2));
		p2.add(btnBook);
		p2.add(btnRegister);
		p2.add(btnAboutRoom);
		p2.add(btnChangeRoom);
		p2.add(btnOtherService);
		p2.add(btnShowConsumption);
		p2.add(btnCheckOut);
		p2.add(label2);
		// Ԥ�� ��ť
		btnBook.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JFrame f = new JFrame("Motel �Ƶ����������Ԥ��");
				// f.setUndecorated(true);
				f.setLayout(new GridLayout(7, 1));

				final JTextField txtSingleOrDouble = new JTextField("");
				final JTextField txtName = new JTextField("����");
				final JTextField txtPhone = new JTextField("�绰");
				final JTextField txtIDNumber = new JTextField("���֤����");
				final JRadioButton singleRoom;
				final JRadioButton doubleRoom;
				singleRoom = new JRadioButton("singleRoom");
				doubleRoom = new JRadioButton("doubleRoom");
				ButtonGroup group = new ButtonGroup();
				group.add(singleRoom);
				group.add(doubleRoom);
				// final JTextField txtPhoneNUmber = new JTextField(" �绰����");
				final JTextField txtStartDate = new JTextField("��ס��ʼ����");// ��ֻ����ʾ�������ǲ����㴫�ݸ����ݿ�ģ��ҵö�������2��Date������¼ʱ��
				final JTextField txtEndDate = new JTextField("��ס��������");
				final JButton btnChooseDate = new JButton("ѡ��ʼ����");
				final JButton btnChooseDate2 = new JButton("ѡ���������");
				JButton btnOK = new JButton();

				btnOK.setText("ȷ��");
				btnOK.setFont(new Font("׭��", Font.CENTER_BASELINE, 11));
				// btnOK.setBackground(Color.lightGray);
				// btnChooseDate.setBackground(Color.lightGray);
				// btnChooseDate2.setBackground(Color.lightGray);

				// ��RadioGroup�����¼�����

				// group.setOnCheckedChangeListener(new
				// ButtonGroup.OnCheckedChangeListener() {
				// @Override
				// public void onCheckedChanged(ButtonGroup group, int
				// checkedId) {
				// // TODO Auto-generated method stub
				// if(checkedId==singleRoom.getId()){
				// //editText1.setText("���˷�");
				// }else if(checkedId==doubleRoom.getId()){
				// //editText1.setText("˫�˷�");
				// }
				// }
				// });
				singleRoom.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getSource() == singleRoom) {
							txtSingleOrDouble.setText("singleRoom");
						}
					}
				});
				doubleRoom.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent e) {
						if (e.getSource() == doubleRoom) {
							txtSingleOrDouble.setText("doubleRoom");
						}
					}
				});

				// txtName.setBackground(Color.lightGray);
				// txtPhone.setBackground(Color.lightGray);
				// txtIDNumber.setBackground(Color.lightGray);
				// txtStartDate.setBackground(Color.lightGray);
				// txtEndDate.setBackground(Color.lightGray);

				JPanel p1 = new JPanel(new GridLayout(1, 2));
				JPanel p2 = new JPanel(new GridLayout(1, 2));
				add(p1);
				p1.add(btnChooseDate);
				p1.add(txtStartDate);

				add(p2);
				p2.add(btnChooseDate2);
				p2.add(txtEndDate);

				f.add(txtName);
				f.add(txtPhone);
				f.add(txtIDNumber);

				JPanel p3 = new JPanel(new GridLayout(1, 2));

				p3.add(singleRoom);
				p3.add(doubleRoom);
				f.add(p3);
				f.add(p1);
				f.add(p2);

				JPanel p4 = new JPanel();
				p4.add(btnOK);
				f.add(p4);

				f.setSize(250, 230);
				f.setVisible(true);

				// ѡ��ʼ����
				btnChooseDate.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						JFrame frame = new JFrame("ѡ��ʼ����");
						JPanel cp = new JPanel();
						DateChooserJButton button = new DateChooserJButton();
						button.setSize(100, 100);
						cp.add(button);
						frame.setContentPane(cp);
						frame.setSize(200, 200);
						frame.setVisible(true);
						// btnChooseDate.setText("Nihao");

						/*
						 * ��ǰ����Ϊ������ھͻ�õ����㣬��������ҳ��ͻ�ʧȥ���� ���������ʱ���ı���ֵ
						 */
						frame.addWindowFocusListener(new WindowFocusListener() {

							public void windowLostFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								// txtStartDate.setText("��ס��ʼ����Ϊ:"+"\n"+dStartDate+"\n"+sStartDate);
								dStartDate = dTempDate;
								sStartDate = sTempDate;// ������ݽ�����¼�����ݿ�
								txtStartDate.setText(sTempDate);
								System.out.println("��ʼ����" + sStartDate);
								System.out.println(sTempDate);
							}

							public void windowGainedFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								System.out.println("�õ�����");
							}
						});
					}
				});

				// ѡ����ס��������
				btnChooseDate2.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						JFrame frame = new JFrame("ѡ���������");
						JPanel cp = new JPanel();
						DateChooserJButton button = new DateChooserJButton();
						button.setSize(100, 100);
						cp.add(button);
						frame.setContentPane(cp);
						frame.setSize(200, 200);
						frame.setVisible(true);
						// btnChooseDate.setText("Nihao");

						/*
						 * ��ǰ����Ϊ������ھͻ�õ����㣬��������ҳ��ͻ�ʧȥ���� ���������ʱ���ı���ֵ
						 */
						frame.addWindowFocusListener(new WindowFocusListener() {

							public void windowLostFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								dEndDate = dTempDate;
								sEndDate = sTempDate;// ������ݽ�����¼�����ݿ�
								txtEndDate.setText(sTempDate);// ��ʾѡ��õ�ʱ��
								System.out.println("��������" + sEndDate);
								System.out.println(sTempDate);
							}

							public void windowGainedFocus(WindowEvent arg0) {
								// TODO Auto-generated method stub
								System.out.println("�õ�����");
							}
						});
					}
				});
				/**
				 * 1.Ԥ���������ݿ�customer�����µ�һ�У�д��˿�����������ţ����֤��
				 * 2.�Լ���roominfor����Ķ�Ӧ�����״̬
				 * 3.��consumption�м���һ��ס�����ѡ����ﻹ��ס�޵�������ʱ�䡣
				 * */
				btnOK.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						// TODO Auto-generated method stub
						try {
							final String name = txtName.getText().toString();

							final String IDnumber = txtIDNumber.getText()
									.toString();
							final String phoneNumber = txtPhone.getText()
									.toString();
							final String SingleOrDouble = txtSingleOrDouble
									.getText().toString();

							// Ԥ���������ݿ�customer�����µ�һ�У�д��˿�����������ţ����֤
							// �Ҳ�֪������ô����Date����ת���ˣ���������������ݿ⣬��Ϊ��String�ʹ洢����
							// �����ס����
							Countdays = (int) ((dEndDate.getTime() - dStartDate
									.getTime()) / 1000 / 60 / 60 / 24);
							Operation.insertCustomerInfor(name, IDnumber,
									sStartDate, sEndDate, Countdays,
									phoneNumber, SingleOrDouble);

							// System.out.println("ס��ô���죺"+(dEndDate.getTime()-dStartDate.getTime())/1000/60/60/24);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				});
			}
		});
		// Ԥ����Ǽ�
		btnRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				f.setLayout(new GridLayout(3, 2));
				f.setSize(400, 300);
				f.setVisible(true);

				Vector vName = new Vector();
				Vector vRoomNumber = new Vector();
				try {
					vName = Operation.getName();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				for (int i = 1; i <= 13; i++)
					for (int j = 1; j <= 20; j++) {
						vRoomNumber.add("" + (i * 100 + j));
					}

				// �ؼ�
				final JList listName = new JList(vName);
				JScrollPane scrollPaneListName = new JScrollPane();
				scrollPaneListName.setViewportView(listName);// ��listName���ڿɹ������scrollPane����
				final JTextField txtName = new JTextField("����");

				final JList listRoomNumber = new JList(vRoomNumber);
				final JTextField txtRoomNumber = new JTextField(" ����");
				listRoomNumber.setLayoutOrientation(JList.HORIZONTAL_WRAP);// ˮƽ����
				listRoomNumber
						.setFont(new Font("׭��", Font.CENTER_BASELINE, 15));
				listRoomNumber.setVisibleRowCount(13);// ����
				JScrollPane scrollPane2 = new JScrollPane();
				scrollPane2.setViewportView(listRoomNumber);
				// scrollPane2.getViewport().setBackground(Color.magenta);//
				// ���ù��������ɫ��ע�ⲻ��ֱ��setBackground
				JScrollBar bar = scrollPane2.getHorizontalScrollBar();
				JScrollBar bar2 = scrollPane2.getVerticalScrollBar();
				// bar.setBackground(Color.CYAN);// ���ù�������ɫ
				// bar2.setBackground(Color.CYAN);// ���ù�������ɫ

				// ���Ѿ�Ԥ���Ŀͻ���������ʾ������б����棬������Ԥ����Ǽǵ�ʱ��Ͳ��������ˣ�ֱ�������ѡ�񼴿�

				/*
				 * http://blog.csdn.net/andycpp/article/details/1737658 JList�÷�
				 */

				JButton btnOK = new JButton("OK");

				txtRoomNumber.setFont(new Font("׭��", Font.CENTER_BASELINE, 90));// ��������
				// txtRoomNumber.setBackground(Color.CYAN);
				// txtName.setFont(new Font("׭��", Font.CENTER_BASELINE, 40));//
				// ��������
				// txtName.setBackground(Color.CYAN);
				// scrollPane2.setViewportView(listRoomNumber);// ����ʾ����

				listRoomNumber
						.addListSelectionListener(new ListSelectionListener() {

							public void valueChanged(ListSelectionEvent arg0) {
								txtRoomNumber.setText(""
										+ listRoomNumber.getSelectedValue());
							}
						});
				listName.addListSelectionListener(new ListSelectionListener() {

					public void valueChanged(ListSelectionEvent arg0) {
						// JOptionPane.showMessageDialog(this, "��ϲ����С˵��"
						// +listName.getSelectedValue());
						// System.out.println("" +listName.getSelectedValue());
						txtName.setText("" + listName.getSelectedValue());
					}
				});
				f.add(scrollPaneListName);
				f.add(txtName);

				f.add(scrollPane2);
				f.add(txtRoomNumber);
				f.add(btnOK);

				// �޸�isHasRegister����
				btnOK.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						String name = txtName.getText().toString();
						final String roomNumber = txtRoomNumber.getText()
								.toString();
						try {
							Operation.updateWhenRegister(name);
							Operation.updateWhenRegister(name, roomNumber);
							// ��roominfor����Ķ�Ӧ�����״̬�����м�¼��������
							Operation.insertChangeRoomInfor(name, roomNumber);

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				});
			}
		});
		// ���ַ���״̬
		btnAboutRoom.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame f = new JFrame();
				f.setSize(1500, 1500);
				f.setVisible(true);
				f.setLayout(new GridLayout(20, 13));// ���з����ð�ť����ʾ
				// ImageIcon icon = new ImageIcon("src/image/left_back.jpg");

				for (int i = 1; i <= 20; i++)
					for (int j = 1; j <= 13; j++) {
						if (i <= 10) {
							try {
								if (Operation
										.FindInforByRoomnumber((i * 100 + j)
												+ "")) {
									// ȥ��ѯÿ���������ס״̬������ס����ʾ������ɫ����
									JButton temp = new JButton();
									temp.setText("��" + (i * 100 + j));
									// temp.setIcon(icon);
									temp.setBackground(Color.BLUE);
									final int I = i;// �����ڰ�ť�����actionPerformed��0)�������Ҫʹ��i,j����������Ϊfinal
													// ������forѭ�����޷�����
									final int J = j;
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {
											String Master = null;
											try {
												// //��ȡ������������
												Master = Operation
														.getMasterofRoom(""
																+ (I * 100 + J));
											} catch (UnsupportedEncodingException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											} catch (SQLException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											} finally {
												JOptionPane
														.showMessageDialog(
																null,
																(I * 100 + J)
																		+ "�ŷ��� "
																		+ "\n"
																		+ "����Ϊ"
																		+ Master
																		+ "\n"
																		+ "�Ӵ�ߴ�ġ����пյ�"
																		+ "\n"
																		+ "����������ԡ�豸��25Ӣ�������ɫ���µ��ӡ� �绰�� �����ĳ����� "
																		+ "\n"
																		+ "��ɻ��� ��ʱ�ӵ��������Լ����ڵİ�ȫ�ͼ���װ��");

											}

										}
									});
									f.add(temp);
								} else {
									JButton temp = new JButton();
									temp.setText("��" + (i * 100 + j));
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {

											JOptionPane
													.showMessageDialog(
															null,
															"��ʱ���˾�ס "
																	+ "\n"
																	+ "�Ӵ�ߴ�ġ����пյ�"
																	+ "\n"
																	+ "����������ԡ�豸��25Ӣ�������ɫ���µ��ӡ� �绰�� �����ĳ����� "
																	+ "\n"
																	+ "��ɻ��� ��ʱ�ӵ��������Լ����ڵİ�ȫ�ͼ���װ��");
										}
									});
									f.add(temp);
								}
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						// ˫�˷�
						else {
							try {
								if (Operation
										.FindInforByRoomnumber((i * 100 + j)
												+ "")) {
									// ȥ��ѯÿ���������ס״̬������ס����ʾ������ɫ����
									JButton temp = new JButton();
									temp.setText("˫" + (i * 100 + j));
									// temp.setIcon(icon);
									temp.setBackground(Color.BLUE);
									final int I = i;// �����ڰ�ť�����actionPerformed��0)�������Ҫʹ��i,j����������Ϊfinal
													// ������forѭ�����޷�����
									final int J = j;
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {
											String Master = null;
											try {
												// //��ȡ������������
												Master = Operation
														.getMasterofRoom(""
																+ (I * 100 + J));
											} catch (UnsupportedEncodingException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											} catch (SQLException e) {
												// TODO Auto-generated catch
												// block
												e.printStackTrace();
											}
											JOptionPane.showMessageDialog(null,
													(I * 100 + J) + "�ŷ��� "
															+ "\n" + "��ס��Ϊ"
															+ Master);
										}
									});
									f.add(temp);
								} else {
									JButton temp = new JButton();

									temp.setText("˫" + (i * 100 + j));
									temp.addActionListener(new ActionListener() {

										public void actionPerformed(
												ActionEvent arg0) {

											JOptionPane
													.showMessageDialog(
															null,
															"��ʱ���˾�ס "
																	+ "\n"
																	+ "�Ӵ�ߴ�ġ����пյ�"
																	+ "\n"
																	+ "����������ԡ�豸��25Ӣ�������ɫ���µ��ӡ� �绰�� �����ĳ����� "
																	+ "\n"
																	+ "��ɻ��� ��ʱ�ӵ��������Լ����ڵİ�ȫ�ͼ���װ��");
										}
									});
									f.add(temp);
								}
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
			}
		});

		btnChangeRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				f.setLayout(new GridLayout(1, 2));
				final JTextField oldNumber = new JTextField("�ѵǼǷ���");
				final JTextField newNumber = new JTextField("���ķ���");
				JPanel p1 = new JPanel(new GridLayout(2, 1));
				p1.add(oldNumber);
				p1.add(newNumber);
				f.add(p1);
				JPanel p2 = new JPanel();
				JButton b = new JButton("ȷ�ϸ���");
				p2.add(b);
				f.add(p2);
				f.setVisible(true);
				f.setSize(200, 100);
				b.addActionListener(new ActionListener() { // ���ȷ�ϸ�����ť
					public void actionPerformed(ActionEvent e) {
						final String ID1 = oldNumber.getText().toString();
						final String ID2 = newNumber.getText().toString();
						System.out.println(ID1 + ID2);
						try {
							try {
								Operation.changeRoom(ID1, ID2);
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				});
			}
		});

		btnOtherService.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JFrame f = new JFrame();
				JPanel p1 = new JPanel();
				JPanel p2 = new JPanel();
				JPanel p3 = new JPanel();
				JPanel p4 = new JPanel();

				f.setLayout(new GridLayout(4, 1));

				f.add(p1);
				f.add(p2);
				f.add(p3);
				f.add(p4);

				f.setVisible(true);
				f.setSize(350, 200);
				p1.setLayout(new GridLayout(1, 2));
				p2.setLayout(new GridLayout(1, 2));
				final JCheckBox c1 = new JCheckBox("�ư�");
				final JCheckBox c2 = new JCheckBox("����");
				final JCheckBox c3 = new JCheckBox("�⳵");
				final JCheckBox c4 = new JCheckBox("������");
				p1.add(c1);
				p1.add(c2);
				p2.add(c3);
				p2.add(c4);
				final JTextField t = new JTextField("�����뷿��");
				JButton b = new JButton("ȷ��Ԥ��");
				p3.add(t);
				p4.add(b);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String roomNumber = t.getText();
						boolean a = c1.isSelected();
						boolean b = c2.isSelected();
						boolean c = c3.isSelected();
						boolean d = c4.isSelected();
						try {
							Operation.service(a, b, c, d, roomNumber);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

						JOptionPane.showMessageDialog(null, "Ԥ���ɹ�");
					}
				});
			}
		});
		btnCheckOut.addActionListener(new ActionListener() { // btnFInd�����ť�����˷�����
					public void actionPerformed(ActionEvent e) {
						JFrame f = new JFrame();
						f.setLayout(new GridLayout(1, 2));
						final JTextField txtName = new JTextField("����������");
						final JTextField txtID = new JTextField("�����뷿���");
						JPanel p1 = new JPanel(new GridLayout(2, 1));
						p1.add(txtName);
						p1.add(txtID);
						f.add(p1);
						JPanel p2 = new JPanel();
						JButton b = new JButton("ȷ���˷�����");
						p2.add(b);
						f.add(p2);
						f.setVisible(true);
						f.setSize(300, 100);
						b.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								final String roomNumber = txtID.getText();
								try {
									Operation.checkout(roomNumber);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						});
					}
				});

		btnShowConsumption.addActionListener(new ActionListener() { // btnFInd�����ť�����˷�����
					public void actionPerformed(ActionEvent e) {
						JFrame f = new JFrame();
						// f.setLayout(new FlowLayout(FlowLayout.CENTER));
						f.setLayout(new GridLayout(2, 1));

						f.setVisible(true);
						f.setSize(600, 200);
						// ���
						String[] columnNames = { "name","pub","bar","taxi","coffee" ,"fareOfHousing","sum"};
						Object[][] data = null;
						final DefaultTableModel tableModel = new DefaultTableModel(
								data, columnNames);

						JTable table = new JTable(tableModel);
						// ��ԭ����ֱ����add��table��������������ʾ����������������JScrollPane
						JScrollPane pane = new JScrollPane(table,
								ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
								ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

						JButton testAdd = new JButton("���һ��");// ���һ��
						// testAdd.setSize(100, 300);
						JPanel add = new JPanel(new GridLayout(1, 2));
						final JTextField textName = new JTextField("��������Ҫ��ѯ������");

						add.add(textName);
						add.add(testAdd);
						f.add(add);
						f.add(pane);
						testAdd.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent arg0) {

								String name = textName.getText().toString();
								Vector rowValues =null;
								try {
									rowValues=Operation.consumption(name);
								} catch (UnsupportedEncodingException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
//
//								String[] rowValues = { "Grapes", "String",
//										"2.00" };
								tableModel.addRow(rowValues); // ���һ��
							}
						});
					}
				});
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generat ed method stub

		management f = new management();
		f.setSize(400, 200);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Operation.Connect();// �������ݿ�
		// Operation.test();
	}

	/**
	 * �ڲ���ʱ��ѡ������Ϊ�˻�ȡʱ�䣬�����д���������������ⲻ�ô���
	 * ***************************************
	 * *****************************************************
	 * */
	public static class DateChooserJButton extends JButton {

		private DateChooser dateChooser = null;// �̳�����壬Ϊ�ڲ���
		private String preLabel = "";

		public DateChooserJButton() {
			this(getNowDate());// ���������Ĺ��췽��
		}

		public DateChooserJButton(SimpleDateFormat df, String dateString) {
			this();// ����ģ�
			setText(df, dateString);
		}

		public DateChooserJButton(Date date) {
			this("", date);
		}

		public DateChooserJButton(String preLabel, Date date) {
			if (preLabel != null)
				this.preLabel = preLabel;
			setDate(date);
			setBorder(null);
			setCursor(new Cursor(Cursor.HAND_CURSOR));

			// �����ť���ͻᵯ���Ǹ�����ѡ����
			super.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (dateChooser == null)
						dateChooser = new DateChooser();
					Point p = getLocationOnScreen();
					p.y = p.y + 30;
					dateChooser.showDateChooser(p);// ��ѡ�����ʾ����
				}
			});
		}

		private static Date getNowDate() {
			return Calendar.getInstance().getTime();
		}

		/**
		 * 2����Ҫ���÷� getDefaultDateFormat().format(date)���ڱ��ַ���
		 * getDefaultDateFormat().parse(s) �ַ���������
		 * */
		private static SimpleDateFormat getDefaultDateFormat() {
			// return new SimpleDateFormat("yyyy-MM-dd HH:MM:ss"); // ��ť��ʾ�����ڸ�ʽ
			return new SimpleDateFormat("yyyy-MM-dd"); // ��ť��ʾ�����ڸ�ʽ
		}

		/**
		 * ����Ĺ��췽������ʽ���ã����췽��һ�����ͻᵼ��public void setDate(Date
		 * date)�����ã���ť����ʾ����ǰ���ڣ�Ȼ�����ֹ���ȴ��û������ť ֱ����ť������ͻ���ʾ������ѡ����
		 * */
		// ���Ǹ���ķ���
		public void setText(String s) {

			Date date;
			try {
				date = getDefaultDateFormat().parse(s);
			} catch (ParseException e) {
				date = getNowDate();// �����ȡʧ�ܣ���Ĭ��Ϊ��ǰʱ��
			}
			// System.out.println("����"+s);
			setDate(date);
		}

		public void setText(SimpleDateFormat df, String s) {
			Date date;
			try {
				date = df.parse(s);
			} catch (ParseException e) {
				date = getNowDate(); // ����Ⱑ��������������������1
			}
			setDate(date);
			// System.out.println("����" + s);
		}

		public void setDate(Date date) {
			super.setText(preLabel + getDefaultDateFormat().format(date));// ʹ��ť��ʾʱ��
		}

		public Date getDate() {
			String dateString = getText();// ��������������������
			// String dateString =
			// getText().substring(preLabel.length());//getText()��ʾ��ťDateChooserJButton�ϵ��ı���
			// ���ַ�����ָ�����ַ�λ�ÿ�ʼ��һֱ�����ַ�����ĩβ����ʵ��preLabel.length()����0
			try {
				return getDefaultDateFormat().parse(dateString);
			} catch (ParseException e) {
				return getNowDate();
			}
		}

		// ���Ǹ���ķ���ʹ֮��Ч
		public void addActionListener(ActionListener listener) {

		}

		/**
		 * ����ѡ���ڲ���
		 * *******************************************************************************************/
		private class DateChooser extends JPanel implements ActionListener,
				ChangeListener {
			int startYear = 1980; // Ĭ�ϡ���С����ʾ���
			int lastYear = 2050; // Ĭ�ϡ������ʾ���
			int width = 200; // ������
			int height = 200; // ����߶�
			Color backGroundColor = Color.gray; // ��ɫ
			// ���������ɫ----------------//
			Color palletTableColor = Color.white; // �������ɫ
			Color todayBackColor = Color.orange; // ���챳��ɫ
			Color weekFontColor = Color.blue; // ��������ɫ
			Color dateFontColor = Color.black; // ��������ɫ
			// ��������ɫ------------------//
			Color controlLineColor = Color.pink; // ��������ɫ
			Color controlTextColor = Color.white; // ��������ǩ����ɫ
			JDialog dialog;
			JSpinner yearSpin;
			JSpinner monthSpin;
			// JSpinner hourSpin;
			JButton[][] daysButton = new JButton[6][7];// һ���µ�����

			DateChooser() {
				setLayout(new BorderLayout());
				setBorder(new LineBorder(backGroundColor, 2));// ����
				setBackground(backGroundColor);
				JPanel topYearAndMonth = createYearAndMonthPanal();
				add(topYearAndMonth, BorderLayout.NORTH);
				JPanel centerWeekAndDay = createWeekAndDayPanal();
				add(centerWeekAndDay, BorderLayout.CENTER);
			}

			private JPanel createYearAndMonthPanal() {
				// ��ȡ��������
				Calendar c = getCalendar();
				int currentYear = c.get(Calendar.YEAR);
				int currentMonth = c.get(Calendar.MONTH) + 1;// Ϊʲô +1
				// int currentHour = c.get(Calendar.HOUR_OF_DAY);
				JPanel result = new JPanel();
				result.setLayout(new FlowLayout());
				result.setBackground(controlLineColor);
				// ����һ������ָ�� value��minimum/maximum �߽�� stepSize ��
				// SpinnerNumberModel��
				yearSpin = new JSpinner(new SpinnerNumberModel(currentYear,
						startYear, lastYear, 1));
				yearSpin.setPreferredSize(new Dimension(48, 20));
				yearSpin.setName("Year");
				yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
				yearSpin.addChangeListener(this);

				result.add(yearSpin);
				JLabel yearLabel = new JLabel("��");
				yearLabel.setForeground(controlTextColor);
				result.add(yearLabel);
				monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth,
						1, 12, 1));
				monthSpin.setPreferredSize(new Dimension(35, 20));
				monthSpin.setName("Month");
				monthSpin.addChangeListener(this);
				result.add(monthSpin);
				JLabel monthLabel = new JLabel("��");
				monthLabel.setForeground(controlTextColor);
				result.add(monthLabel);
				// hourSpin = new JSpinner(new SpinnerNumberModel(currentHour,
				// 0, 23,
				// 1));
				// hourSpin.setPreferredSize(new Dimension(35, 20));
				// hourSpin.setName("Hour");
				// hourSpin.addChangeListener(this);
				// result.add(hourSpin);
				// //JLabel hourLabel = new JLabel("ʱ");
				// hourLabel.setForeground(controlTextColor);
				// result.add(hourLabel);
				return result;
			}

			private JPanel createWeekAndDayPanal() {
				String colname[] = { "��", "һ", "��", "��", "��", "��", "��" };
				JPanel result = new JPanel();
				// ���ù̶����壬������û����ı�Ӱ���������
				result.setFont(new Font("����", Font.PLAIN, 12));
				result.setLayout(new GridLayout(7, 7));
				result.setBackground(Color.white);
				JLabel cell;
				for (int i = 0; i < 7; i++) {
					cell = new JLabel(colname[i]);
					cell.setHorizontalAlignment(JLabel.RIGHT);
					cell.setForeground(weekFontColor);
					result.add(cell);
				}

				int actionCommandId = 0;
				for (int i = 0; i < 6; i++)
					for (int j = 0; j < 7; j++) {
						JButton numberButton = new JButton();
						numberButton.setBorder(null);
						numberButton
								.setHorizontalAlignment(SwingConstants.RIGHT);
						/**
						 * ���ô���������Ĳ����¼����������ơ� ��: JButton btnShow = new
						 * JButton(); btnShow.setActionCommand("show");
						 * �������ť�������ʱ��,��Ϳ����� ActionEvent ��
						 * getActionCommand().equals("show") ����ʶ�ǵ�����ĸ���ť
						 */
						numberButton.setActionCommand(String
								.valueOf(actionCommandId));// ��ȡ��Ӧ���ַ���
						numberButton.addActionListener(this);
						numberButton.setBackground(palletTableColor);
						numberButton.setForeground(dateFontColor);
						numberButton.setForeground(dateFontColor);
						daysButton[i][j] = numberButton;
						result.add(numberButton);
						actionCommandId++;// ����ʱ�Ϳ���ͨ��actionCommandId����ʶ�ǵ�����ĸ���ť��
					}
				return result;
			}

			private JDialog createDialog(Frame owner) {
				JDialog result = new JDialog(owner, "����ʱ��ѡ��", true);
				result.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
				result.getContentPane().add(this, BorderLayout.CENTER);// ���thisָ���Ǳ�������JPanel��ʵ���ϣ��������Ŀ��ǰ���JPanel��һ��JDialog��
				result.pack();// �����˴��ڵĴ�С�����ʺ������������ѡ��С�Ͳ���
				result.setSize(width, height);
				return result;
			}

			void showDateChooser(Point position) {
				Frame owner = (Frame) SwingUtilities
						.getWindowAncestor(DateChooserJButton.this);// ����
																	// Component
																	// �ĵ�һ��
																	// Window ����
				if (dialog == null || dialog.getOwner() != owner)
					dialog = createDialog(owner);// ��ȻҪ��һ��Dialog???
				dialog.setLocation(getAppropriateLocation(owner, position));
				flushWeekAndDay();
				dialog.show();
			}

			Point getAppropriateLocation(Frame owner, Point position) {
				Point result = new Point(position);
				Point p = owner.getLocation();
				int offsetX = (position.x + width) - (p.x + owner.getWidth());
				int offsetY = (position.y + height) - (p.y + owner.getHeight());
				if (offsetX > 0) {
					result.x -= offsetX;
				}
				if (offsetY > 0) {
					result.y -= offsetY;
				}
				return result;
			}

			private Calendar getCalendar() {
				Calendar result = Calendar.getInstance();
				result.setTime(getDate());
				return result;
			}

			private int getSelectedYear() {
				return ((Integer) yearSpin.getValue()).intValue();
			}

			private int getSelectedMonth() {
				return ((Integer) monthSpin.getValue()).intValue();
			}

			// private int getSelectedHour() {
			// return ((Integer) hourSpin.getValue()).intValue();
			// } 
  
			private void dayColorUpdate(boolean isOldDay) {
				Calendar c = getCalendar();
				int day = c.get(Calendar.DAY_OF_MONTH);
				c.set(Calendar.DAY_OF_MONTH, 1);
				int actionCommandId = day - 2 + c.get(Calendar.DAY_OF_WEEK);
				int i = actionCommandId / 7;
				int j = actionCommandId % 7;
				if (isOldDay)
					daysButton[i][j].setForeground(dateFontColor);
				else
					daysButton[i][j].setForeground(todayBackColor);
			}

			// ���������������µ����ڣ���δ������Ҫ�������˰�
			private void flushWeekAndDay() {
				Calendar c = getCalendar();
				c.set(Calendar.DAY_OF_MONTH, 1);// ʱ������Ϊ���µ�1��
				int maxDayNo = c.getActualMaximum(Calendar.DAY_OF_MONTH);// ��������
				int dayNo = 2 - c.get(Calendar.DAY_OF_WEEK);// c.get(Calendar.DAY_OF_WEEK)��ʾ����һ�������ڼ������������һ�򷵻�2���Դ����ƣ�������forѭ������Ϳ�����ȷ�����·�ͼ
				// System.out.println("���� "+c.get(Calendar.DAY_OF_WEEK));
				// System.out.println(""+dayNo);
				for (int i = 0; i < 6; i++) {
					for (int j = 0; j < 7; j++) {
						String s = "";
						if (dayNo >= 1 && dayNo <= maxDayNo)// �������Ҫ
							s = String.valueOf(dayNo);
						daysButton[i][j].setText(s);
						dayNo++;
					}
				}
				dayColorUpdate(false);
			}

			// �����Ǹ�JSpinner�����¼�����
			public void stateChanged(ChangeEvent e) {
				JSpinner source = (JSpinner) e.getSource();
				Calendar c = getCalendar();
				// if (source.getName().equals("Hour")) {
				// c.set(Calendar.HOUR_OF_DAY, getSelectedHour());
				// setDate(c.getTime());
				// return;
				// }
				dayColorUpdate(true);
				if (source.getName().equals("Year"))
					c.set(Calendar.YEAR, getSelectedYear());
				else
					// (source.getName().equals("Month"))
					c.set(Calendar.MONTH, getSelectedMonth() - 1);
				setDate(c.getTime());// �ҵ����������ʱ����2��textvIew��ʾ������Ȼ��������ݿ�
				/** 
				 * ע�⣺ ֻ�е���setDate��ʱ��Ż��ʱ���������Ǹ���ťDateChooserJButton����
				 * ����ļ���ֻ��2��setDate���������ã�
				 * ������stateChanged����ѡ���꣬�£�������actionPerformed����ѡ���յ�ʱ��
				 **/
				dTempDate = c.getTime();// ��¼Date������
				sTempDate = "" + getDefaultDateFormat().format(c.getTime());// ��¼�ַ���������
				flushWeekAndDay();
			}

			// ���ڰ�ť����
			public void actionPerformed(ActionEvent e) {
				JButton source = (JButton) e.getSource();// ��ȡ���Ǹ�button
				if (source.getText().length() == 0)
					return;
				dayColorUpdate(true);
				source.setForeground(todayBackColor);
				int newDay = Integer.parseInt(source.getText());// ��ȡ�ա�
				Calendar c = getCalendar();// ��ȡ����Calendar ������ѡ������º���
				c.set(Calendar.DAY_OF_MONTH, newDay);
				setDate(c.getTime());

				System.out.println(c.getTime());
				dTempDate = c.getTime();// ��¼Date������
				// ���Wed Feb 18 22:00:31 CST 2015
				System.out.println(""
						+ getDefaultDateFormat().format(c.getTime()));
				// ���2015-02-18 22:02:31
				sTempDate = "" + getDefaultDateFormat().format(c.getTime());// ��¼�ַ���������
			}
		}// end class DateChooser
	}
}
