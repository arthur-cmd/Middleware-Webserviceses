package io.credable.middleware.Controller;

import io.credable.middleware.Soap.TransactionClient;
import io.credable.middleware.Soap.Webconfiguration;
import io.credable.middleware.transactionclasses.*;


//import io.credable.middleware.Soap.TransactionClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactionsApi")
public class TransactionController {
    private static final Logger log = LoggerFactory.getLogger(TransactionController.class.getName());

    private final TransactionClient transactionClient;
   // private TransactionsResponse response;

    @Autowired
    public TransactionController(TransactionClient transactionClient){
        this.transactionClient=transactionClient;

    }

    //mapping from the transaction soap
    @GetMapping("/{customerNumber}")
    @ResponseBody
    public ResponseEntity<Object> getTransactions(@PathVariable String customerNumber){

        List<TransactionData> transactionData = transactionClient.getTransactions(customerNumber);
        log.info("these are data for" + transactionData );
        return  new ResponseEntity<>(transactionData,HttpStatus.OK);
    }


//    @GetMapping  ("{customerNumber}")
//    public  ResponseEntity<List<TransactionData>> invokeTransactionClientToGetCustomerNumber(@PathVariable String customerNumber){
//
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Webconfiguration.class);
//        client = context.getBean(TransactionClient.class);
//        List<TransactionData> transactionData = client.getTransactions(customerNumber);
//        return new ResponseEntity<>(transactionData,HttpStatus.OK);
//
//    }






}
