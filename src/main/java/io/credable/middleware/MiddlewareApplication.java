package io.credable.middleware;

import io.credable.middleware.Soap.TransactionClient;
import io.credable.middleware.Soap.Webconfiguration;
import io.credable.middleware.transactionclasses.TransactionData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

@SpringBootApplication
public class MiddlewareApplication {

    public static void main(String[] args) {
        SpringApplication.run(MiddlewareApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Webconfiguration.class);
//        TransactionClient client = new TransactionClient();
//        client = context.getBean(TransactionClient.class);
//        List<TransactionData> transactionData = client.getTransactions("234774784");
//        System.out.println(transactionData);

    }

}
