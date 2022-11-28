package rabbitMQPipelineTesting;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

import java.lang.Thread;
import java.lang.String;
import java.lang.Integer;
import java.lang.*;

import java.nio.charset.StandardCharsets;

import org.slf4j.*;


public class Stage implements Runnable{ 

    Thread thisStage; 
    String name, previousStage, nextStage;
    Integer delay;  


    Stage(String name, String previousStage, String nextStage, Integer delay){
        this.name = name; 
        this.previousStage = previousStage; 
        this.nextStage = nextStage; 
        this.delay = delay; 

    } 

    @Override
    public void run(){

    }





}