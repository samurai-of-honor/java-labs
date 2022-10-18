package lab2;
import java.util.Objects;

public class Person {
    private final String name, address;
    private final Integer age;

    public Person(String name, Integer age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Person)) {
            return false;
        }

        Person p = (Person) obj;
        // Object.equals instead of the usual comparison of fields because Strings are also objects
        return Objects.equals(this.name, p.name) &&
                Objects.equals(this.age, p.age) &&
                Objects.equals(this.address, p.address);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(name, age, address);
    }
}