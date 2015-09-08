package calculator;

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

public class CirclePanel extends AbstractPanel implements ActionListener, FocusListener {
    JButton resultButton, clearButton; // 计算和清除
    JPanel leftPanel, rightPanel, buttonPanel;
    JTextField radiusTextField;
    JTextField lengthTextField, areaTextField, inputTextField;
    BoxPanel bpRadius, bpLength, bpArea;

    // 构造方法，完成对CirclePanel对象的初始化
    public CirclePanel() {
	setLayout(new GridLayout(1, 2));
	rightPanel = new KeyJPanel(this); // 设置右侧的软键盘的面板
	leftPanel = new JPanel(); // 设置左侧的面板

	// 创建一个垂直组件的Box容器box，并创建容器内要添加的组件
	Box box = Box.createVerticalBox();
	bpRadius = new BoxPanel("请输入圆的半径", 10);
	radiusTextField = bpRadius.getJTextField(); // 获取输入的圆的半径
	// radiusTextField文本框注册FocusEvent事件监听器
	radiusTextField.addFocusListener(this);
	buttonPanel = new JPanel();
	resultButton = new JButton("计算结果");
	// resultButton按钮注册ActionEvent事件监听器
	resultButton.addActionListener(this);
	clearButton = new JButton("清空");
	clearButton.addActionListener(this);
	buttonPanel.add(resultButton);
	buttonPanel.add(clearButton);
	bpLength = new BoxPanel("圆的周长：", 20);
	lengthTextField = bpLength.getJTextField();
	bpArea = new BoxPanel("圆的面积：", 20);
	areaTextField = bpArea.getJTextField();
	// box容器依次添加4个组件
	box.add(bpRadius);
	box.add(buttonPanel);
	box.add(bpLength);
	box.add(bpArea);
	leftPanel.add(box);

	// CirclePanel对象依次添加组件
	add(leftPanel);
	add(rightPanel);

    }

    // 事件源获得焦点时执行该方法
    @Override
    public void focusGained(FocusEvent e) {
	// TODO Auto-generated method stub
	inputTextField = (JTextField) e.getSource();

    }
    //当失去焦点时不执行此方法
    @Override
    public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
    }

    @Override
    public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	// 如果单击了计算结果按钮，计算并显示圆的周长和面积
	if (e.getSource() == resultButton) {
	    try {
		double radius = Double.parseDouble(radiusTextField.getText());
		lengthTextField.setText("" + 2 * Math.PI * radius);
		areaTextField.setText("" + Math.PI * radius * radius);
	    } catch (Exception e1) {
		JOptionPane.showMessageDialog(this, "请输入数字：", "警告对话框", JOptionPane.WARNING_MESSAGE);

	    }

	} else if (e.getSource() == clearButton) {
	    radiusTextField.setText(" ");

	}

    }
    //获取当前获得焦点的文本框的对象
    @Override
    public JTextField getInputTextField() {
	// TODO Auto-generated method stub
	return inputTextField;
	
    }

}
