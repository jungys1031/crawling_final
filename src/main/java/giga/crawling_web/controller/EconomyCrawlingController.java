package giga.crawling_web.controller;

import giga.crawling_web.model.EconomyCrawling;
import giga.crawling_web.repository.EconomyCrawlingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/economy")
public class EconomyCrawlingController {
    private EconomyCrawlingRepository crawlingRep;

    @Autowired
    public EconomyCrawlingController(EconomyCrawlingRepository crawlingRep) {
        this.crawlingRep = crawlingRep;
    }

    //POST로 유저 추가
    @PostMapping
    public EconomyCrawling put(@RequestParam String word, @RequestParam int count) {
        return crawlingRep.save(new EconomyCrawling(word, count));
    }

    //테이블 리스트 가져오기
    @GetMapping
    public Iterable<EconomyCrawling> list(){
        return crawlingRep.findAll();
    }

    //id로 테이블 값 가져오기
    @GetMapping(value = "/{idx}")
    public Optional<EconomyCrawling> findOne(@PathVariable long idx) {
        return crawlingRep.findById(idx);
    }

    //id로 테이블 값 수정
    @PutMapping(value = "/{idx}")
    public EconomyCrawling update(@PathVariable long idx, @RequestParam String word, @RequestParam int count) {
        Optional<EconomyCrawling> crawling = crawlingRep.findById(idx);
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