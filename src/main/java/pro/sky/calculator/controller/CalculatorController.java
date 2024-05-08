package pro.sky.calculator.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.service.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping()
    public String helloCalculator() {
        return "<h1>Добро пожаловать в калькулятор!</h1>";
    }

    @GetMapping(path = "/plus", produces = MediaType.TEXT_HTML_VALUE)
    public String sumNumbers(@RequestParam(required = false) Integer num1,
                             @RequestParam(required = false) Integer num2) {
        String verificatiion = verificatiionParametrs(num1, num2);
        if (verificatiion != null) {
            return verificatiion;
        } else {
            return num1 + " + " + num2 + " = " + calculatorService.plus(num1, num2);
        }
    }

    @GetMapping(path = "/minus", produces = MediaType.TEXT_HTML_VALUE)
    public String differenceNumbers(@RequestParam(required = false) Integer num1,
                                    @RequestParam(required = false) Integer num2) {
        String verificatiion = verificatiionParametrs(num1, num2);
        if (verificatiion != null) {
            return verificatiion;
        } else {
            return num1 + " - " + num2 + " = " + calculatorService.minus(num1, num2);
        }
    }

    @GetMapping(path = "/multiply", produces = MediaType.TEXT_HTML_VALUE)
    public String multiplicationNumbers(@RequestParam(required = false) Integer num1,
                                        @RequestParam(required = false) Integer num2) {
        String verificatiion = verificatiionParametrs(num1, num2);
        if (verificatiion != null) {
            return verificatiion;
        } else {
            return num1 + " * " + num2 + " = " + calculatorService.multiply(num1, num2);
        }
    }

    @GetMapping(path = "/divide", produces = MediaType.TEXT_HTML_VALUE)
    public String divisionNumbers(@RequestParam(required = false) Integer num1,
                                  @RequestParam(required = false) Integer num2) {
        String verificatiion = verificatiionParametrs(num1, num2);
        if (verificatiion != null) {
            return verificatiion;
        } else if (num2 == 0) {
            return "<h1>На ноль делить нельзя!</h1>";
        } else {
            return num1 + " / " + num2 + " = " + calculatorService.divie(num1, num2);
        }
    }

    private String verificatiionParametrs(Integer num1, Integer num2) {
        if (num1 == null && num2 == null) {
            return "<h1>Параметры не переданы!</h1>";
        } else if (num1 == null) {
            return "<h1>Параметр №1 не передан!</h1>";
        } else if (num2 == null) {
            return "<h1>Параметр №2 не передан!</h1>";
        }
        return null;
    }
}
