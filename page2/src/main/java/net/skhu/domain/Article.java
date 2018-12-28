package net.skhu.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	 int no;
	 Date writeTime;
	 String title;
	 String body;

	 @ManyToOne
	 @JoinColumn(name = "boardId")
	 Board board;

	 @ManyToOne
	 @JoinColumn(name = "userId")
	 User user;

}
