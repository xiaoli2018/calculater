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

public class TrianglePanel extends AbstractPanel implements ActionListener, FocusListener {
	JButton resultButton, clearButton;
	JPanel leftPanel, rightPanel, buttonPanel;
	JTextField sideATextField, sideBTextField, sideCTextField;
	JTextField lengthTextField, areaTextField, inputTextField;
	BoxPanel bpSideA, bpSideB, bpSideC, bpLength, bpArea;

	// 对三角形面板的初始化
	public TrianglePanel() {
		// TODO Auto-generated constructor stub
		setLayout(new GridLayout(1, 2));
		rightPanel = new KeyJPanel(this);
		leftPanel = new JPanel();

		// 创建一个垂直排列的组件的Box容器box，并创建要添加的组件
		Box box = Box.createVerticalBox();
		bpSideA = new BoxPanel("请输入三角形的边 A:", 10);
		sideATextField = bpSideA.getJTextField();
		// sideATextField 文本框注册FcousEvent事件监听器
		sideATextField.addFocusListener(this);
		bpSideB = new BoxPanel("请输入三角形的边 B ： ", 10);
		sideBTextField = bpSideB.getJTextField();
		sideBTextField.addFocusListener(this);
		bpSideC = new BoxPanel("请输入三角形的边C", 10);
		sideCTextField = bpSideC.getJTextField();
		sideCTextField.addFocusListener(this);
		buttonPanel = new JPanel();
		resultButton = new JButton("计算结果：");
		// resultButton 按钮注册ActionEvent事件监听器
		resultButton.addActionListener(this);
		clearButton = new JButton("清空");
		clearButton.addActionListener(this);
		buttonPanel.add(resultButton);
		buttonPanel.add(clearButton);
		bpLength = new BoxPanel("三角形的周长：", 20);
		lengthTextField = bpLength.getJTextField();
		bpArea = new BoxPanel("三角形的面积：", 20);
		areaTextField = bpArea.getJTextField();

		// box容器中依次添加以下的6个面板
		box.add(bpSideA);
		box.add(bpSideB);
		box.add(bpSideC);
		box.add(buttonPanel);
		box.add(bpLength);
		box.add(bpArea);
		leftPanel.add(box);
		// TrianglePanel对象添加两个面板
		add(leftPanel);
		add(rightPanel);

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		inputTextField = (JTextField) e.getSource();

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == resultButton) {
			try {
				double sideA = Double.parseDouble(sideATextField.getText());
				double sideB = Double.parseDouble(sideATextField.getText());
				double sideC = Double.parseDouble(sideATextField.getText());
				// 若输入的三边满足构成三角形的条件，则计算并显示周长和面积
				if ((sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA)) {
					double p = (sideA + sideB + sideC) / 2.0;
					lengthTextField.setText("" + 2 * p);
					double area = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
					areaTextField.setText("" + area);

				} else {
					JOptionPane.showMessageDialog(this, "这不可以构成一个三角形，请重新输入三条边", "警告对话框", JOptionPane.WARNING_MESSAGE);
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(this, "请输入数字：", "警告对话框", JOptionPane.WARNING_MESSAGE);

			}
		} else if (e.getSource() == clearButton) {
			sideATextField.setText("");
			sideBTextField.setText("");
			sideCTextField.setText("");
		}

	}

	@Override
	public JTextField getInputTextField() {
		// TODO Auto-generated method stub
		return inputTextField;
	}

}
