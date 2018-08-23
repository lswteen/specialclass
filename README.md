# slackpush
```
    JOIN-SERVER NOTIFICATION 
    API 
    URI : http://localhost:9090/push/slack/send
    METHOD : POST
    REQUEST PAYLOAD : {"text": "test slack push"}
    
    RESPONSE : true, false
    
    변경점은 SlackNotifier.java 
    29 line : CH_INCOMING 변경
    https://hooks.slack.com/services/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
    
    참고 CI-SERVER LINK
    내용 : docker(ci-server)jenkins + github source 연동 + vm domain(ngrok) + slack message push
    바로가기 : http://jojoldu.tistory.com/139
    
    Redis 설정
    http://jojoldu.tistory.com/297?category=635883
    
    CI-SERVER 실행순서 LOCAL
    1. docker jenkins image 실행
    2. jenkins server URI localhost:32769 확인
    3. $/usr/local/bin/ngrok http 32769 콘솔 실행
    4. 출력된 ngrok 도메인 확인
    5. github 연결시 github -> Setting -> integrations & services 
    6. installed GitHub Apps jenkins(GitHub plugin) edit 수정  
```