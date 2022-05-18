import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {

    private CustomLinkedList<String> list;

    @BeforeEach
    public void setup(){
        list = new CustomLinkedList<>();
    }

    @Test
    public void whenValidItemAddedToNewListItIsNoLongerEmpty(){
        assertTrue(list.isEmpty());
        list.add("0");
        assertFalse(list.isEmpty());
    }

    @Test
    public void whenValidItemAddedToNewListHeadIsAssigned() throws NoSuchFieldException, IllegalAccessException {
        assertTrue(list.isEmpty());
        list.add("0");

        Field firstNode = list.getClass().getDeclaredField("first");
        Field dataField = firstNode.getType().getDeclaredField("item");
        firstNode.setAccessible(true);
        dataField.setAccessible(true);
        Object node = firstNode.get(list);
        Object data = dataField.get(node);
        assertEquals("0", data.toString());

    }

    @Test
    public void whenValidItemAddedToNewListDataIsPresent() throws NoSuchFieldException, IllegalAccessException {
        assertTrue(list.isEmpty());
        list.add("0");
        Field firstField = list.getClass().getDeclaredField("first");
        Field dataField = firstField.getType().getDeclaredField("item");
        firstField.setAccessible(true);
        dataField.setAccessible(true);
        Object head = firstField.get(list);
        Object data = dataField.get(head);
        assertEquals("0", data.toString());
    }

    @Test
    public void whenValidItemsAddedToNewListOrderIsCorrect() throws NoSuchFieldException, IllegalAccessException {
        assertTrue(list.isEmpty());
        list.add("0");
        list.add("1");
        list.add("2");

        Field nodeField = list.getClass().getDeclaredField("first");
        Field dataField = nodeField.getType().getDeclaredField("item");
        Field nextField = nodeField.getType().getDeclaredField("next");

        nodeField.setAccessible(true);
        dataField.setAccessible(true);
        nextField.setAccessible(true);

        Object firstNode = nodeField.get(list);
        Object firstData = dataField.get(firstNode);
        Object secondNode = nextField.get(firstNode);
        Object secondData = dataField.get(secondNode);
        Object thirdNode = nextField.get(secondNode);
        Object thirdData = dataField.get(thirdNode);

        assertEquals("0", firstData.toString());
        assertEquals("1", secondData.toString());
        assertEquals("2", thirdData.toString());
    }

    @Test
    public void whenMultipleItemsAddedToNewListCountIsCorrect(){
        assertTrue(list.isEmpty());
        list.add("0");
        list.add("1");
        list.add("2");
        assertTrue(list.size() == 3);
    }
}