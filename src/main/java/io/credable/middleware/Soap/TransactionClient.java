package io.credable.middleware.Soap;

import io.credable.middleware.transactionclasses.TransactionData;
import io.credable.middleware.transactionclasses.TransactionsRequest;
import io.credable.middleware.transactionclasses.TransactionsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.util.List;


@Service
public class TransactionClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(TransactionClient.class.getName());

    @Autowired
    private WebServiceTemplate webServiceTemplate;

//    @Autowired
//    public TransactionClient(WebServiceTemplate webServiceTemplate) {
//        this.webServiceTemplate = webServiceTemplate;
//    }

    public List<TransactionData> getTransactions(String customerNumber) {
        TransactionsRequest request = new TransactionsRequest();
        log.info("request initiation" + request);
        request.setCustomerNumber(customerNumber);

        TransactionsResponse response = (TransactionsResponse) webServiceTemplate
                .marshalSendAndReceive("https://trxapitest.credable.io/service/transaction-data", request);
        log.info("passed successful");

        return response.getTransactions();

    }


}
