package demo.websocket; 

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.twitter.TwitterComponent;
import org.apache.camel.component.websocket.WebsocketComponent;

public class TwitterStreamRoute extends RouteBuilder{

	public static final String EMPTY = "";

        //put your twitter keys here to test 
        public static final String CONSUMER_KEY = EMPTY;  
	public static final String CONSUMER_SECRET = EMPTY; 
	public static final String ACCESS_TOKEN = EMPTY; 
	public static final String ACCESS_TOKEN_SECRET = EMPTY;  


        @Override
	public void configure() throws Exception {

	
	if( isEmpty(CONSUMER_KEY) || 
	 isEmpty(CONSUMER_SECRET) || 
	 isEmpty(ACCESS_TOKEN) || 
	 isEmpty(ACCESS_TOKEN_SECRET) ) 
		throw new NullPointerException("Twitter keys are not set ... please set them first" ); 


/*        WebsocketComponent wc = getContext().getComponent("websocket", WebsocketComponent.class);
        wc.setPort(9292);
        wc.setStaticResources("classpath:.");*/

        TwitterComponent tc = getContext().getComponent("twitter", TwitterComponent.class);
        tc.setAccessToken(ACCESS_TOKEN);
        tc.setAccessTokenSecret(ACCESS_TOKEN_SECRET);
        tc.setConsumerKey(CONSUMER_KEY);
        tc.setConsumerSecret(CONSUMER_SECRET);
        
        fromF("twitter://streaming/filter?type=polling&delay=%s&keywords=%s", "5", "pittsburgh")
		.process(new Processor() {
				@Override
				public void process(Exchange exchange) throws Exception {
					String res = exchange.getIn().getBody().toString();
					exchange.getOut().setBody(res);
				}
			})
        .to("websocket://0.0.0.0:9292/camel-tweet?sendToAll=true");
	}

	private static boolean isEmpty(String s)
	{

		return (s != null && EMPTY.equalsIgnoreCase(s) ) ; 
	}

}
