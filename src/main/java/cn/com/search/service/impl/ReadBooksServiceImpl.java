package cn.com.search.service.impl;

import cn.com.search.dao.ReadBooksMapper;
import cn.com.search.model.ReadBooks;
import cn.com.search.service.ReadBooksService;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example.Criteria;
import cn.com.search.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/12/16.
 */
@Service
@Transactional
public class ReadBooksServiceImpl extends AbstractService<ReadBooks> implements ReadBooksService {
    @Resource
    private ReadBooksMapper readBooksMapper;
    
    public Integer getCount() {
    	return readBooksMapper.selectCount(null);
    }

	@Override
	public List<ReadBooks> search(String keyWords) {
		Condition condition = new Condition(ReadBooks.class);
		Criteria criteria = condition.createCriteria();
		criteria.andLike("discription", "%"+keyWords+"%");
		return super.findByCondition(condition);
	}

}
