package com.example.soap.v1000;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.uhc.ubh.arithmatic.calculation.DivisionResponse;
import com.uhc.ubh.arithmatic.calculation.MultiplyResponse;
import com.uhc.ubh.arithmatic.calculation.SubResponse;
import com.uhc.ubh.arithmatic.calculation.SumResponse;

/**
 * <B>Type name:</B>SpringBootSoapServiceController.java</BR>
 * <B>Description:</B> Endpoint of soap adapter implementation used to consume
 * soap request. <B>References:</B> <I> response </I>
 * 
 * @author mlahariya
 * @version 1.0, Oct 2016
 */

@Component
@Endpoint("SpringBootSoapServiceController")
public class SpringBootSoapServiceController {

    private static final String NAMESPACE_URI = "http://arithmatic.ubh.uhc.com/calculation/";

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootSoapServiceController.class);

    @PayloadRoot(namespace = "http://arithmatic.ubh.uhc.com/calculation/", localPart = "sum")
    @ResponsePayload
    public com.uhc.ubh.arithmatic.calculation.SumResponse summationUses(
            @RequestPayload com.uhc.ubh.arithmatic.calculation.Sum request, MessageContext messageContext) {

        LOG.info("Received Request for summationUses" + request);

        SumResponse response = new SumResponse();

        int value = request.getIn0() + request.getIn1();

        response.setOut(value);

        LOG.info("Returning Response for summation request : " + response.getOut());

        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "sub")
    @ResponsePayload
    public com.uhc.ubh.arithmatic.calculation.SubResponse subtractionUses(
            @RequestPayload com.uhc.ubh.arithmatic.calculation.Sub request, MessageContext messageContext) {

        LOG.info("Received Request for subtractionUses" + request);

        SubResponse response = new SubResponse();

        int value = request.getIn0() - request.getIn1();

        response.setOut(value);

        LOG.info("Returning Response for subtraction request : " + response.getOut());

        return response;
    }

    @PayloadRoot(localPart = "multiply", namespace = NAMESPACE_URI)
    @ResponsePayload
    public com.uhc.ubh.arithmatic.calculation.MultiplyResponse multiplicationUses(
            @RequestPayload com.uhc.ubh.arithmatic.calculation.Multiply request, MessageContext messageContext) {

        LOG.info("Received Request for multiplicationUses" + request);

        MultiplyResponse response = new MultiplyResponse();

        int value = request.getIn0() * request.getIn1();

        response.setOut(value);

        LOG.info("Returning Response for multiplication request : " + response.getOut());

        return response;
    }

    @PayloadRoot(localPart = "division", namespace = NAMESPACE_URI)
    @ResponsePayload
    public com.uhc.ubh.arithmatic.calculation.DivisionResponse divisionUses(
            @RequestPayload com.uhc.ubh.arithmatic.calculation.Division request, MessageContext messageContext) {

        LOG.info("Received Request for divisionUses" + request);

        DivisionResponse response = new DivisionResponse();

        int value = request.getIn0() / request.getIn1();

        response.setOut(value);

        LOG.info("Returning Response for division request : " + response.getOut());

        return response;
    }

}
