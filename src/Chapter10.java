import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Chapter10 {
	public static void main(String[] args) throws Exception {
		List<Task> list = new ArrayList<>();
		list.add(new Task(LocalDate.of(2021,  10, 21), "牛乳を買う", true));
		list.add(new Task(LocalDate.of(2021,  9, 15), "○○社面接", false));
		list.add(new Task(LocalDate.of(2021,  12, 4), "手帳を買う", true));
		list.add(new Task(LocalDate.of(2021,  8, 10), "散髪に行く", false));
		list.add(new Task(LocalDate.of(2021,  11, 9), "スクールの課題を解く", false));
		
		// 未完了のタスク（done=false）の個数をカウント
		long notDone = list.stream()
		.filter(n -> n.isDone() == false)
		.count();
		// 未完了のタスク個数を表示
		System.out.println("未完了のタスクの個数は" + notDone);
		
		System.out.println("【未完了のタスクを昇順に並び替えて一覧表示】");	
		list.stream()
		.filter(n -> n.isDone() == false)      // 未完了のタスクでフィルター
		.sorted((n1, n2) -> n1.compareTo(n2))  // 日付順に並び替え
		.forEach(System.out::println);
	}
}
