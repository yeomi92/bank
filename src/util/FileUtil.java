package util;

import java.util.Scanner;
import java.io.*;

public class FileUtil {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		File file=new File("C:\\Users\\hb2008\\eclipse\\jee-neon\\eclipse\\yeomhyeseon.txt");
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));//true를 써야 기존 것에 이어서 쓴다.
			BufferedReader reader=new BufferedReader(new FileReader(file));
			String msg="";
			while(true){
				System.out.println("메뉴 0.종료 1.작성 2.전송");
				switch (s.next()) {
				case "0":
					writer.close();
					return;
				case "1":
					System.out.println("메세지를 입력하세요.");
					writer.write(s.next());
					writer.newLine();
					writer.flush();//반드시 해줘야힌다.
					break;
				case "2":
					System.out.println("메시지 보기");
					while ((msg=reader.readLine())!=null) {
						System.out.println(msg);
					}
					reader.close();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
