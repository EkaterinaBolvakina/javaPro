package lessons.lesson_03_24_06_2024.code.annotation.depricatedAnnotation;

public class Child extends Parent{
    @Override
    @Deprecated(since = "1.2", forRemoval = true)
    public void printData() {
        System.out.println("класс наследник");
    }
}
