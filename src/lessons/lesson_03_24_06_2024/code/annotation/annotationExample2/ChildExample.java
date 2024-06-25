package lessons.lesson_03_24_06_2024.code.annotation.annotationExample2;

public class ChildExample extends ParentExample{

 @Override
    public void printDate() {
        System.out.println("Печатаем как дочерний класс");
    }
}
