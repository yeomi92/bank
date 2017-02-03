package controller;

import service.BoardService;
import serviceImpl.BoardServiceImpl;
import java.util.*;
import domain.ArticleBean;

		// 1.�߰�..�־��� BbsBean ���� vec �� �߰��ϱ�
		// 1,James,Hello,2016-2-6 17:30
		// 2,Tom,Hi,2016-8-6 17:30
		// 3,Alex,Good Morning,2016-11-20 17:30
		// 4,Betty,I'm happy,2016-12-25 17:30
		// 5,John,Thank you,2017-2-6 17:30
		// 2.�˻�(1)..seq�� 1�� �� �˻�, 
		// �ش� seq �� ������ ������ �����ְ�
		// ������ �ش���� �������� �ʴ´ٰ� �����
		// 3.�˻�(some)...
		// James �� �� �� �˻�
		// �ϳ��� ������ �ش���� �������� �ʴ´ٰ� �����
		// 4.��ü ���
		// ���� �ϳ��� ������
		// �� �Խ��� �̶�� �����
		// 5.���� (seq�� 1�� ���� ������ Good Bye)�� ����
		// ������ ������ �ٲ� �۳��� ����ϱ�
		// 6.���� (seq�� �� ���� ����)
		// ������ ������ �ش���� ���ٰ� �����
public class BoardController {
	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
		Vector<ArticleBean> list=new Vector<ArticleBean>(10,10);
		// 0.����Ʈ ���庸��
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
		result="";
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
		for(int i=0;i<list.size();i++){
			if("3".equals(list.get(i).getSeq())){
				list.remove(list.get(i));
			}
		}
		System.out.println(list);
		// ������ ������ �ش���� ���ٰ� �����
	}
}
