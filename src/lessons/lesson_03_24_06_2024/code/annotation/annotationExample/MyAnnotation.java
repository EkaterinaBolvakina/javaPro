package lessons.lesson_03_24_06_2024.code.annotation.annotationExample;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyAnnotation {
}
