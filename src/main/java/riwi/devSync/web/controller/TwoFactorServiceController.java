package riwi.devSync.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import riwi.devSync.domain.service.DAO2faService;
import riwi.devSync.domain.service.SMSService;

import java.util.Random;

@RestController
public class TwoFactorServiceController {
    @Autowired
    private SMSService smsService;
    @Autowired
    private DAO2faService daoService;
    @PutMapping("/two-factor/{userId}/{phoneNumber}")
    public ResponseEntity<Object> send2faCode(@PathVariable Integer userId, @PathVariable String phoneNumber) {
        String code = String.valueOf(new Random().nextInt(9999)+1000);
        smsService.send2faCode(phoneNumber,code);
        daoService.update2faProperties(userId, code);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/verificationCode/{userId}/{code}")
    public ResponseEntity<Object> verificationCode(@PathVariable Integer userId,@PathVariable String code) {
        boolean isValidCode = daoService.checkCode(userId,code);
        if (isValidCode)
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
