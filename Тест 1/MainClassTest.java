public class MainClassTest extends MainClass{
    public void testGetLocalNumber(){
        String s = (getLocalNumber() == 14) ?  "Проверка успешна" : "Ошибка: метод getLocalNumber() возвращает не 14";
        System.out.println(s);

    }
}
