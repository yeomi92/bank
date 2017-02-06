package view;

import javax.swing.JOptionPane;

import controller.AdminController;
import controller.BoardController;
import controller.CustomerController;
import enums.Butt;

public class Index {
	public static void main(String[] args) {
		Butt[] buttons = {Butt.CLOSE,Butt.MEMBER,Butt.ADMIN,Butt.BOARD};
		Butt select=(Butt)JOptionPane.showInputDialog(null,"INDEX PAGE","SELECT MENU", JOptionPane.QUESTION_MESSAGE, null, buttons, buttons[2]);
			switch(select){
				case CLOSE:
					return;
				case MEMBER:
					new CustomerController().start();
					break;
				case ADMIN:
					new AdminController().start();
					break;
				case BOARD:
					new BoardController().start();
					break;
			}
	}
}
