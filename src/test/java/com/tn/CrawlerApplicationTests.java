package com.tn;

import com.tn.web.po.Gamble;
import com.tn.web.repository.GambleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrawlerApplicationTests {
	@Mock
	private GambleRepository gambleRepository;
	@Test
	public void contextLoads() {
		gambleRepository.save(new Gamble("Allen",new Date()));
//		gambleRepository.save(new Gamble("Bee",new Date()));
//		gambleRepository.save(new Gamble("Carter",new Date()));
//		Assert.assertEquals(1,gambleRepository.findByCreator("Allen").size());
		Assert.assertNotNull(gambleRepository.findByCreator("Allen"));
	}

}
