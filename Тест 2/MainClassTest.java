public class MainClassTest extends MainClass{
    public void testGetClassNumber(){
        String s = (getClassNumber() < 45) ?  "Проверка успешна" : "Ошибка: метод getClassNumber() возвращает число меньше 45";
        System.out.println(s);

    }
}
