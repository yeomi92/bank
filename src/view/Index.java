package view;

import javax.swing.JOptionPane;

import controller.AdminController;
import controller.CustomerController;

public class Index {
	public static void main(String[] args) { 
		while(true){
			switch(JOptionPane.showInputDialog("0.���� 1.�Ϲ�ȸ�� 2.������")){
				case "0":
					return;
				case "1":
					new CustomerController().start();
					break;
				case "2":
					new AdminController().start();
					break;
			}
		}
	}
}
