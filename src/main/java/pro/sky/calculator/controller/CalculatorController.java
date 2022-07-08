package pro.sky.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.calculator.CalculatorService;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private static CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping(path = "/plus")
    public int plus(@RequestParam("num1") int firstVar, @RequestParam("num2") int secondVar) {
        return calculatorService.plus(firstVar, secondVar);
    }

    @GetMapping(path = "/minus")
    public int minus(@RequestParam("num1") int firstVar, @RequestParam("num2") int secondVar) {
        return calculatorService.minus(firstVar, secondVar);
    }

    @GetMapping(path = "/multiply")
    public int multiply(@RequestParam("num1") int firstVar, @RequestParam("num2") int secondVar) {
        return calculatorService.multiply(firstVar, secondVar);
    }

    @GetMapping(path = "/divide")
    public int divide(@RequestParam("num1") int firstVar, @RequestParam("num2") int secondVar) {
        return calculatorService.divide(firstVar, secondVar);
    }

    @GetMapping(path = "")
    public String answerHello() {
        return calculatorService.greetings();
    }
}
