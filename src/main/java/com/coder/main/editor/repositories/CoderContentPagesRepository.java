package com.coder.main.editor.repositories;

import com.coder.main.editor.entity.CoderEditorStateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoderContentPagesRepository extends JpaRepository<CoderEditorStateEntity, Integer> {

    @Override
    <S extends CoderEditorStateEntity> S save(S s);

    @Override
    Optional<CoderEditorStateEntity> findById(Integer integer);

    @Query("from CoderEditorStateEntity e where e.projectId = :id")
    List<CoderEditorStateEntity> findAllByProjectId(@Param("id") Integer Id);

}
