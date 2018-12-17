//package com.mylearn.springbootlearn.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.lang.reflect.Method;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.TimeUnit;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.guava.GuavaCacheManager;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//
//
//@Configuration
//@EnableCaching
//@Slf4j
//public class RedisConfig extends CachingConfigurerSupport {
//
////    @Value("${redis.default.expire}")
//    private long defaultExpire=100000L;
//
//    @Bean
//    @Override
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object target, Method method, Object... params) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(target.getClass().getName());
//                sb.append(method.getName());
//                for (Object obj : params) {
//                    sb.append(obj.toString());
//                }
//                return sb.toString();
//            }
//        };
//    }
//
//    @SuppressWarnings("rawtypes")
//    @Bean
//    @Primary
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        try {
////            if(null == redisTemplate) {
////                log.warn("redis CacheManager初始化失败，可能是服务未配置redis服务，如果需要redis，请检查配置！！！！！！");
////                return new RedisCacheManager(new RedisTemplate());
////            }
//            RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//            //设置缓存默认缺省过期时间
//            rcm.setDefaultExpiration(defaultExpire);//秒
//
//            //为每个缓存容器单独配置过期时间
//            Map<String, Long> expiresMap = new ConcurrentHashMap<>();
////            expiresMap.put(IConstsRedisOpt.CUST_DJFAMILY_CACHED_ITEM, 30L * 60);//单位秒expires time in seconds
////
////            int prefix_length = IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_PREFIX.length();
////            expiresMap.put(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_SECONDS_60, Long.valueOf(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_SECONDS_60.substring(prefix_length)));
////            expiresMap.put(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_5, Long.valueOf(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_5.substring(prefix_length)));
////            expiresMap.put(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_10, Long.valueOf(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_10.substring(prefix_length)));
////            expiresMap.put(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_15, Long.valueOf(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_15.substring(prefix_length)));
////            expiresMap.put(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_30, Long.valueOf(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_30.substring(prefix_length)));
////            expiresMap.put(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_60, Long.valueOf(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_MINUTE_60.substring(prefix_length)));
////            expiresMap.put(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_HOUR_10, Long.valueOf(IConstsRedisExpiresTime.CACHEABLE_EXPIRESTIME_HOUR_10.substring(prefix_length)));
////            rcm.setExpires(expiresMap);
//            return rcm;
//        } catch (Exception e) {
//            log.warn("redis CacheManager初始化失败，可能是服务未配置redis服务，如果需要redis，请检查配置！！！！！！", e);
//        }
//        return null;
//    }
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
//        try {
////            factory.getConnection();
//            StringRedisTemplate template = new StringRedisTemplate(factory);
//            Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//            ObjectMapper om = new ObjectMapper();
//            om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//            om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//            jackson2JsonRedisSerializer.setObjectMapper(om);
//            template.setValueSerializer(jackson2JsonRedisSerializer);
//            template.afterPropertiesSet();
//            return template;
//        } catch (Exception e) {
//            log.warn("redis连接失败，可能是服务未配置redis服务，如果需要redis，请检查配置！！！！！！", e);
//        }
//        return null;
//    }
//
//    @Bean
//    public CacheManager guavaCacheManager() {
//        GuavaCacheManager cacheManager = new GuavaCacheManager();
////        cacheManager.setCacheBuilder(CacheBuilder.newBuilder().maximumSize(1000).expireAfterWrite(5, TimeUnit.SECONDS));
//        return cacheManager;
//    }
//
//}