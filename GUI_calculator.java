import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class GUI_calculator implements ActionListener {
	JFrame cal;
	JTextField num;
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, zero, clr, p2, p3, exp, fac, add, sub, div, log, rec, mul, eq,addSub, sqrt, sin, cos, tan;
	JPanel texts, buttons;
	double tmp, res, a;
	char c;
	int z = 0;

	public GUI_calculator() {
		// TODO Auto-generated constructor stub
		cal = new JFrame("Calculator");
		cal.setSize(400, 400);
		cal.setLayout(new GridLayout(2, 2));

		texts = new JPanel();
		num = new JTextField(35);
		texts.add(num);

		buttons = new JPanel();
		buttons.setLayout(new GridLayout(6, 4, 2, 2));

		b1 = new JButton("1");
		buttons.add(b1);
		b1.addActionListener(this);
		b2 = new JButton("2");
		buttons.add(b2);
		b2.addActionListener(this);
		b3 = new JButton("3");
		buttons.add(b3);
		b3.addActionListener(this);

		b4 = new JButton("4");
		buttons.add(b4);
		b4.addActionListener(this);
		b5 = new JButton("5");
		buttons.add(b5);
		b5.addActionListener(this);
		b6 = new JButton("6");
		buttons.add(b6);
		b6.addActionListener(this);

		b7 = new JButton("7");
		buttons.add(b7);
		b7.addActionListener(this);
		b8 = new JButton("8");
		buttons.add(b8);
		b8.addActionListener(this);
		b9 = new JButton("9");
		buttons.add(b9);
		b9.addActionListener(this);

		zero = new JButton("0");
		buttons.add(zero);
		zero.addActionListener(this);

		add = new JButton("+");
		buttons.add(add);
		add.addActionListener(this);

		sub = new JButton("-");
		buttons.add(sub);
		sub.addActionListener(this);

		mul = new JButton("*");
		buttons.add(mul);
		mul.addActionListener(this);

		div = new JButton("/");
		div.addActionListener(this);
		buttons.add(div);

		addSub = new JButton("+/-");
		buttons.add(addSub);
		addSub.addActionListener(this);

		eq = new JButton("=");
		buttons.add(eq);
		eq.addActionListener(this);

		rec = new JButton("1/x");
		buttons.add(rec);
		rec.addActionListener(this);
		sqrt = new JButton("Sqrt");
		buttons.add(sqrt);
		sqrt.addActionListener(this);
		log = new JButton("log");
		buttons.add(log);
		log.addActionListener(this);

		sin = new JButton("SIN");
		buttons.add(sin);
		sin.addActionListener(this);
		cos = new JButton("COS");
		buttons.add(cos);
		cos.addActionListener(this);
		tan = new JButton("TAN");
		buttons.add(tan);
		tan.addActionListener(this);
		fac = new JButton("F!");
		fac.addActionListener(this);
		buttons.add(fac);

		clr = new JButton("AC");
		buttons.add(clr);
		clr.addActionListener(this);

		cal.add(texts);
		cal.add(buttons);
		cal.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();

		if (s.equals("1")) {
			if (z == 0) {
				num.setText(num.getText() + "1");
			} else {
				num.setText("");
				num.setText(num.getText() + "1");
				z = 0;
			}
		}

		if (s.equals("2")) {
			if (z == 0) {
				num.setText(num.getText() + "2");
			} else {
				num.setText("");
				num.setText(num.getText() + "2");
				z = 0;
			}
		}
		if (s.equals("3")) {
			if (z == 0) {
				num.setText(num.getText() + "3");
			} else {
				num.setText("");
				num.setText(num.getText() + "3");
				z = 0;
			}
		}
		if (s.equals("4")) {
			if (z == 0) {
				num.setText(num.getText() + "4");
			} else {
				num.setText("");
				num.setText(num.getText() + "4");
				z = 0;
			}
		}
		if (s.equals("5")) {
			if (z == 0) {
				num.setText(num.getText() + "5");
			} else {
				num.setText("");
				num.setText(num.getText() + "5");
				z = 0;
			}
		}
		if (s.equals("6")) {
			if (z == 0) {
				num.setText(num.getText() + "6");
			} else {
				num.setText("");
				num.setText(num.getText() + "6");
				z = 0;
			}
		}
		if (s.equals("7")) {
			if (z == 0) {
				num.setText(num.getText() + "7");
			} else {
				num.setText("");
				num.setText(num.getText() + "7");
				z = 0;
			}
		}
		if (s.equals("8")) {
			if (z == 0) {
				num.setText(num.getText() + "8");
			} else {
				num.setText("");
				num.setText(num.getText() + "8");
				z = 0;
			}
		}
		if (s.equals("9")) {
			if (z == 0) {
				num.setText(num.getText() + "9");
			} else {
				num.setText("");
				num.setText(num.getText() + "9");
				z = 0;
			}
		}
		if (s.equals("0")) {
			if (z == 0) {
				num.setText(num.getText() + "0");
			} else {
				num.setText("");
				num.setText(num.getText() + "0");
				z = 0;
			}
//			if (s.equals("+")) {
//				if (num.getText().equals("")) {
//					num.setText("");
//					tmp = 0;
//					c = '+';
//				} else {
//					tmp = Double.parseDouble(num.getText());
//					num.setText("");
//					c = '+';
//				}
//				num.requestFocus();
//			}
		}
		if (s.equals("AC")) {
			num.setText("");
			z = 0;
		}
		if (s.equals("log")) {
			if (num.getText().equals("")) {
				num.setText("");
			} else {
				a = Math.log(Double.parseDouble(num.getText()));
				num.setText("");
				num.setText(num.getText() + a);
			}
		}
		if (Character.isDigit(s.charAt(0))) {
		} else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
			if (num.getText().equals("")) {
				num.setText("");
				a = 0;
				c = s.charAt(0);
			} else {
				a = Double.parseDouble(num.getText());
				num.setText("");
				c = s.charAt(0);
			}
		} else if (s.equals("=")) {
			if (c != '\0') {
				Double b = Double.parseDouble(num.getText());
				switch (c) {
				case '+':
					res = a + b;
					break;
				case '-':
					res = a - b;
					break;
				case '/':
					res = a / b;
					break;
				case '*':
					res = a * b;
					break;
				}
				num.setText("");
				num.setText(num.getText() + res);
				z = 1;
			}
		}
		if (s.equals("Sqrt")) {
			if (num.getText().equals("")) {
				num.setText("");
			} else {
				a = Math.sqrt(Double.parseDouble(num.getText()));
				num.setText("");
				num.setText(num.getText() + a);
			}
		}
		if (s.equals("1/x")) {
			if (num.getText().equals("")) {
				num.setText("");
			} else {
				a = 1 / Double.parseDouble(num.getText());
				num.setText("");
				num.setText(num.getText() + a);
			}
			
			if (s.equals("n!")) {
				if (!num.getText().isEmpty()) {
		            double number = Double.parseDouble(num.getText());
		            double result = fact(number);
		            num.setText(Double.toString(result));
		            z = 1;
		        }
		    }
		}
		if (s.equals("SIN")) {
			if (num.getText().equals("")) {
				num.setText("");
			} else {
				a = Math.sin(Double.parseDouble(num.getText()));
				num.setText("");
				num.setText(num.getText() + a);
			}
		}
		if (s.equals("COS")) {
			if (num.getText().equals("")) {
				num.setText("");
			} else {
				a = Math.cos(Double.parseDouble(num.getText()));
				num.setText("");
				num.setText(num.getText() + a);
			}
		}
		if (s.equals("TAN")) {
			if (num.getText().equals("")) {
				num.setText("");
			} else {
				a = Math.tan(Double.parseDouble(num.getText()));
				num.setText("");
				num.setText(num.getText() + a);
			}
		}
	}

	private double fact(double parseDouble) {
		int n = 0;
		// TODO Auto-generated method stub
	    if (n == 0) {
	        return 1;
	    }

	    double factorial = 1;
	    for (int i = 1; i <= n; i++) {
	        factorial *= i;
	    }
	    return factorial;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}
		new GUI_calculator();
	}
}