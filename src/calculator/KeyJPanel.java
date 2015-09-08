package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/*
 * 创建一个数字软键盘
 */
public class KeyJPanel extends JPanel implements ActionListener {
    JButton[] keyButton = new JButton[12];
    String[] num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", ".", "BackSpace" };
    AbstractPanel selectedPanel;
    JTextField inputTextField;
    int length;

    // 构造方法，初始化数字键盘界面，输入参数是某个图形面板对象
    public KeyJPanel(AbstractPanel selectedPanel) {
	this.selectedPanel = selectedPanel;
	// 设置面板的边框
	Border lb = BorderFactory.createLineBorder(Color.gray, 2);
	setBorder(lb);
	// 设置布局是GridLayout型
	setLayout(new GridLayout(4, 3));

	// 创建按钮对象数组，给每个元素注册ActionEvent事件监听器
	for (int i = 0; i < 12; i++) {
	    keyButton[i] = new JButton(num[i]);
	    keyButton[i].setFont(new Font("Arial", Font.BOLD, 15));
	    keyButton[i].setForeground(Color.BLACK);
	    keyButton[i].addActionListener(this);
	    add(keyButton[i]);

	}

    }

    // 接口ActionListener中的方法，当单击按钮时，执行此方法
    public void actionPerformed(ActionEvent e) {
	// 获取事件源
	JButton button = (JButton) e.getSource();
	// 获取KeyJPanel对象所在的图形面板上的获取焦点的文本框对象
	inputTextField = selectedPanel.getInputTextField();
	// inputNumber方法负责button对象对inputTextField的输入
	inputNumber(inputTextField, button);

    }

    public void inputNumber(JTextField tf, JButton button) {
	// 获取上一次单击按钮时文本框内的值

	String oldString = tf.getText();

	if (oldString == null) {
	    tf.setText(" ");

	}
	//这里的if-else语句用来防止oldSting.leng() - 1 < 0 抛异常
	if(oldString.length() - 1 <= 0){
	    length = 0;
	}
	else{
	    length = oldString.length() -1;
	}

	String subStr = oldString.substring(0,length);

	// 获取当前按钮的文本信息，作为新串
	String newString = button.getText();
	// 若单击了"backSpace"键，取子串
	if (newString.equals("BackSpace")) {

	    tf.setText(subStr);

	}
	// 若单击了"."按钮，做字串的连接
	else if (newString.equals(".")) {
	    tf.setText(oldString + ".");

	} else {
	    tf.setText(oldString + newString);

	}
    }

}
