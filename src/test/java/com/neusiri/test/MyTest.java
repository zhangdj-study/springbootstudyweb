package com.neusiri.test;

import com.neusiri.HelloWorldApplication;
import com.neusiri.mapper.UserMapper;
import com.neusiri.model.UserDO;
import com.neusiri.repository.UserRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;
import org.springframework.context.ApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangdj
 * @date 2020-06-30 15:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWorldApplication.class) //手动指定HelloWorldApplication这个类（也可以和测试类放在同一包名下）
public class MyTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "myRedisTemplate")
    private RedisTemplate myRedisTemplate;

    @Autowired
    private ApplicationContext applicationContext;

    @Resource(name = "myCacheManager")
    private RedisCacheManager myCacheManager;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private AmqpAdmin amqpAdmin;

    @Autowired
    private JestClient jestClient;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    @Test
    public void sendMail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("通知开会");
        message.setText("14:00开会");
        message.setTo("zhangdj_sr@neusiri.com");
        message.setFrom("1240706960@qq.com");
        javaMailSender.send(message);
    }

    @Test
    public void sendComplexMail() throws Exception{
        MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage,true);
        helper.setSubject("通知开会");
        helper.setText("<b>14:00开会</b>",true);
        helper.setTo("zhangdj_sr@neusiri.com");
        helper.setFrom("1240706960@qq.com");
        // 上传附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\Administrator\\Pictures\\下载.jpg"));
        helper.addAttachment("2.jpg",new File("C:\\Users\\Administrator\\Pictures\\下载.jpg"));
        javaMailSender.send(mimeMailMessage);
    }

    @Test
    public void elasticsearchTemplate(){
//        UserDO userDO = new UserDO(3L,"李四","北京");
//        IndexQuery indexQuery = new IndexQuery();
//        indexQuery.setId("3");
//        indexQuery.setObject(userDO);
//        indexQuery.setIndexName("index_test");
//        indexQuery.setType("user");
//        String index = elasticsearchTemplate.index(indexQuery);
//        System.out.println(index);
    }

    @Test
    public void userRepository(){
//        UserDO userDO = new UserDO(1L,"张三","上海");
//        userRepository.index(userDO);
//        Page<UserDO> userDOS = userRepository.searchSimilar();
        List<UserDO> list = userRepository.findByNameLike("三");
        System.out.println(list);
    }

    @Test
    public void applicationContext(){
        RedisTemplate bean = applicationContext.getBean(StringRedisTemplate.class);
        System.out.println(bean);
    }

    @Test
    public void dataSourceTest() throws Exception{
        System.out.println(dataSource.getClass());
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void jdbcTemplate(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from t_user");
        System.out.println(maps);
    }

    @Test
    public void mybatisTest(){
        System.out.println(userMapper);
    }

    @Test
    public void redisTest(){
//        stringRedisTemplate.opsForValue().append("msg","success");
//        String msg = stringRedisTemplate.opsForValue().get("msg");
//        System.out.println(msg);
        UserDO userDO = userMapper.queryById(2L);
//        redisTemplate.opsForValue().set("user",userDO);
//        myRedisTemplate.opsForValue().set("user01",userDO);
        Cache cache = myCacheManager.getCache("user");
        cache.put("111",userDO);
    }

    @Test
    public void rabbitSendTest(){
        Map map = new HashMap();
        map.put("data", Arrays.asList("qqq",123));
        map.put("msg","mq message");
        // 对象默认被序列化以后发送出去
//        rabbitTemplate.convertAndSend("exchange.direct","neusiri",map);
        // 广播
        rabbitTemplate.convertAndSend("exchange.fanout","",map);
    }

    @Test
    public void receiveTest(){
        //接收数据
        Object o = rabbitTemplate.receiveAndConvert("neusiri");
        System.out.println(o.getClass());
        System.out.println(o);
    }

    @Test
    public void amqpAdmin(){
        //创建交换器
//        amqpAdmin.declareExchange(new DirectExchange("amqp.admin.exchange"));
//        amqpAdmin.declareQueue(new Queue("amqp.admin.queue"));
//        amqpAdmin.declareBinding(new Binding("amqp.admin.queue",
//                Binding.DestinationType.QUEUE,"amqp.admin.exchange","routingKey",null));
        amqpAdmin.deleteExchange("amqp.admin.exchange");
    }

    @Test
    public void jest(){
        UserDO userDO = new UserDO();
        userDO.setId(1L);
        userDO.setName("张三");
        userDO.setUserAddress("北京");
        // 构建索引
        Index index = new Index.Builder(userDO).index("neusiri").type("user").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jestSearch(){
        // 查询表达式
        String json = "{\n" +
                "    \"query\":{\n" +
                "        \"match\":{\n" +
                "            \"name\":\"张三\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //指定查询的索引和类型
        Search search = new Search.Builder(json).addIndex("neusiri").addType("user").build();

        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
