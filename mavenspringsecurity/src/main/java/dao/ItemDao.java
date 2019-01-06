package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import logic.Item;
@Repository
public class ItemDao {
	
	private NamedParameterJdbcTemplate template;
	RowMapper<Item> mapper = new BeanPropertyRowMapper<Item>(Item.class);
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		template = new NamedParameterJdbcTemplate(dataSource);
	}

	public List<Item> findAll() {
		String sql = "select * from item order by id";
		return template.query(sql, mapper);
	}

	public Item findByPrimaryKey(Integer itemId) {
		String sql = "select * from item where id = :id";
		Map<String, Integer> map = new HashMap<String, Integer>();
		return template.queryForObject(sql, map, mapper);
	}
	public void create(Item item) {
		String sql = "select nvl(max(id),0) from item";
		int i = template.queryForObject(sql, new HashMap<String,Object>(),Integer.class );
		item.setId(++i);
		sql = "insert into item (id, name, price, description, pictureUrl) values (:id, :name, :price, :desciption, :pictureUrl)";
		item.setPictureUrl(item.getPicture().getOriginalFilename());
		SqlParameterSource param = new BeanPropertySqlParameterSource(item);
		template.update(sql, param); 
	}
}
