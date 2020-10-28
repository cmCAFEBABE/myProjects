package mystudy.project_seckill_server.server;



import entity.ItemKill;

import java.util.List;

/**
 * Created by Administrator on 2019/6/16.
 */
public interface IItemService {

    List<ItemKill> getKillItems() throws Exception;

    ItemKill getKillDetail(Integer id) throws Exception;
}
