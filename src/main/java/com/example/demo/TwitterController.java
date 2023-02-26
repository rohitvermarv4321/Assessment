package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.TwitterProfile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TwitterController {

    @Autowired
    private Twitter twitter;

    @GetMapping("/search/{username}")
    public ResponseEntity<List<TwitterProfile>> searchTweetUser(@PathVariable String username) {
        List<TwitterProfile> users = twitter.userOperations().searchForUsers(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/tweets/{username}")
    public ResponseEntity<List<Tweet>> getTweetsOfSelectedUser(@PathVariable String username) {
        List<Tweet> tweets = twitter.timelineOperations().getUserTimeline(username);
        return new ResponseEntity<>(tweets, HttpStatus.OK);
    }
}

