package com.coder.main.editor.controllers;

import com.coder.main.editor.dto.CoderEditorProjectDto;
import com.coder.main.editor.dto.CoderEditorRunResult;
import com.coder.main.editor.dto.CoderEntityStateRequest;
import com.coder.main.editor.entity.CoderEditorStateEntity;
import com.coder.main.editor.repositories.CoderContentPagesRepository;
import com.coder.main.editor.repositories.CoderEditorProjectRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/api/editor/state")
@AllArgsConstructor
public class CoderEditorStateRestController {

    private final CoderContentPagesRepository contentPagesRepository;
    private final CoderEditorProjectRepository editorProjectRepository;

    @PostMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Integer> saveState(@RequestBody CoderEditorStateEntity state) {
        log.info("Got {}", state);

        state.setUpdateTime(LocalDateTime.now());

        if (state.getId() == null) {
            if (state.getAddedTime() == null)
                state.setAddedTime(LocalDateTime.now());
            state = contentPagesRepository.save(state);
        } else {
            CoderEditorStateEntity savedState = contentPagesRepository.findById(state.getId()).orElse(state);
            savedState.setContent(state.getContent());
            savedState.setUpdateTime(state.getUpdateTime());
            contentPagesRepository.saveAndFlush(savedState);
        }

        log.info("Saved {}", state);

        return new ResponseEntity<>(state.getId(), HttpStatus.OK);
    }

    @PostMapping(value = "/get", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoderEditorProjectDto> getState(@RequestBody CoderEntityStateRequest request) {
        log.info("Getting id {}", request);

        CoderEditorProjectDto dto = new CoderEditorProjectDto();
        dto.setProject(editorProjectRepository.getOne(request.getId()));
        dto.setStateList(contentPagesRepository.findAllByProjectId(request.getId()));

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping(value = "/run", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CoderEditorRunResult> getState(@RequestBody CoderEditorProjectDto request) {
        log.info("Getting id {}", request);

        for (CoderEditorStateEntity entity : request.getStateList()) {
            new File(String.valueOf("src/main/resources/static/files-to-run/" + request.getProject().getId())).mkdir();
            File file = new File("src/main/resources/static/files-to-run/" + request.getProject().getId() + "/" + entity.getPath());
            try {
                file.createNewFile();
                FileWriter bufferedWriter = new FileWriter(file.getAbsoluteFile());
                bufferedWriter.append(entity.getContent().replace("<br>", "\n").replace("&nbsp;", " "));
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        return new ResponseEntity<>(new CoderEditorRunResult("mock"), HttpStatus.OK);


        String fileUrl = "http://localhost:8080/files-to-run/1/asd.java";
        String url = "http://localhost:8000/process?data=1%7C2%7CHello,%20World!%7C" + fileUrl + "%7Chello1" + ".java";
        try {

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            connection.setUseCaches(false);
            connection.setDoOutput(true);


            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes("");
            wr.close();

            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = rd.readLine();
            rd.close();

//            for (CoderEditorStateEntity entity : request.getStateList()) {
//                File file = new File("src/main/resources/static/files-to-run/" + request.getProject().getId() + "/" + entity.getPath());
//                file.delete();
//            }

            return new ResponseEntity<>(new CoderEditorRunResult(line), HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(new CoderEditorRunResult("ERROR"), HttpStatus.BAD_REQUEST);
    }
}
