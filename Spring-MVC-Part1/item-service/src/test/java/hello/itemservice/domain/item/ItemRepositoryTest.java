package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    public void save() {
        // Given
        Item item = new Item("item", 10000, 10);

        // When
        Item saveItem = itemRepository.save(item);

        // Then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    public void findAll() {
        // Given
        Item item1 = new Item("item1", 10000, 10);
        Item item2 = new Item("item2", 20000, 20);
        itemRepository.save(item1);
        itemRepository.save(item2);

        // When
        List<Item> result = itemRepository.findAll();

        // Then
        assertThat(result).contains(item1, item2);
    }

    @Test
    public void update() {
        // Given
        Item item = new Item("item1", 10000, 10);
        Item savedItem = itemRepository.save(item);
        Long itemId = savedItem.getId();

        // When
        Item updateParam = new Item("item2", 20000, 20);
        itemRepository.update(itemId, updateParam);

        // Then
        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }
}