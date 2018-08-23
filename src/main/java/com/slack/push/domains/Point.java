package com.slack.push.domains;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * nosql 및 memory 형태 rdb가 아닌 파일 휘발성 형태는 직렬화를 한다.
 */
@Getter
@RedisHash("point")
public class Point implements Serializable{

    @Id
    private String id;
    private Long amount;
    private LocalDateTime refreshTime;

    @Builder
    public Point(String id, Long amount, LocalDateTime refreshTime) {
        this.id = id;
        this.amount = amount;
        this.refreshTime = refreshTime;
    }

    public void refresh(long amount, LocalDateTime refreshTime){
        if(refreshTime.isAfter(this.refreshTime)){ // 저장된 데이터보다 최신 데이터일 경우
            this.amount = amount;
            this.refreshTime = refreshTime;
        }
    }

    @Override
    public String toString() {
        return "Point{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", refreshTime=" + refreshTime +
                '}';
    }
}
