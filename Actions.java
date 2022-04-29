import lrapi.lr;
import java.util.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.clients.producer.internals.*;
import org.apache.kafka.clients.*;

public class Actions
{
  
 
    public int init() throws Throwable {
        return 0;
    }

  public int action() throws Throwable {
      String topicName = "test_topic";
      String value = "PTTest1";
      String jsonString = "{'element1':'value1','element2':{'id':0,'name':'testName'}}";
      
      Properties props = new Properties();
      props.put("bootstrap.servers", "192.168.0.106:29092");
      props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");         
      props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

      Producer<String, String> producer = new KafkaProducer <String,String>(props);

      ProducerRecord<String, String> record = new ProducerRecord<String,String>(topicName,jsonString);
      producer.send(record);           
      producer.close();
      return 0;
    }//end of action
	
  public int end() throws Throwable {
        return 0;
    }

  }