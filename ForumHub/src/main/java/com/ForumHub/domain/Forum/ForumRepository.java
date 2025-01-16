package com.ForumHub.domain.Forum;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumRepository extends JpaRepository<Forum, Long> {
    Page<Forum> findAllByAtivoTrue(Pageable paginacao);
}
