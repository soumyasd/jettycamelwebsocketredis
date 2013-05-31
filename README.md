Simple demo that subscribes to a redis channel and puts the output to a
websocket

IMPORTANT: 
=========

You will need to make changes to the Camel route in order to get this to work. 

In src/main/java/demo/websocket/RedisSubscriberRoute.java

In this java line from("spring-redis://localhost:6379?command=SUBSCRIBE&channels=mychannel&serializer=#redisserializer")
       1.  change localhost to the IP of the Redis server 
       2.  change mychannel to name of the redischannel 
         


To complile 
===================

1. $mvn clean install
2. If everything goes fine you should see 
   target/jettycamelwebsocketredis.war file 


To start the server 
===================
1. To start the server use run.sh script (it just invokes the war file with the
   jettyrun jar included with the project) 


To see the output on the webpage 
================================

Try 
http://<ip of the jettyserver>:8080/index.html 

You should see a stream of tweets that are being pushed into the Redis channel
on the browser 


