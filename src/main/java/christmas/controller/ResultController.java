package christmas.controller;

import christmas.model.service.ResultService;

public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    public void createResult() {
        resultService.setResult();
    }


}

