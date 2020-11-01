package com.coder.main.editor.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "c0d3r_editor_state")
public class CoderEditorStateEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "path")
    private String path;

    @Column(name = "projectId")
    private Integer projectId;

    @Column(name = "language")
    private String language;

    @Column(name = "content")
    private String content;

    @Column(name = "addedTime")
    private LocalDateTime addedTime;

    @Column(name = "updateTime")
    private LocalDateTime updateTime;

}
