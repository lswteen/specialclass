package com.slack.push;

import com.slack.push.domains.Point;
import com.slack.push.domains.PointRedisRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushApplicationTests {

	@Autowired
	private PointRedisRepository pointRedisRepository;

	@After
	public void tearDown() throws Exception {
		pointRedisRepository.deleteAll();
	}

	@Test
	public void contextLoads() {
		System.out.println("push test");
	}

	@Test
	public void getRedisRepository() {
		//given
		String id = "sunu";
		LocalDateTime refreshTime = LocalDateTime.of(2018, 7, 31, 0, 0);
		Point point = Point.builder()
				.id(id)
				.amount(1000L)
				.refreshTime(refreshTime)
				.build();

		//when
		pointRedisRepository.save(point);

		//then
		Point savedPoint = pointRedisRepository.findById(id).get();
		assertThat(savedPoint.getAmount()).isEqualTo(1000L);
		assertThat(savedPoint.getRefreshTime()).isEqualTo(refreshTime);

		System.out.println("redis point : "+savedPoint.toString());
	}

	@Test
	public void modifyRedisRepository() {
		//given
		String id = "sunu";
		LocalDateTime refreshTime = LocalDateTime.of(2018, 7, 31, 0, 0);
		pointRedisRepository.save(Point.builder()
				.id(id)
				.amount(1000L)
				.refreshTime(refreshTime)
				.build());

		//when
		Point savedPoint = pointRedisRepository.findById(id).get();
		savedPoint.refresh(2000L, LocalDateTime.of(2019,1,1,0,0));
		pointRedisRepository.save(savedPoint);

		//then
		Point refreshPoint = pointRedisRepository.findById(id).get();
		assertThat(refreshPoint.getAmount()).isEqualTo(2000L);


		System.out.println("redis point : "+refreshPoint.toString());
	}

	@Test
	public void testRedisRepository() {
		//given
		String id = "jojoldu";
		LocalDateTime refreshTime = LocalDateTime.of(2018, 5, 26, 0, 0);
		pointRedisRepository.save(Point.builder()
				.id(id)
				.amount(1000L)
				.refreshTime(refreshTime)
				.build());

		//when
		Point savedPoint = pointRedisRepository.findById(id).get();
		savedPoint.refresh(2000L, LocalDateTime.of(2018,6,1,0,0));
		pointRedisRepository.save(savedPoint);

		//then
		Point refreshPoint = pointRedisRepository.findById(id).get();
		assertThat(refreshPoint.getAmount()).isEqualTo(2000L);

		System.out.println("redis point : "+refreshPoint.toString());
	}
}
