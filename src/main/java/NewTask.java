import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

public class NewTask {
	
	private static final String QUEUE_NAME = "hello";

	public static void main(String[] args) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("localhost");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		boolean durable = true;
	    channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
	    
	    System.out.println("Type message to send to work queue. Empty message to exit.");
	    try {
		    while (true) {
		    	String message = getMessage();
		    	if (message==null || "".equals(message)) {
		    		break;
		    	}
			    channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
			    System.out.println(" [x] Sent '" + message + "'");
		    }
	    } finally {
		    channel.close();
		    connection.close();
	    }
	}

	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	
	private static String getMessage() throws IOException {
		return input.readLine();
	}

}
