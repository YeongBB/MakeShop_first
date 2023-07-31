package myshop.firstshop.service;

import lombok.RequiredArgsConstructor;
import myshop.firstshop.domain.Item;
import myshop.firstshop.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    // Item 저장
    @Transactional
    public void saveItem(Item item){
        itemRepository.save(item);
    }

    // 아이템 찾기
    public Item findItem(Long id){
        return itemRepository.findById(id).get();
    }

    // Item 업데이트
    public void updateItem(Long id, String name, int price, int quantity){
        Optional<Item> findItem = itemRepository.findOne(id);
        Item item = itemRepository.findOne(id).get();
        item.updateItem(name,price,quantity);
    }

    // 아이템 모두 출력
    public List<Item> itemList(){
        return itemRepository.findAll();
    }

    // 아이템 삭제
    public void deleteItem(Long id){
        itemRepository.deleteById(id);
    }




}
