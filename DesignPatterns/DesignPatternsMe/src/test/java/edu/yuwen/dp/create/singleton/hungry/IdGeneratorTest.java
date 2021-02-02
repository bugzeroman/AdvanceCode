package edu.yuwen.dp.create.singleton.hungry;

import org.junit.jupiter.api.Test;

public class IdGeneratorTest {

    @Test
    public void testGetId() {
        IdGenerator idGenerator = IdGenerator.getInstance();
        Long id = idGenerator.getId();
        System.out.println(id);
    }

    @Test
    public void testGetIds() {
        IdGenerator idGenerator = IdGenerator.getInstance();
        for (int i = 0; i < 10; i++) {
            Long id = idGenerator.getId();
            System.out.println(id);
        }
    }
}
