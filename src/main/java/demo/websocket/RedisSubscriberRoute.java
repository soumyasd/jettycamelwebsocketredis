package demo.websocket; 

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.JndiRegistry;
import org.apache.camel.spi.Registry;
import org.apache.camel.spring.spi.ApplicationContextRegistry;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.StringRedisSerializer; 

public class RedisSubscriberRoute extends RouteBuilder{


        @Override
	public void configure() throws Exception {
        //TODO change localhost to the IP of the Redis server 
        //change mychannel to name of the redischannel 
        from("spring-redis://localhost:6379?command=SUBSCRIBE&channels=mychannel&serializer=#redisserializer") 
		.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					String res = exchange.getIn().getBody().toString();
					System.out.println("************ " + res); 
					exchange.getOut().setBody(res); 
				}
			})
        .to("websocket://0.0.0.0:9292/tweetsfromstorm?sendToAll=true");
	}

}
