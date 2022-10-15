package lab2;

import com.google.gson.Gson;
import nl.jqno.equalsverifier.EqualsVerifier;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PersonTest {
    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Person.class).verify();
    }

    @Test
    void testEqualsAfterSerialization() {
        Gson gson = new Gson();
        Person per1 = new Person("Студент",  19, "Гуртожиток 1");
        Person per2 = new Person("Студент",  19, null);

        String jsonPer1 = gson.toJson(per1);
        Person fromJsonPer1 = gson.fromJson(jsonPer1, Person.class);

        assertThat(fromJsonPer1.equals(per1)).isTrue();
        assertThat(fromJsonPer1.equals(per2)).isFalse();
    }
}
