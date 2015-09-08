package calculator;

import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * 获取当前图形界面中获得焦点的文本框对象
 */
public abstract class AbstractPanel extends JPanel {

    public abstract JTextField getInputTextField();

}
