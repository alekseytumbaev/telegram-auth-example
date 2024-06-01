package com.example.telegramauthexample;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/telegram")
    public ResponseEntity<Resource> auth() {
        Resource resource = new ClassPathResource("static/telegramAuth.html");
        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=telegramAuth.html");
        return ResponseEntity.ok().headers(headers).body(resource);
    }

    @PostMapping("/telegram/token")
    public String telegramSignIn(@RequestParam String username) {
        return "pretend-that-it-is-your-token-" + username;
    }
}
