package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ItemDao;
import logic.Item;

@Service
public class ItemService {

	@Autowired
	private ItemDao itemDao;
	
	public List<Item> getItemList() {
		return this.itemDao.findAll();
	}
	
	public void entryItem(Item item) {
		this.itemDao.create(item);
	}
	public Item getItemByItemId(Integer itemId) {
		return this.itemDao.findByPrimaryKey(itemId);
	}

}
