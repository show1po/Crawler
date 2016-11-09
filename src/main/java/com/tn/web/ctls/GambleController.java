package com.tn.web.ctls;

import com.tn.CrawlerApplication;
import com.tn.web.po.Gamble;
import com.tn.web.repository.GambleRepository;
import com.tn.web.requests.GambleReq;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;

/**
 * Created by Show on 2016/10/21.
 */
@RestController
public class GambleController {
    private static final Logger log = LoggerFactory.getLogger(GambleController.class);
    @Autowired
    private GambleRepository gambleRepository;

    @RequestMapping(path="/AddGamble", method = RequestMethod.PUT , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Gamble addGamble(@RequestBody GambleReq gambleReq) {
        log.info("addGamble:");
        Gamble gamble=new Gamble(gambleReq.getCreator(),gambleReq.getDate());
        return gambleRepository.save(gamble);
    }

    @RequestMapping("/DelGamble")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void delGamble(@RequestParam(value="id") long id) {
        System.out.println(id);
        gambleRepository.delete(id);
    }

    @RequestMapping("/GetGamble")
    @ResponseStatus(HttpStatus.OK)
    public Gamble getGamble(@RequestParam(value="name", defaultValue="tommy") String name) {
        String creator=gambleRepository.findByCreator(name).get(0).getCreator();
        System.out.println(creator);
        return gambleRepository.findByCreator(name).get(0);
    }

    @RequestMapping("/DelAllGamble")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void delGamble() {
        gambleRepository.deleteAll();
    }

}
