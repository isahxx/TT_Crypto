package com.techtest.cryptodemo.restcontroller;

import com.techtest.cryptodemo.DTO.AggregatedPriceDTO;
import com.techtest.cryptodemo.DTO.ProfileDTO;
import com.techtest.cryptodemo.DTO.TransactionHistoryDTO;
import com.techtest.cryptodemo.service.impl.TradeServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/trade")
public class TradeController {

    private static final Logger log = LoggerFactory.getLogger(TradeController.class);
    private TradeServiceImpl tradeService;

    @Autowired
    public TradeController(TradeServiceImpl tradeService){
        log.info("Creating dependencies..");
        this.tradeService = tradeService;
    }

    @PostMapping("/buy")
    public ResponseEntity<String> buyCrypto(@RequestParam String cryptoType, @RequestParam double amount, @RequestParam Long userId){
        return ResponseEntity.ok(tradeService.buyCrypto(cryptoType,amount,userId));
    }

    @PostMapping("/sell")
    public ResponseEntity<String> sellCrypto(@RequestParam String cryptoType, @RequestParam double amount, @RequestParam Long userId){
        return ResponseEntity.ok(tradeService.sellCrypto(cryptoType,amount,userId));
    }

    @GetMapping("/getbestprice")
    public AggregatedPriceDTO getLatestBestPrice(@RequestParam String cryptoType){
        return tradeService.getLatestAgPrice(cryptoType);
    }

    @GetMapping("/getuserprofile") //wallet and username
    public ProfileDTO getUserProfile(@RequestParam Long userId){
        return tradeService.getProfile(userId);
    }

    @GetMapping("/gettransactionhistory")
    public List<TransactionHistoryDTO> getUserTradingHistory(@RequestParam Long userId){
        return tradeService.getUserTradeHistory(userId);
    }

    //END COMMIT comment
}
