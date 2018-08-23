package com.slack.push.controller.slack;

import com.slack.push.integration.SlackNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushController {

    @Autowired
    private SlackNotifier slackNotifier;

    @GetMapping("/push/slack/execute")
    public String execute(){
        return "Push Slack execute";
    }

    @PostMapping("/push/slack/send")
    public ResponseEntity<Boolean> send(@RequestBody SlackNotifier.SlackMessageAttachement message){
        return ResponseEntity.ok(
                slackNotifier.notify(SlackNotifier.SlackTarget.CH_INCOMING,message)
        );
    }

}
