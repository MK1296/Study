public class Task4_27 {

    public static void main(String[] args) {

        String[] names = {"Aki", "Ken", "Mina"};

        try {

            System.out.println(names[3]);

        } catch (ArrayIndexOutOfBoundsException e) {

            System.out.println(e);

            System.out.println("配列の範囲外アクセスが発生しました");

        } finally {

            System.out.println("finallyの処理です");

        }

        System.out.println("処理を続けます");
    }
}

/**
 * 問2
 * 原因：配列の要素数を超えたインデックスを指定したため。
 * 
 * 対処方法：try-catch文を使用して例外処理を行い、エラー発生時でも処理が停止しないように修正する。
*/