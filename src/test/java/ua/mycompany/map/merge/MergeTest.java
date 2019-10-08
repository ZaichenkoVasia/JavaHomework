package ua.mycompany.map.merge;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertThat;
import static ua.mycompany.map.merge.Merge.mergeByCounter;
import static ua.mycompany.map.merge.Merge.mergeByMapMethod;

public class MergeTest {

    @Test
    public void shouldReturnCounterOfCharByCounterMethod() {
        Map<Character, Integer> charToCounters = mergeByCounter("Hello");
        assertThat(charToCounters, Matchers.hasEntry('e', 1));
        assertThat(charToCounters, Matchers.hasEntry('l', 2));
        assertThat(charToCounters, Matchers.hasEntry('H', 1));
        assertThat(charToCounters, Matchers.hasEntry('o', 1));
        assertThat(charToCounters.values(), Matchers.hasSize(4));
    }

    @Test
    public void shouldReturnCounterOfCharByMapMethod() {
        Map<Character, Integer> charToCounters = mergeByMapMethod("Hello");
        assertThat(charToCounters, Matchers.hasEntry('e', 1));
        assertThat(charToCounters, Matchers.hasEntry('l', 2));
        assertThat(charToCounters, Matchers.hasEntry('H', 1));
        assertThat(charToCounters, Matchers.hasEntry('o', 1));
        assertThat(charToCounters.values(), Matchers.hasSize(4));
    }
}
