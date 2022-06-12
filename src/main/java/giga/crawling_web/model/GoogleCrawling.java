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
@Table(name = "google_crawling")
public class GoogleCrawling {
   @Id @GeneratedValue
   private long idx;
   private String word;
   private int count;
   public GoogleCrawling() {
   }
   public GoogleCrawling(String word, int count) {
      this.word = word;
      this.count = count;
   }
}