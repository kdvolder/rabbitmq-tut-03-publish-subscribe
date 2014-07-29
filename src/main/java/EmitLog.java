import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class EmitLog {

    private static final String EXCHANGE_NAME = "logs";

    public static void main(String[] argv)
                  throws java.io.IOException {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

	    System.out.println("Type message to send to logs. Empty message to exit.");
	    try {
		    while (true) {
		    	String message = getMessage();
		    	if (message==null || "".equals(message)) {
		    		break;
		    	}
			    channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
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
    
    //...
}
