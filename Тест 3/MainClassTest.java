import org.junit.Test;

public class MainClassTest extends MainClass{
    @Test
    public void testGetClassString(){
        String sub1 = "hello";
        String sub2 = "Hello";

        String s = (getClassString().indexOf(sub1) != -1 || getClassString().indexOf(sub2) != -1) ?  "Проверка успешна" : "Ошибка: getClassString не возвращает строку, в которой есть подстрока “hello” или “Hello”";
        System.out.println(s);

    }
}
