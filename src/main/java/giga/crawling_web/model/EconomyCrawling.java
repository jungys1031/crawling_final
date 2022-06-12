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
@Table(name = "economy_crawling")
public class EconomyCrawling {
   @Id @GeneratedValue
   private long idx;
   private String word;
   private int count;
   public EconomyCrawling() {
   }
   public EconomyCrawling(String word, int count) {
      this.word = word;
      this.count = count;
   }
}