package rabbitMQPipelineTesting;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.lang.Thread;

import java.nio.charset.StandardCharsets;

import org.slf4j.*;


public class Sender implements Runnable {
    Thread sender;
    private final static String QUEUE_NAME = "hello";

    public static void Sender() {

    }

    @Override
    public void run() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
                Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        } catch (Exception e) {
            System.out.println("Sender exception hit");
            System.out.println(e.toString());

        }
        System.out.println("Sender finished running.");
    }

    public void start() {
        System.out.println("Thread started"); 
        if(sender == null){ 
            sender = new Thread(this, "Sender"); 
            sender.start(); 
        }
    }



}
