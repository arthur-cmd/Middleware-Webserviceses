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
@RequestMapping("/api/v1/transactions/")
public class TransactionController {
    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionClient client;
   // private TransactionsResponse response;

    @Autowired
    public TransactionController( TransactionClient client){
        this.client=client;

    }

    //mapping from the transaction soap
    @GetMapping("{customerNumber}")
    @ResponseBody
    public ResponseEntity<List<TransactionData>> getTransactions(@PathVariable String customerNumber){

        List<TransactionData> transactiondata = client.getTransactions(customerNumber);
        log.info("these are data for" + transactiondata );
        return  new ResponseEntity<>(transactiondata,HttpStatus.OK);
    }


//    @GetMapping("{customerNumber}")
//    public List<TransactionData> invokeSoapClientToTransactionList(@PathVariable String customerNumber){
//       // TransactionsResponse response = new TransactionsResponse();
//        TransactionsRequest transactionsRequest= new TransactionsRequest();
//        //CustomerRequest customerRequest = new CustomerRequest();
//        transactionsRequest.setCustomerNumber(transactionsRequest.getCustomerNumber());
//        //customerRequest.setCustomerNumber(customerRequest.getCustomerNumber());
//        // return response.getCustomer();
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Webconfiguration.class);
//        client = context.getBean(TransactionClient.class);
//        List<TransactionData> response = client.getTransactions(customerNumber);
//         return  response.listIterator();
//}



}
