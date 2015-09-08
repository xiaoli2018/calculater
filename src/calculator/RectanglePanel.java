package calculator;
//矩形计算器的实现

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public  class RectanglePanel extends AbstractPanel implements ActionListener, FocusListener {
    JButton resultButton, clearButton;
    JPanel leftPanel, rightPanel, buttonPanel;
    JTextField widthTextField, heightTextField;
    JTextField lengthTextField, areaTextField, inputTextField;
    BoxPanel bpWidth, bpHeight, bpLength, bpArea;

    // 构造方法，初始化矩阵计算器的界面
    public RectanglePanel() {
	setLayout(new GridLayout(1, 2));
	rightPanel = new KeyJPanel(this); // 右边是数字软键盘
	leftPanel = new JPanel(); // 左边创建一个输入区域

	// 创建一个垂直排列组件的Box容器box，并创建box容器内的各个组件
	Box box = Box.createVerticalBox();
	bpWidth = new BoxPanel("请输入矩形的宽:", 10);
	widthTextField = bpWidth.getJTextField();

	// 文本框widthTextField注册FocusEvent事件监听器
	widthTextField.addFocusListener(this);
	bpHeight = new BoxPanel("请输入矩阵的高", 10);
	heightTextField = bpHeight.getJTextField();
	heightTextField.addFocusListener(this);
	buttonPanel = new JPanel();
	resultButton = new JButton("计算结果");
	// 按钮注册ActionEvent事件监听器
	resultButton.addActionListener(this);
	clearButton = new JButton("清空");
	clearButton.addActionListener(this);
	buttonPanel.add(resultButton);
	buttonPanel.add(clearButton);
	bpLength = new BoxPanel("矩形的周长:", 20);
	lengthTextField = bpLength.getJTextField();
	bpArea = new BoxPanel("矩阵的面积", 20);
	this.areaTextField = this.bpArea.getJTextField();
	// box容器中依次添加5个面板
	box.add(bpWidth);
	box.add(bpHeight);
	box.add(buttonPanel);
	box.add(bpLength);
	box.add(bpArea);
	leftPanel.add(box);

	// RectanglePanel 面板添加组件
	add(leftPanel);
	add(rightPanel);
    }

    // 用户单击按钮时，触发ActionEvent事件，自动执行该方法的代码
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == resultButton) {
	    try {
		double width = Double.parseDouble(widthTextField.getText());
		double height = Double.parseDouble(heightTextField.getText());
		lengthTextField.setText("" + 2 * (width + height));
		areaTextField.setText("" + width * height);

	    } catch (NumberFormatException e1) {
		// 若参数录入的是非数字字符，弹出消息对话警告
		JOptionPane.showMessageDialog(this, "请输入数字：", "警告对话框", JOptionPane.WARNING_MESSAGE);

	    }
	} else if (e.getSource() == clearButton) {
	    widthTextField.setText(" ");
	    heightTextField.setText(" ");

	}
    }

    // FocusListener接口中的方法，当获得焦点时调用该方法
    public void focusGained(FocusEvent e) {

	inputTextField = (JTextField) e.getSource();

    }

    // FocusListener 接口中的方法，当失去焦点时调用该方法
    public void focusLost(FocusEvent e) {
    }

    // 得到当前获得的焦点的文本框对象
    public JTextField getInputTextField() {
	return inputTextField;

    }

   
}
