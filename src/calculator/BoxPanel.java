package calculator;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * BoxPanel类是javax.swing包中JPanel的一个子类
 */
public class BoxPanel extends JPanel {
    //创建一个
    JTextField text;

    // 初始化面板
    public BoxPanel(String s, int n) {
	// 创建水平排列的组件的Box容器的对象box
	Box box = Box.createHorizontalBox();
	box.add(new JLabel(s));
	text = new JTextField("", n);
	// 设置文本框文本右对齐
	text.setHorizontalAlignment(JTextField.RIGHT);
	// 设置文本框内文本的字体格式
	text.setFont(new Font("Arial", Font.BOLD, 15));
	box.add(text);
	add(box);

    }

    // 获取当前容器的文本框对象
    public JTextField getJTextField() {
	return text;

    }

}
