package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.ItemService;

@Controller
public class ItemController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("item/list")
	public ModelAndView list() {
		List<Item> itemList = itemService.getItemList();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("itemList", itemList);
		ModelAndView mav = new ModelAndView("list");
		mav.addAllObjects(model);
		return mav;
	}
	
	/*@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:login.shop");
		return mav;
		
	}*/

}
