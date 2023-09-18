package com.ambev.techempowers.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// testar endpoint
// http://localhost:8080/process?dividend=10&divisor=1
@RestController
public class IntegerParameterController {


    @GetMapping("/process")
    public String processInteger(@RequestParam("dividend") int dividend, @RequestParam("divisor") int divisor) {
        int result = 0;
        try {
            result = divide(dividend, divisor);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            //System.err.println("IllegalArgumentException: " + e.getMessage());
            throw new IllegalArgumentException("Invalid argument: " + e.getMessage(), e);
        } catch (ArithmeticException e) {
            System.err.println("ArithmeticException: " + e.getMessage());
            throw new ArithmeticException("Not possible calculate");
        } catch (Exception e) {
            System.err.println("Exception occurred: " + e.getMessage());
        }
        return "Result " + result;
    }

    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("Erro na operação.");
        }
        return dividend / divisor;
    }

    public void abrirArquivo(String caminhoArquivo) {
        File arquivo = new File(caminhoArquivo);

        Scanner scanner = null;
        try {
            scanner = new Scanner(arquivo);
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            // Caso o arquivo não seja encontrado, essa exceção será capturada
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        } catch (Exception e) {
            // Caso ocorra qualquer outra exceção, ela será capturada aqui
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } finally {
            // O bloco finally sempre será executado, independentemente de ocorrer uma exceção ou não
            scanner.close();
            System.out.println("Fim do programa");
        }


    }

    static void recursaoInfinita() {
        recursaoInfinita();
    }

    public static void main(String[] args) {
        recursaoInfinita();
    }

}

