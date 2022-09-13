package com.avin.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HacatonController {

    @GetMapping("/task")
    public Result getResult(
            @RequestParam String a1,
            @RequestParam String a2,
            @RequestParam String a3,
            @RequestParam String a4,
            @RequestParam String a5,
            @RequestParam String a6,
            @RequestParam String a7,
            @RequestParam String a8
    ) throws IOException {

        ProcessBuilder processBuilder = new ProcessBuilder("python3", "task.py", a1, a2, a3, a4, a5, a6, a7, a8);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();
        InputStream inputStream = process.getInputStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));

        List<String> results = new ArrayList<>();
        String line;
        while ((line = r.readLine()) != null) {
            System.out.println(line);
            results.add(line);
        }
        Result result = new Result();
        result.setResult(results.get(results.size() - 1));

        return result;
    }

}
