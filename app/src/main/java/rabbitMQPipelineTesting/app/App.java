/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package rabbitMQPipelineTesting.app;

import java.util.Random;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import rabbitMQPipelineTesting.Sender;
import rabbitMQPipelineTesting.Receiver;

import org.slf4j.*;

public class App {
    public static void main(String[] args) {

        // GsonBuilder builder = new GsonBuilder();
        // createJSONFIle("data");
        Sender testSender = new Sender();
        Receiver testReceiver = new Receiver();
        testSender.start();
        testReceiver.start();

    }

    public static void createJSONFIle(String jsonData) {
        try {
            File f = new File("sample.json");
            FileWriter writer = new FileWriter(f);
            writer.write(jsonData);
            writer.close();

            if (f.createNewFile()) {
                System.out.println("File create " + f.getName());
            }
        } catch (IOException e) {
            System.out.print("An error occured.");
            e.printStackTrace();
        }
    }
}
