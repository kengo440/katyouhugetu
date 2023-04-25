package ex0201;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class katyouhugetu {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		List<String> kanji = new ArrayList<String>();
		kanji.add("日");
		kanji.add("月");
		kanji.add("火");
		kanji.add("水");
		kanji.add("木");
		kanji.add("金");
		kanji.add("土");
		kanji.add("風");
		kanji.add("花");
		kanji.add("鳥");
		kanji.add("山");
		kanji.add("石");
		kanji.add("光");
		kanji.add("星");
		kanji.add("電");
		
		List<List> board = new ArrayList<List>();
		
		for(int i=0; i < 8; i++) {
			List<String> line = new ArrayList<String>();
			for(int j=0; j < 6; j++) {
				line.add(kanji.get((int)(Math.random() * kanji.size())));
			}
			board.add(line);
		}
		
		// ゲームループ
		while(true) {
			drawBoard(board);
			
			Scanner scan = new Scanner(System.in);
			System.out.print("行列を入力してください（例：A1）：" );
			String order = scan.next();
			String[] splitOrder = order.split("");
			int orderLine = 0;
			if(splitOrder[0].equals("A")) {
				orderLine = 0;
			}else if(splitOrder[0].equals("B")) {
				orderLine = 1;
			}else if(splitOrder[0].equals("C")) {
				orderLine = 2;
			}else if(splitOrder[0].equals("D")) {
				orderLine = 3;
			}else if(splitOrder[0].equals("E")) {
				orderLine = 4;
			}else if(splitOrder[0].equals("F")) {
				orderLine = 5;
			}
			int orderRow = Integer.parseInt(splitOrder[1]) - 1;
			Scanner scanDirection = new Scanner(System.in);
			System.out.print("方向を入力してください（上：0　右：1　下：2　左：3）：" );
			String orderDirection = scanDirection.next();
			String saveStr = (String)board.get(orderRow).get(orderLine);
			if(Integer.parseInt(orderDirection) == 0) {
				List oldList = board.get(orderRow);
				oldList.set(orderLine, board.get(orderRow - 1).get(orderLine));
				
				List oldList2 = board.get(orderRow - 1);
				oldList2.set(orderLine, saveStr);
				
				board.set(orderRow, oldList);
				board.set(orderRow - 1, oldList2);
			}else if(Integer.parseInt(orderDirection) == 1){
				List oldList = board.get(orderRow);
				oldList.set(orderLine, board.get(orderRow).get(orderLine + 1));
				
				List oldList2 = board.get(orderRow);
				oldList2.set(orderLine + 1, saveStr);
				
				board.set(orderRow, oldList2);
			}else if(Integer.parseInt(orderDirection) == 2){
				List oldList = board.get(orderRow);
				oldList.set(orderLine, board.get(orderRow + 1).get(orderLine));
				
				List oldList2 = board.get(orderRow + 1);
				oldList2.set(orderLine, saveStr);
				
				board.set(orderRow, oldList);
				board.set(orderRow + 1, oldList2);
			}else if(Integer.parseInt(orderDirection) == 3){
				List oldList = board.get(orderRow);
				oldList.set(orderLine, board.get(orderRow).get(orderLine - 1));
				
				List oldList2 = board.get(orderRow);
				oldList2.set(orderLine - 1, saveStr);
				
				board.set(orderRow, oldList2);
			}
			drawBoard(board);
			break;
		}
	}
	
	static void drawBoard(List<List> board) {
		System.out.println("　　Ａ｜Ｂ｜Ｃ｜Ｄ｜Ｅ｜Ｆ｜");
		System.out.println("　　ーーーーーーーーーーー");
		for(int i=0; i < board.size(); i++) {
			System.out.print(i + 1 + " 　");
			for(int j=0; j < board.get(i).size(); j++) {
				System.out.print(board.get(i).get(j) + "｜");
			}
			System.out.println();
			System.out.println("　　ーーーーーーーーーーー");
		}
	}
	
	static int judge(List<List> board) {
		return 1;
	}
}
