package mystudy.project_seckill_server.server.impl;/**
 * Created by Administrator on 2019/6/16.
 */


import com.alibaba.fastjson.JSON;
import entity.ItemKill;
import mapper.ItemKillMapper;
import mystudy.project_seckill_server.server.IItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:debug (SteadyJack)
 * @Date: 2019/6/16 22:45
 **/
@Service
public class ItemService implements IItemService {

    private static final Logger log= LoggerFactory.getLogger(ItemService.class);

    @Autowired
    private ItemKillMapper itemKillMapper;


    /**
     * 获取待秒杀商品列表
     * @return
     * @throws Exception
     */
    @Override
    public List<ItemKill> getKillItems() throws Exception {
        List<ItemKill> itemKills = itemKillMapper.selectAll();
        return itemKills;
    }

    /**
     * 获取秒杀详情
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public ItemKill getKillDetail(Integer id) throws Exception {
        ItemKill entity=itemKillMapper.selectById(id);
        if (entity==null){
            throw new Exception("获取秒杀详情-待秒杀商品记录不存在");
        }
        return entity;
    }
}



















