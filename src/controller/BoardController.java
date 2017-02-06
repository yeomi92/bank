package controller;

import service.BoardService;
import serviceImpl.BoardServiceImpl;
import java.util.*;

import javax.swing.JOptionPane;

import domain.ArticleBean;
import enums.BoardButt;
import enums.Butt;

public class BoardController {
	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
		Vector<ArticleBean> list=new Vector<ArticleBean>(10,10);
		ArticleBean param=null;
		BoardButt[] buttons ={BoardButt.EXIT,BoardButt.ADD,BoardButt.FIND_LAST_ARTICLE,BoardButt.FIND_BY_SEQ,BoardButt.FIND_BY_ID,BoardButt.LIST,BoardButt.CHANGE,BoardButt.REMOVE};
		while(true){
			BoardButt select=(BoardButt)JOptionPane.showInputDialog(
					null, //frame
					"BOARD", //frame title
					"SELECT MENU", //order
					JOptionPane.QUESTION_MESSAGE, //type
					null, //icon
					buttons, //Array of choices
					buttons[1] //default
					);
			switch(select){
			case EXIT:return;
			case ADD:
				param=new ArticleBean();
				String[] articleArr=JOptionPane.showInputDialog("������, ���̵�, Ÿ��Ʋ, �ۼ��ð�").split(" ");
				param.setSeq(articleArr[0]);
				param.setUid(articleArr[1]);
				param.setTitle(articleArr[2]);
				param.setReadCount(articleArr[3]);
				service.addArticle(param);
				break;
			case FIND_LAST_ARTICLE:
				JOptionPane.showMessageDialog(null, service.findOne1(param).toString());
				break;
			case FIND_BY_SEQ:
				param=new ArticleBean();
				param.setSeq(JOptionPane.showInputDialog("ã����� article�� �������� �Է��ϼ���."));
				JOptionPane.showMessageDialog(null, service.findOne2(param).toString());
				break;
			case FIND_BY_ID:
				param=new ArticleBean();
				param.setUid(JOptionPane.showInputDialog("ã����� article�� �ۼ��� ����� ID�� �Է��ϼ���."));
				list=service.findSome(param);
				JOptionPane.showMessageDialog(null, list);
				break;
			case LIST:
				list=service.boardList();
				JOptionPane.showMessageDialog(null, list);
				break;
			case CHANGE:
				param=new ArticleBean();
				param.setUid(JOptionPane.showInputDialog("Title�� �����ϰ���� article�� �������� �Է��ϼ���."));
				param.setTitle(JOptionPane.showInputDialog("���� ������ �Է��ϼ���."));
				service.changeContent(param);
				break;
			case REMOVE:
				param=new ArticleBean();
				param.setUid(JOptionPane.showInputDialog("�����ϰ���� article�� �������� �Է��ϼ���."));
				service.removeContent(param);
				break;
			}
		}
		/*// 0.����Ʈ ���庸��
		System.out.println("capacity: "+list.capacity());
		System.out.println("size: "+list.size());
		// 1.�߰�..�־��� BbsBean ���� vec �� �߰��ϱ�
		// 1,James,Hello,2016-2-6 17:30
		// 2,Tom,Hi,2016-8-6 17:30
		// 3,Alex,Good Morning,2016-11-20 17:30
		// 4,Betty,I'm happy,2016-12-25 17:30
		// 5,John,Thank you,2017-2-6 17:30
		ArticleBean a=new ArticleBean();
		a.setSeq("1");
		a.setUid("James");
		a.setTitle("Hello");
		a.setRegdate("2016-2-6 17:30");
		list.add(a);
		a=new ArticleBean();
		a.setSeq("2");
		a.setUid("Tom");
		a.setTitle("Hi");
		a.setRegdate("2016-8-6 17:30");
		list.add(a);
		a=new ArticleBean();
		a.setSeq("3");
		a.setUid("Alex");
		a.setTitle("Good Morning");
		a.setRegdate("2016-11-20 17:30");
		list.add(a);
		a=new ArticleBean();
		a.setSeq("4");
		a.setUid("Betty");
		a.setTitle("I'm happy");
		a.setRegdate("2016-12-25 17:30");
		list.add(a);
		a=new ArticleBean();
		a.setSeq("5");
		a.setUid("John");
		a.setTitle("Thank you");
		a.setRegdate("2017-2-6 17:30");
		list.add(a);
		a=new ArticleBean();
		a.setSeq("6");
		a.setUid("James");
		a.setTitle("Good bye");
		a.setRegdate("2017-2-6 17:35");
		list.add(a);

		// 2-1.�˻�(1)..�������� �߰��� �� �˻�, 
		System.out.println("1. �������� �߰��� �� �˻�: ");
		String result="";
		for(int i=0;i<list.size();i++){
			if(i==(list.size()-1)){
				result=list.get(i).toString();
			}
		}
		System.out.println(result+"\n");
		System.out.println("2. seq�� 3�� �� �˻�: ");
		// 2-2.�˻�(1)..seq�� 3�� �� �˻�
		Set<ArticleBean> set=new HashSet<ArticleBean>();
		for(int i=0;i<list.size();i++){
			if("3".equals(list.get(i).getSeq())){
				set.add(list.get(i));
				break;
			}
		}
		System.out.println(set.toString()+"\n");
		// 3.�˻�(some)...James �� �� �� �˻�
		System.out.println("3. James�� �� �� �˻�: ");
		result="�ش� ���� �����ϴ�.";
		for(int i=0;i<list.size();i++){
			if("James".equals(list.get(i).getUid())){
				result+=list.get(i).toString()+"\n";
			}
		}
		System.out.println(result);
		// 4.��ü ���
		System.out.println("4. ��ü ���");
		System.out.println(list);
		System.out.println();
		// 5.���� (seq�� 1�� ���� ������ Good Bye)�� ����
		System.out.println("5. seq�� 1�� ���� ������ Good Bye�� ����");
		for(int i=0;i<list.size();i++){
			if("1".equals(list.get(i).getSeq())){
				list.get(i).setTitle("Good Bye");
				result=list.get(i).toString();
			}
		}
		System.out.println(result+"\n");
		// ������ ������ �ٲ� �۳��� ����ϱ�

		// 6.���� (seq�� 3�� ���� ����)
		System.out.println("6. seq�� 3�� �� ����");
		Iterator<ArticleBean> it=list.iterator();
		Iterator<ArticleBean> it2=list.iterator();
		while(it.hasNext()){
			if(it.next().getSeq().equals("3")){
				it.remove();
				break;
			}
		}
		System.out.println(list);*/
	}
}
