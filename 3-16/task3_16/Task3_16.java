/**
* Task3-16 : 課題内容
* 理解/定着課題⑦（パッケージ/インポート/継承/オーバーロード/オーバーライド/コレクション/日付操作）
*
* 問①〜問⑤の空欄を埋めて、指示通りに出力してください。
*/

package task3_16;

// 問①：必要なimport文を記述してください（List / ArrayList / LocalDate）
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

public class Task3_16 {
    public static void main(String[] args) {
        /*
         * 問②
         * ArrayListを作成し、"Java", "SQL", "HTML" を順に追加してください。
         * その後、拡張for文で内容を表示してください。
         */
        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("SQL");
        list.add("HTML");

        for (String item : list) {
            System.out.println(item);
        }

        /*
         * 問③
         * LocalDateを使って、今日の日付を取得し「yyyy-MM-dd」の形式で表示してください。
         */
        LocalDate today = LocalDate.now();
        System.out.println(today);

        /*
         * 問④
         * Personクラスのインスタンスを作成し、introduceメソッドを呼び出してください。
         * nameは"Yuki"、ageは20を指定します。
         */
        Person person = new Person("Yuki", 20);
        person.introduce();

        /*
         * 問⑤
         * Studentクラスのインスタンスを作成し、introduceメソッドを呼び出してください。
         * nameは"Ken"、ageは22、schoolは"Tech University"を指定します。
         */
        Student student = new Student("Ken", 22, "Tech University");
        student.introduce();
    }
}