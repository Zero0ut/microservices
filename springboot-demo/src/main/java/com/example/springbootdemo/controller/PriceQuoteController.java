package com.example.springbootdemo.controller;

import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;

import com.example.springbootdemo.model.Quote;
import com.example.springbootdemo.util.DateTimeHelper;

@RestController
public class PriceQuoteController {

    Logger logger = LoggerFactory.getLogger(PriceQuoteController.class);

    @GetMapping(value = {"/price/{quote}", "/price/{quote}/{date}"})
    @ApiOperation(value = "Find Price Quote by Stock Code",
            notes = "Provide an stock code to lookup the bid and ask price of a stock",
            response = Quote.class)
    private Quote getPriceQuote(@PathVariable Map<String, String> pathVarsMap) {
        Stock stock = null;
        String quote = pathVarsMap.get("quote");
        String dateInString = pathVarsMap.get("date");
        try {
            InetAddress ip = InetAddress.getLocalHost();
            logger.info("Host: " + ip + " requesting for Price Quote: " + quote.toUpperCase());
            if (dateInString != null) {
                LocalDate asOfDate = LocalDate.parse(dateInString, DateTimeFormatter.BASIC_ISO_DATE);
                LocalDate nextDate = asOfDate.plusDays(1);
                logger.info("Retrieving a historical rate as of " + asOfDate);
                HistoricalQuote histQuote = YahooFinance.get(quote, DateTimeHelper.convert(asOfDate), DateTimeHelper.convert(nextDate)).getHistory().get(0);
                return new Quote(histQuote.getSymbol(), histQuote.getClose(), histQuote.getClose());
//            } else if (false) {
//                stock = YahooFinance.get(null);
            } else {
                stock = YahooFinance.get(quote);
            }
        } catch (UnknownHostException ex) {
            logger.error("Unable to detected host ip");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Quote(quote, stock.getQuote().getBid(), stock.getQuote().getAsk());
    }
}
