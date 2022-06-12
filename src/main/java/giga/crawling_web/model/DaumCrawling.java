package giga.crawling_web.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@Entity
@Table(name = "daum_crawling")
public class DaumCrawling {
   @Id @GeneratedValue
   private long idx;
   private String word;
   private int count;
   public DaumCrawling() {
   }
   public DaumCrawling(String word, int count) {
      this.word = word;
      this.count = count;
   }
}