package com.coder.main.editor.repositories;

import com.coder.main.editor.entity.CoderEditorProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoderEditorProjectRepository extends JpaRepository<CoderEditorProjectEntity, Integer> {
}
