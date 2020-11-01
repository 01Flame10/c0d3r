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
@Table(name = "c0d3r_editor_project")
public class CoderEditorProjectEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "task")
    private String task;

    @Column(name = "startTime")
    private LocalDateTime startTime;

    @Column(name = "updateTime")
    private LocalDateTime updateTime;

}
