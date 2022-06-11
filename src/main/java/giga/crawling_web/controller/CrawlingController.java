package giga.crawling_web.controller;

import java.util.Optional;

import giga.crawling_web.model.Crawling;
import giga.crawling_web.repository.CrawlingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/crawling")
public class CrawlingController {
    private CrawlingRepository crawlingRep;

    @Autowired
    public CrawlingController(CrawlingRepository crawlingRep) {
        this.crawlingRep = crawlingRep;
    }

    //POST로 유저 추가
    @PostMapping
    public Crawling put(@RequestParam String word, @RequestParam int count) {
        return crawlingRep.save(new Crawling(word, count));
    }

    //테이블 리스트 가져오기
    @GetMapping
    public Iterable<Crawling> list(){
        return crawlingRep.findAll();
    }

    //id로 테이블 값 가져오기
    @GetMapping(value = "/{idx}")
    public Optional<Crawling> findOne(@PathVariable long idx) {
        return crawlingRep.findById(idx);
    }

    //id로 테이블 값 수정
    @PutMapping(value = "/{idx}")
    public Crawling update(@PathVariable long idx, @RequestParam String word, @RequestParam int count) {
        Optional<Crawling> crawling = crawlingRep.findById(idx);
        crawling.get().setWord(word);
        crawling.get().setCount(count);
        return crawlingRep.save(crawling.get());
    }

    //id로 테이블 값 삭제
    @DeleteMapping
    public void delete(@RequestParam Long idx) {
        crawlingRep.deleteById(idx);
    }
}