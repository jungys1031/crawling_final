package giga.crawling_web.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

@Entity
@Table(name = "main_crawling")
public class Crawling {
   @Id @GeneratedValue
   private long idx;
   private String word;
   private int count;
   public Crawling() {
   }
   public Crawling(String word, int count) {
      this.word = word;
      this.count = count;
   }
}