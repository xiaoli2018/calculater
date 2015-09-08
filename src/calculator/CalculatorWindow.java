package calculator;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.sound.midi.VoiceStatus;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CalculatorWindow extends JFrame implements ActionListener, ItemListener {
    CardLayout mycard;    //CardLayout的布局管理器
    JPanel controlPanel, pCenter; //controlPanel负责选择要进行计算的图形， Pcenter是放置controlPanel和其他的4类图形的容器
    JComboBox chooseList;  //组合框，提供用户进行选择的列表
    JMenuBar menuBar;  //JMenuBar创建的菜单条，向menuBar中添加菜单
    JMenu menu;  //JMenu类创建的菜单，用来切换至控制面板和退出程序
    JMenuItem mainWindow, exit; //由JMenuItem创建的两个菜单项，主界面和退出

    public CalculatorWindow() {
	setTitle("常见几何图形的计算器");
	// 设置窗口的菜单条，菜单，菜单项，给菜单项注册ActionEvent事件的监听器
	menuBar = new JMenuBar();
	menu = new JMenu("操作");
	mainWindow = new JMenuItem("主界面");
	mainWindow.addActionListener(this);  //添加了监听器之后，如果触发这个按键就执行下面重写的actionListener函数
	exit = new JMenuItem("退出");
	exit.addActionListener(this);  //添加了监听器之后，如果触发这个按键就执行下面重写的actionListener函数
	menu.add(mainWindow);
	menu.add(exit);
	menuBar.add(menu);
	setJMenuBar(menuBar);

	// 在主窗口的中部添加一个面板pCenter，其布局是CardLayout型
	mycard = new CardLayout();
	pCenter = new JPanel();
	pCenter.setLayout(mycard);
	add(pCenter, "Center");

	// 设计一个控制面板contorlPanel,可供选择图形进行计算

	controlPanel = new JPanel();
	controlPanel.setLayout(new BorderLayout());

	// 创建下拉列表chooseList,并添加选项，注册ItemEevent事件监听器

	chooseList = new JComboBox();
	chooseList.addItem("请单击下拉列表选择");
	chooseList.addItem("矩阵的基本运算");
	chooseList.addItem("圆的基本运算");
	chooseList.addItem("三角形的基本计算");
	chooseList.addItem("圆柱的基本运算");
	chooseList.addItemListener(this);
	// 创建带图标的按钮
	ImageIcon icon = new ImageIcon("image/01.jpg");
	JButton imageButton = new JButton(icon);

	// 在控制面板controlPanel 容器内添加下拉菜单和按钮

	controlPanel.add(imageButton, "Center");
	controlPanel.add(chooseList, "North");

	// 在具有CardLayout布局的面板pCenter中添加组件

	pCenter.add("0", controlPanel);
	pCenter.add("1", new RectanglePanel());
	pCenter.add("2", new CirclePanel());
//	pCenter.add("3", new TrianglePanel());
//	pCenter.add("4", new CylinderPanel());

	setBounds(100, 100, 700, 300);
	setResizable(false);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);

    }
    
    // 当用户选择下拉列表的选项时，触发ItemEvent事件，自动执行该方法内的代码，实现的是IterListener中的方法

    public void itemStateChanged(ItemEvent e) {
	int index = chooseList.getSelectedIndex();
	String choice = String.valueOf(index);
	mycard.show(pCenter, choice);
    }

    // 当用户单击菜单项时，触发ActionEvent事件，自动执行该方法内的代码块,实现的是ActionListener中的方法
    public void actionPerformed(ActionEvent e) {
	// 选择主界面的命令，界面切换到控制面板controlPanel状态
	if (e.getSource() == mainWindow) {
	    mycard.first(pCenter);
	    chooseList.setSelectedIndex(0);

	}
	// 选择“退出”命令，退出程序
	else if (e.getSource() == exit) {
	    System.exit(0);

	}

    }

    public static void main(String[] args) {
	new CalculatorWindow();
    }

}
