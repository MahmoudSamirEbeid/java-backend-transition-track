import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Exercise05 {

    public static void main(String[] args) {

        Class<Student> studentClass = Student.class;

        if (studentClass.isAnnotationPresent(Author.class)) {
            System.out.println("Class: Student");
        }

        for (Field field : studentClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Author.class)) {
                System.out.println("Field: " + field.getName());
            }
        }

        for (Constructor<?> constructor : studentClass.getDeclaredConstructors()) {
            if (constructor.isAnnotationPresent(Author.class)) {
                System.out.println("Constructor: " + constructor.getName());
            }
        }

        for (Method method : studentClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Author.class)) {
                System.out.println("Method: " + method.getName());
            }
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target({
        ElementType.TYPE,
        ElementType.FIELD,
        ElementType.CONSTRUCTOR,
        ElementType.METHOD
})
@interface Author {
}

@Author
class Student {

    @Author
    private String name;

    @Author
    public Student() {
    }

    @Author
    public void print() {
        System.out.println("Hello");
    }
}