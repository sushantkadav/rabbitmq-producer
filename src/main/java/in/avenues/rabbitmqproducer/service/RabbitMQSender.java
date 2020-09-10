package in.avenues.rabbitmqproducer.service;


import in.avenues.rabbitmqproducer.model.Employee;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSender {
	
	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@Value("${avenues.rabbitmq.exchange}")
	private String exchange;
	
	@Value("${avenues.rabbitmq.routingkey}")
	private String routingkey;
	
	public void send(Employee company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("Send msg = " + company);
	    
	}
}