package cn.service.impl;

import cn.dao.ProvinceDao;
import cn.dao.impl.DaoProvinceImpl;
import cn.domain.Province;
import cn.itcast.dao.impl.ProvinceDaoImpl;
import cn.jedis.util.JedisPoolUtils;
import cn.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {
    private ProvinceDao dao=new DaoProvinceImpl();
    @Override
    public String findAllJson() {
        Jedis jedis= JedisPoolUtils.getJedis();
        String province_json=jedis.get("province");

        if (province_json==null||province_json.length()==0){
            System.out.println("redis中没数据,查询数据库///");
            List<Province> ps=dao.findAll();
            ObjectMapper mapper=new ObjectMapper();
            try {
                mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();

        }else {
            System.out.println("redis中没有数据查询缓存...");
        }


        return province_json;
    }
}
