package lessons.lesson_03_24_06_2024.code.annotation.depricatedAnnotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})

public @interface DepricatedAnnotation {
}
