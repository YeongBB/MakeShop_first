package myshop.firstshop.controller;

import lombok.RequiredArgsConstructor;
import myshop.firstshop.domain.Item;
import myshop.firstshop.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping("/item/new")
    public String createForm(Model model){
        model.addAttribute("form", new ItemForm());
        return "items/createItemForm";
    }

    @PostMapping("/items/new")
    public String create(ItemForm form){
        Item item = new Item(form.getName(), form.getPrice(), form.getQuantity());
        itemService.saveItem(item);
        return "redirect:/items";
    }

    @GetMapping("/items")
    public String itemList(Model model){
        List<Item> items = itemService.itemList();
        model.addAttribute("items", items);
        return "items/itemList";
    }

    @GetMapping("/items/edit/{itemId}")
    public String editItemForm(@PathVariable Long itemId, Model model){
        Item item = itemService.findItem(itemId);

        ItemForm itemForm = new ItemForm(item.getId(), item.getName(), item.getPrice(), item.getQuantity());

        model.addAttribute("form", itemForm);
        return  "items/editItemForm";
    }

    @PostMapping("/items/edit/{itemId}")
    public String editItem(@PathVariable Long itemId, Model model, ItemForm form){
        itemService.updateItem(itemId,form.getName(), form.getPrice(), form.getQuantity());
        model.addAttribute("form", form);
        return "redirect:/items";
    }
}
