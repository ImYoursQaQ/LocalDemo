
/*反射示例*/
package other;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Person implements Serializable {

    private String name;
    private int age;

    public Person(String name, int i) {
        this.name = name;
        this.age = i;
    }
// get/set方法


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person person = new Person("luoxn28", 23);
        Class clazz = person.getClass();

        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String key = field.getName();
            PropertyDescriptor descriptor = null;
            try {
                descriptor = new PropertyDescriptor(key, clazz);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            Method method = descriptor.getReadMethod();
            Object value = null;
            try {
                value = method.invoke(person);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            System.out.println(key + ":" + value);

        }
    }
}