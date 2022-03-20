package application.blockchain.jpo.dao;

import application.blockchain.jpo.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockDAO extends JpaRepository<Block, Long> {

}
