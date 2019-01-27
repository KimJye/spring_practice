package net.skhu.summernote.repository;

import net.skhu.summernote.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.summernote.domain.Board;

public interface BoardRepository extends JpaRepository<Board,Integer> {

}
