package com.coder.main.editor.dto;

import com.coder.main.editor.entity.CoderEditorProjectEntity;
import com.coder.main.editor.entity.CoderEditorStateEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CoderEditorProjectDto implements Serializable {

    CoderEditorProjectEntity project;
    List<CoderEditorStateEntity> stateList;

}
