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

//圆柱计算器 的实现
public class CylinderPanel extends AbstractPanel implements ActionListener, FocusListener {
	JButton resultButton, clearButton;
	JPanel leftPanel, rightPanel, buttonPanel;
	JTextField radiusTextField, heightTextField;
	JTextField surfaceAreaTextField, volumeTextField, inputTextField;
	BoxPanel bpRadius, bpHeight, bpSurfaceArea, bpVolume;

	// 构造方法，负责CylinderPanel对象的初始化
	public CylinderPanel() {
		setLayout(new GridLayout(1, 2));
		rightPanel = new KeyJPanel(this);
		leftPanel = new JPanel();

		Box box = Box.createVerticalBox();
		bpRadius = new BoxPanel("请输入圆柱的底面的半径", 10);
		radiusTextField = bpRadius.getJTextField();
		radiusTextField.addFocusListener(this);
		bpHeight = new BoxPanel("请输入圆柱的高     ：", 10);
		heightTextField = bpHeight.getJTextField();
		heightTextField.addFocusListener(this);
		buttonPanel = new JPanel();
		resultButton = new JButton("计算结果：");
		resultButton.addActionListener(this);
		clearButton = new JButton("清空：");
		clearButton.addActionListener(this);
		buttonPanel.add(resultButton);
		buttonPanel.add(clearButton);
		bpSurfaceArea = new BoxPanel("圆柱的表面积", 20);
		this.surfaceAreaTextField = this.bpSurfaceArea.getJTextField();
		bpVolume = new BoxPanel("圆柱的表面积：", 20);
		this.volumeTextField = this.bpVolume.getJTextField();
		box.add(bpRadius);
		box.add(bpHeight);
		box.add(buttonPanel);
		box.add(bpSurfaceArea);
		box.add(bpVolume);
		leftPanel.add(box);
		add(leftPanel);
		add(rightPanel);

	}

	// 接口ActionListener 中的方法，当单击按钮时执行此方法
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == resultButton) {
			try {
				double radius = Double.parseDouble(radiusTextField.getText());
				double height = Double.parseDouble(heightTextField.getText());
				double area = Math.PI * radius * radius;
				surfaceAreaTextField.setText("" + (Math.PI * 2 * radius * height + 2 * area));
				volumeTextField.setText("" + area * height);

			} catch (NumberFormatException e1) {
				// 若输入的参数不是数字，则弹出警告的对话框
				JOptionPane.showMessageDialog(this, "请输入数字：", "警告对话框", JOptionPane.WARNING_MESSAGE);

			}
		} else if (e.getSource() == clearButton) {
			radiusTextField.setText("");
			heightTextField.setText("");

		}
	}

	public void focusGained(FocusEvent e) {
		inputTextField = (JTextField) e.getSource();

	}

	// FocusListener 接口中的方法，当事件源失去焦点是调用这个方法
	public void focusLost(FocusEvent e) {
	}

	public JTextField getInputTextField() {
		return inputTextField;

	}

}
