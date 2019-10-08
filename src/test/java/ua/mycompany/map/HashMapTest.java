package ua.mycompany.map;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class HashMapTest {

    private Map <String, String> surnameToName;
    @Before
    public void setUp(){
        surnameToName = new HashMap<>();
        surnameToName.put ("MySurname", "Vasyl");
        surnameToName.put ("Zaichenko", "Ivan");
        surnameToName.put ("Tsaruk", "Vova");
    }

    @Test
    public void shouldReturnPutedNodeToHashMap() {
        assertThat(surnameToName.values(), Matchers.hasItems("Vasyl", "Vova", "Ivan"));
        assertThat(surnameToName.values(), Matchers.hasSize(3));
        assertThat(surnameToName.keys(), Matchers.hasItems("MySurname", "Zaichenko"));
        assertThat(surnameToName.keys(), Matchers.hasSize(2));
    }

    @Test
    public void shouldReturnValueByKeyFromHashMap() {
        assertThat("Vasyl", is(surnameToName.getByKey("MySurname")));
        assertThat("Ivan", is(surnameToName.getByKey("Zaichenko")));
        assertThat("Vova", is(surnameToName.getByKey("Tsaruk")));
    }

    @Test
    public void shouldReturnSizeHashMap() {
        assertThat(2, is(surnameToName.size()));
        surnameToName.put ("NewSurname", "NewName");
        assertThat(3, is(surnameToName.size()));
    }

    @Test
    public void shouldReturnTrueIfEmptyList() {
        surnameToName = new HashMap<>();
        assertThat(true, is(surnameToName.isEmpty()));
    }

    @Test
    public void shouldReturnCollectionOfValuesHashMap() {
        assertThat(surnameToName.values(), Matchers.hasItems("Vasyl", "Vova", "Ivan"));
    }

    @Test
    public void shouldReturnSetOfKeysHashMap() {
        assertThat(surnameToName.keys(), Matchers.hasItems("MySurname", "Zaichenko"));
    }

    @Test
    public void shouldGrowHashMapForMoreThanEightNode() {
        surnameToName.put ("wrhwerwerwerwerwe", "NewName1");
        surnameToName.put ("rwerwerjwejrwejrejwrjwe", "NewName2");
        surnameToName.put ("rwejrewhjrhewjrhwehrrrweewewew", "NewName3");
        surnameToName.put ("rekwrewjjewj", "NewName4");
        surnameToName.put ("fdsjkfjsdjfjdsjfsdjsdjfjsdjjdsjdsjsjs", "NewName5");
        surnameToName.put ("refdjsjfdfdsdsjjsjswjw", "NewName6");
        surnameToName.put ("rfdjsjdsjdsjdsjsdjsdjewjw", "NewName7");
        surnameToName.put ("rewkdskskskskskskskskskskjw", "NewName8");
        surnameToName.put ("11111111111111111111111", "NewName9");
        surnameToName.put ("2222222222222222222222", "NewName10");
        surnameToName.put ("3333333333333333333", "NewName11");
        assertThat(13, is(surnameToName.size()));
    }
}
