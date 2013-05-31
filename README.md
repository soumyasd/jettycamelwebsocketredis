Sample demo project to test Apache Camel Websocket component on Jetty. 

Following are the steps to run the application. 

1. IMPORTANT: Update your Twitter credentials in this class src/main/java/demo/websocket/TwitterStreamRoute.java otherwise you will get an authorization exception when you start the server (and the Camel route is deployed) 

2. $mvn clean install 

3. For some reason  $mvn jetty:run  (or any other related command from the
   jetty-maven-plugin give the expections (see below). 
   Therefore I used the Jetty Runner
   (http://wiki.eclipse.org/Jetty/Howto/Using_Jetty_Runner) to deploy the
   generated war file instead. 
    
    $java -jar jetty-runner-7.6.8.v20121106.jar target/jettycamelwebsocket.war 

4. Point your web browser (I used Google Chrome) to
   http://localhost:8080/index.html  

Here is a stackoverflow discussion regarding that is relevant to this piece of
code. 
http://stackoverflow.com/questions/16387729/exception-running-a-simple-websocket-with-camel-component-on-jetty


--- 

Still not able to run because I'm getting the following error: 


java.lang.NullPointerException
	at org.eclipse.jetty.websocket.WebSocketFactory.upgrade(WebSocketFactory.java:236)[jetty-websocket-8.1.9.v20130131.jar:8.1.9.v20130131]
	at org.eclipse.jetty.websocket.WebSocketFactory.acceptWebSocket(WebSocketFactory.java:382)[jetty-websocket-8.1.9.v20130131.jar:8.1.9.v20130131]
	at org.eclipse.jetty.websocket.WebSocketServlet.service(WebSocketServlet.java:104)[jetty-websocket-7.6.8.v20121106.jar:7.6.8.v20121106]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:848)[javax.servlet-3.0.0.v201112011016.jar:]
	at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:598)[jetty-servlet-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:486)[jetty-servlet-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1065)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:413)[jetty-servlet-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:999)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:117)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:111)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.Server.handle(Server.java:350)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.AbstractHttpConnection.handleRequest(AbstractHttpConnection.java:454)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.AbstractHttpConnection.headerComplete(AbstractHttpConnection.java:890)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.AbstractHttpConnection$RequestHandler.headerComplete(AbstractHttpConnection.java:944)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.http.HttpParser.parseNext(HttpParser.java:630)[jetty-http-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.http.HttpParser.parseAvailable(HttpParser.java:230)[jetty-http-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.server.AsyncHttpConnection.handle(AsyncHttpConnection.java:77)[jetty-server-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.io.nio.SelectChannelEndPoint.handle(SelectChannelEndPoint.java:606)[jetty-io-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.io.nio.SelectChannelEndPoint$1.run(SelectChannelEndPoint.java:46)[jetty-io-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:603)[jetty-util-8.1.3.v20120416.jar:8.1.9.v20130131]
	at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:538)[jetty-util-8.1.3.v20120416.jar:8.1.9.v20130131]
	at java.lang.Thread.run(Thread.java:680)[:1.6.0_45]



Made some changes to the pom.xml but still getting the following error: 

java.lang.NullPointerException
	at org.eclipse.jetty.websocket.WebSocketFactory.upgrade(WebSocketFactory.java:236)[jetty-websocket-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.websocket.WebSocketFactory.acceptWebSocket(WebSocketFactory.java:382)[jetty-websocket-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.websocket.WebSocketServlet.service(WebSocketServlet.java:104)[jetty-websocket-7.6.8.v20121106.jar:7.6.8.v20121106]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:820)[javax.servlet-2.5.0.v201103041518.jar:]
	at org.eclipse.jetty.servlet.ServletHolder.handle(ServletHolder.java:652)[jetty-servlet-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.servlet.ServletHandler.doHandle(ServletHandler.java:445)[jetty-servlet-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.handler.ContextHandler.doHandle(ContextHandler.java:1044)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.servlet.ServletHandler.doScope(ServletHandler.java:372)[jetty-servlet-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.handler.ContextHandler.doScope(ContextHandler.java:978)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.handler.ScopedHandler.handle(ScopedHandler.java:135)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.handler.HandlerWrapper.handle(HandlerWrapper.java:116)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.Server.handle(Server.java:367)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.AbstractHttpConnection.handleRequest(AbstractHttpConnection.java:486)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.AbstractHttpConnection.headerComplete(AbstractHttpConnection.java:926)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.AbstractHttpConnection$RequestHandler.headerComplete(AbstractHttpConnection.java:988)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.http.HttpParser.parseNext(HttpParser.java:640)[jetty-http-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.http.HttpParser.parseAvailable(HttpParser.java:235)[jetty-http-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.server.AsyncHttpConnection.handle(AsyncHttpConnection.java:82)[jetty-server-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.io.nio.SelectChannelEndPoint.handle(SelectChannelEndPoint.java:628)[jetty-io-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.io.nio.SelectChannelEndPoint$1.run(SelectChannelEndPoint.java:52)[jetty-io-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.util.thread.QueuedThreadPool.runJob(QueuedThreadPool.java:608)[jetty-util-7.6.9.v20130131.jar:7.6.9.v20130131]
	at org.eclipse.jetty.util.thread.QueuedThreadPool$3.run(QueuedThreadPool.java:543)[jetty-util-7.6.9.v20130131.jar:7.6.9.v20130131]
	at java.lang.Thread.run(Thread.java:662)[:1.6.0_32]


