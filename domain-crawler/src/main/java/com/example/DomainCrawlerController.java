package com.example;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
@RequiredArgsConstructor
public class DomainCrawlerController {

    private final DomainCrawlerService domainCrawlerService;

    @GetMapping("/lookup/{name}")
    public String lookup(@PathVariable("name") final String name) {
        domainCrawlerService.crawl(name);
        return "Domain crawler has scrapped your data";
    }
}
