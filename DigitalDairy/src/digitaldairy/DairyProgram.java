package digitaldairy;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class DairyProgram extends JFrame implements ActionListener
{

	private final static JPanel mainPanel = new JPanel();
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextPane txtMemo;
	
	private JPanel contactPanel;
	private JPanel contactFront;
	private JTextField txtTitle;

	private String[] months = {"January", "Feburary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};;
	private int i = 10;
	
	private JLabel monthLabel;
	private JLabel yearLabel;

	private JList contacts, calendar;
	
	String y;
	
	private LinkedList<Contact> contactList = new LinkedList<Contact>();
	private static LinkedList<Event> eventList = new LinkedList<Event>();
	private JComboBox paCB;
	private JComboBox minuteCB;
	private JComboBox hourCB;
	private JComboBox yearCB;
	private JComboBox dayCB;
	private JComboBox monthCB;
	private JTextPane txtMemo1;
	
	private static DateFormat z = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

	/**
	 * Launch the application.
	 * @throws IOException 
	 * @throws UnsupportedAudioFileException 
	 * @throws LineUnavailableException 
	 */
	public static void main(String[] args) {
		try {
			DairyProgram dialog = new DairyProgram();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer(30000, new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				Date x = new Date();
				String curr = z.format(x);
				String m = curr.substring(0, 2);
				String d = curr.substring(3, 5);
				String y = curr.substring(6, 10);
				String h = curr.substring(11, 13);
				String mm = curr.substring(14, 16);
				
				for(Event a : eventList)
				{
					if(a.getYear().equals(Integer.parseInt(y)) && a.getMonth().equals(Integer.parseInt(m)) && a.getDay().equals(Integer.parseInt(d))
							&& a.getHour().equals(Integer.parseInt(h)) && a.getMin().equals(Integer.parseInt(mm)))
					{
						JOptionPane.showMessageDialog(mainPanel, "REMINDER: " + a.getTitle());
					}
				}
			}    
		});
		Date x = new Date();
		while(Integer.parseInt(z.format(x).substring(17)) == 0)
		{
			x = new Date();
		}
		timer.start();

	}

	/** 
	 * Create the dialog.
	 */ 
	public DairyProgram() 
	{
			
		setTitle("Contact List");
		setBounds(100, 100, 664, 682);
		getContentPane().setLayout(null);
		mainPanel.setBounds(0, 0, 699, 700);
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		mainPanel.setLayout(null);
		setContentPane(mainPanel);
		
		
		
		
		JTabbedPane pane = new JTabbedPane(JTabbedPane.TOP);
		pane.setBounds(0, 0, 648, 644);
		mainPanel.add(pane);
		
		
		
		
		contactPanel = new JPanel();
		pane.addTab("Contacts",null, contactPanel, null);
		contactPanel.setLayout(null);
		
		contactFront = new JPanel();
		contactPanel.add(contactFront);
		contactFront.setBounds(0, 0, 643, 616);
		contactFront.setLayout(null);
		
		
		contacts = new JList(contactList.toArray());

		contacts.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				Contact a = contactList.get(contacts.getSelectedIndex());
				txtFirstName.setText(a.getFirst());
				txtLastName.setText(a.getLast());
				txtPhone.setText(a.getPhone());
				txtEmail.setText(a.getEmail());
				txtMemo.setText(a.getMemo());
			}
		});
		
		JScrollPane DairyProgramPane = new JScrollPane(contacts, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		DairyProgramPane.setBounds(new Rectangle(27, 64, 208, 467));
		contactFront.add(DairyProgramPane);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(250, 16, 12, 597);
		contactFront.add(separator);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(277, 34, 69, 20);
		contactFront.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(277, 66, 69, 20);
		contactFront.add(lblLastName);
		
		txtFirstName = new JTextField();
		txtFirstName.setEditable(false);
		txtFirstName.setBounds(388, 31, 231, 26);
		contactFront.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.setEditable(false);
		txtLastName.setBounds(388, 63, 231, 26);
		contactFront.add(txtLastName);
		txtLastName.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone #");
		lblPhone.setBounds(277, 133, 69, 20);
		contactFront.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setBounds(388, 130, 231, 26);
		contactFront.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(277, 200, 69, 20);
		contactFront.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(388, 197, 231, 26);
		contactFront.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblMemo = new JLabel("Memo");
		lblMemo.setBounds(277, 274, 69, 20);
		contactFront.add(lblMemo);
		
		JScrollPane memoPane = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		memoPane.setBounds(388, 276, 231, 242);
		contactFront.add(memoPane);
		
		
		txtMemo = new JTextPane();
		memoPane.setViewportView(txtMemo);
		txtMemo.setEditable(false);
		
		JButton btnAddNewContact = new JButton("Add New Contact");
		btnAddNewContact.setBounds(27, 16, 208, 29);
		contactFront.add(btnAddNewContact);
		btnAddNewContact.setActionCommand("New Contact");
		btnAddNewContact.addActionListener(this);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(27, 547, 96, 29);
		contactFront.add(btnEdit);
		btnEdit.setActionCommand("Contact Edit");
		btnEdit.addActionListener(this);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(138, 547, 97, 29);
		contactFront.add(btnDelete);
		btnDelete.setActionCommand("Delete");
		btnDelete.addActionListener(this);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(504, 547, 115, 29);
		contactFront.add(btnCancel);
		btnCancel.setActionCommand("Cancel");
		btnCancel.addActionListener(this);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(368, 547, 115, 29);
		contactFront.add(btnSave);
		btnSave.setActionCommand("Contact Save");
		btnSave.addActionListener(this);

		
		//Calendar Tab
		
		Integer[] monthsCB = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		Integer[] daysCB = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31};
		Integer[] yearsCB = {2015, 2016, 2017, 2018, 2019, 2020};
		Integer[] minutesCB = {0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
		String[] ampm = {"AM", "PM"};
		
		JPanel panel = new JPanel(null);
		pane.addTab("To-Do", null, panel, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 643, 616);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		calendar = new JList();

		calendar.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e)
			{
				Event a = (Event) calendar.getSelectedValue();
				monthCB.setSelectedItem(a.getMonth());
				dayCB.setSelectedItem(a.getDay());
				yearCB.setSelectedItem(a.getYear());
				hourCB.setSelectedItem(a.getHour());
				minuteCB.setSelectedItem(a.getMin());
				paCB.setSelectedItem(a.getPmam());
				txtTitle.setText(a.getTitle());
				txtMemo1.setText(a.getInfo());
			}
		});
		
		JScrollPane calendarScroll = new JScrollPane(calendar, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		calendarScroll.setBounds(new Rectangle(24, 64, 208, 467));
		panel_1.add(calendarScroll);
		
		JSeparator separator2 = new JSeparator();
		separator2.setOrientation(SwingConstants.VERTICAL);
		separator2.setBounds(258, 11, 12, 597);
		panel_1.add(separator2);
		
		monthLabel = new JLabel(months[i]);
		monthLabel.setBounds(65, 32, 72, 14);
		panel_1.add(monthLabel);
		
		JButton btnNewButton = new JButton("<");
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				leftArrowButtonPushed();
			}
		});
		
		btnNewButton.setBounds(12, 28, 43, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton(">");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rightArrowButtonPushed();
			}
		});
		btnNewButton_1.setBounds(203, 28, 43, 23);
		panel_1.add(btnNewButton_1);
		
		JLabel timeLabelR = new JLabel("Time");
		timeLabelR.setBounds(277, 119, 69, 20);
		panel_1.add(timeLabelR);
		
		JLabel messageLabelR = new JLabel("Info");
		messageLabelR.setBounds(277, 274, 69, 20);
		panel_1.add(messageLabelR);
		
		JScrollPane memoPane1 = new JScrollPane((Component) null, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		memoPane1.setBounds(388, 276, 231, 242);
		panel_1.add(memoPane1);
		
		txtMemo1 = new JTextPane();
		memoPane1.setViewportView(txtMemo1);
		
		
		JButton btnEdit1 = new JButton("Edit");
		btnEdit1.setBounds(27, 547, 96, 29);
		panel_1.add(btnEdit1);
		btnEdit1.setActionCommand("Calendar Edit");
		btnEdit1.addActionListener(this);
		
		JButton btnDelete1 = new JButton("Delete");
		btnDelete1.setBounds(138, 547, 97, 29);
		panel_1.add(btnDelete1);
		btnDelete1.setActionCommand("Calendar Delete");
		btnDelete1.addActionListener(this);
		
		JButton btnCancel1 = new JButton("Cancel");
		btnCancel1.setBounds(504, 547, 115, 29);
		panel_1.add(btnCancel1);
		btnCancel1.setActionCommand("Calendar Cancel");
		btnCancel1.addActionListener(this);
		
		JButton btnSave1 = new JButton("Save");
		btnSave1.setBounds(368, 547, 115, 29);
		panel_1.add(btnSave1);
		btnSave1.setActionCommand("Calendar Save");
		btnSave1.addActionListener(this);
		
		yearLabel = new JLabel("2015");
		yearLabel.setBounds(147, 32, 46, 14);
		panel_1.add(yearLabel);
		
		monthCB = new JComboBox(monthsCB);
		monthCB.setBounds(388, 63, 43, 20);
		panel_1.add(monthCB);
		
		dayCB = new JComboBox(daysCB);
		dayCB.setBounds(484, 63, 46, 20);
		panel_1.add(dayCB);
		
		yearCB = new JComboBox(yearsCB);
		yearCB.setBounds(564, 63, 69, 20);
		panel_1.add(yearCB);
		
		hourCB = new JComboBox(monthsCB);
		hourCB.setBounds(388, 119, 43, 20);
		panel_1.add(hourCB);
		
		minuteCB = new JComboBox(minutesCB);
		minuteCB.setBounds(484, 119, 46, 20);
		panel_1.add(minuteCB);
		
		paCB = new JComboBox(ampm);
		paCB.setBounds(564, 119, 69, 20);
		panel_1.add(paCB);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 182, 231, 50);
		panel_1.add(scrollPane);
		
		txtTitle = new JTextField();
		scrollPane.setViewportView(txtTitle);
		txtTitle.setColumns(10);
		
		JLabel titleLabel = new JLabel("Title");
		titleLabel.setBounds(280, 184, 143, 48);
		panel_1.add(titleLabel);
		
		JLabel lblMmddyyyy = new JLabel("Mm/Dd/Yyyy");
		lblMmddyyyy.setBounds(280, 66, 66, 14);
		panel_1.add(lblMmddyyyy);
		
		JButton btnNewEvent = new JButton("New Event");
		btnNewEvent.setBounds(65, 587, 128, 23);
		panel_1.add(btnNewEvent);
		btnNewEvent.setActionCommand("New Event");
		btnNewEvent.addActionListener(this);
		
		contactEdit(false);
		calendarEdit(false);
		
	}

	private void leftArrowButtonPushed() {
		i--;
		if(i == -1)
		{
			i = 11;
			yearLabel.setText(String.valueOf(Integer.parseInt(yearLabel.getText()) - 1));
		}
		monthLabel.setText(months[i]);
		
		updateCalendar();
	}

	private void rightArrowButtonPushed()
	{
		i++;
		if(i == 12)
		{
			i = 0;
			yearLabel.setText(String.valueOf(Integer.parseInt(yearLabel.getText()) + 1));
		}
		monthLabel.setText(months[i]);
		
		updateCalendar();
	}
	
	private void updateCalendar()
	{
		Event[] x = new Event[eventList.size()];
		for(int i = 0; i < eventList.size(); i++)
		{
			if(yearLabel.getText().equals(eventList.get(i).getYear().toString()) && monthLabel.getText().equals(eventList.get(i).getMonthS()))
			{
				x[i] = eventList.get(i);
			}
		}
		
		calendar.setListData(x);
	}
	
	private void clearCalendar()
	{
		txtMemo1.setText("");
		txtTitle.setText("");
	}
	
	private int searchCalendar(Event e)
	{
		for(int i = 0; i < eventList.size(); i++)
		{
			if(eventList.get(i).getTitle().equals(e.getTitle()))
				return i;
		}
		return -1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		String x = e.getActionCommand();
		
		
		if(x.equals("New Event"))
		{
			y = "New Event";
			calendarEdit(true);
		}
		if(x.equals("Calendar Save"))
		{
			if(y.equals("New Event"))
			{
				eventList.add(new Event((Integer)monthCB.getSelectedItem(), (Integer)dayCB.getSelectedItem(), (Integer)yearCB.getSelectedItem(), 
						(Integer)hourCB.getSelectedItem(), (Integer)minuteCB.getSelectedItem(), (String)paCB.getSelectedItem(), 
						txtTitle.getText(), txtMemo1.getText()));
				y = "";
			}
			else
			{
				Event a = eventList.get(calendar.getSelectedIndex());
				a.setMonth((Integer)monthCB.getSelectedItem());
				a.setDay((Integer)dayCB.getSelectedItem());
				a.setYear((Integer)yearCB.getSelectedItem());
				a.setHour((Integer)hourCB.getSelectedItem());
				a.setMin((Integer)minuteCB.getSelectedItem());
				a.setPmam((String)paCB.getSelectedItem());
				a.setTitle(txtTitle.getText());
				a.setInfo(txtMemo1.getText());

			}
			
			Collections.sort(eventList, null);
			updateCalendar();
			clearCalendar();
			calendarEdit(false);
		}
		if(x.equals("Calendar Edit"))
		{
			Event a = (Event) calendar.getSelectedValue();
			monthCB.setSelectedItem(a.getMonth());
			dayCB.setSelectedItem(a.getDay());
			yearCB.setSelectedItem(a.getYear());
			hourCB.setSelectedItem(a.getHour());
			minuteCB.setSelectedItem(a.getMin());
			paCB.setSelectedItem(a.getPmam());
			txtTitle.setText(a.getTitle());
			txtMemo1.setText(a.getInfo());
			calendarEdit(true);
		}
		if(x.equals("Calendar Cancel"))
		{
			clearCalendar();
			calendarEdit(false);
		}
		if(x.equals("Calendar Delete"))
		{
			clearCalendar();
			eventList.remove(searchCalendar((Event)calendar.getSelectedValue()));
			updateCalendar();
		}
		
		//Contact DONT MESS WITH THIS
		
		if(x.equals("New Contact"))
		{
			y = "New Contact";
			contactEdit(true);
		}
		
		if(x.equals("Contact Save"))
		{
			if(y.equals("New Contact"))
			{
				contactList.add(new Contact(txtFirstName.getText(), txtLastName.getText(), txtPhone.getText(),
						txtEmail.getText(), txtMemo.getText()));
				y = "";
			}
			else
			{
				Contact a = contactList.get(contacts.getSelectedIndex());
				a.setFirst(txtFirstName.getText());
				a.setLast(txtLastName.getText());
				a.setEmail(txtEmail.getText());
				a.setPhone(txtPhone.getText());
				a.setMemo(txtMemo.getText());
			}
			
			Collections.sort(contactList, null);
				
			contacts.setListData(contactList.toArray());
		
			contactClear();
			contactEdit(false);
		}
		if(x.equals("Contact Edit"))
		{
			Contact a = contactList.get(contacts.getSelectedIndex());
			txtFirstName.setText(a.getFirst());
			txtLastName.setText(a.getLast());
			txtPhone.setText(a.getPhone());
			txtEmail.setText(a.getEmail());
			txtMemo.setText(a.getMemo());
			
			contactEdit(true);
		}	
		if(x.equals("Cancel"))
		{
			contactClear();
			contactEdit(false);
		}
		if(x.equals("Delete"))
		{
			contactClear();
			contactList.remove(contacts.getSelectedIndex());
			
			contacts.setListData(contactList.toArray());
		}
	}
	
	private void contactEdit(boolean which)
	{
		txtFirstName.setEditable(which);
		txtLastName.setEditable(which);
		txtPhone.setEditable(which);
		txtEmail.setEditable(which);
		txtMemo.setEditable(which);
	}
	
	private void contactClear()
	{
		txtFirstName.setText("");
		txtLastName.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtMemo.setText("");
	}
	
	private void calendarEdit(boolean which)
	{
		txtMemo1.setEditable(which);
		txtTitle.setEditable(which);
		monthCB.setEnabled(which);
		dayCB.setEnabled(which);
		hourCB.setEnabled(which);
		yearCB.setEnabled(which);
		minuteCB.setEnabled(which);
		paCB.setEnabled(which);
	}
}