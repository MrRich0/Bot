package org.example;

import org.example.ParseMono.MONOCurrencyRateService;
import org.example.ParseNBY.NBYCurrencyRateService;
import org.example.ParsePrivat.PrivatCurrencyRateService;

import java.util.Scanner;

public class TestBot {
    public static void main(String[] args) {
        CurrencyRateApiService apiNBY = new NBYCurrencyRateService();
        CurrencyRateApiService apiMONO = new MONOCurrencyRateService();
        CurrencyRateApiService apiPRIVAT = new PrivatCurrencyRateService();


        Scanner scanner = new Scanner(System.in);
        String tmp;
        while (true){
            System.out.println();
            System.out.println("Який банк вас цікавить?");
            System.out.println("1 - НБУ\n" +
                    "2 - МоноБанк\n" +
                    "3 - ПриватБанк\n" +
                    ">");
            switch (scanner.nextLine()) {
                case "1":
                    System.out.println("===НБУ===");
                    System.out.println("Яка валюта вас цікавить?");
                    System.out.println("Вибір:USD/EUR\n" +
                            ">");
                    switch (tmp = scanner.nextLine().toUpperCase()) {
                        case "USD":
                            System.out.println(apiNBY.getRates().get(0));
                            break;
                        case "EUR":
                            System.out.println(apiNBY.getRates().get(1));
                            break;
                        default:
                            System.out.println("На жаль валюти " + tmp +" немає!Спробуйте ще раз.");
                    }
                    break;
                case "2":
                    System.out.println("===МоноБанк===");
                    System.out.println("Яка валюта вас цікавить?");
                    System.out.println("Вибір:USD/EUR\n" +
                            ">");
                    switch (tmp = scanner.nextLine().toUpperCase()) {
                        case "USD":
                            System.out.println(apiMONO.getRates().get(0));
                            break;
                        case "EUR":
                            System.out.println(apiMONO.getRates().get(1));
                            break;
                        default:
                            System.out.println("На жаль валюти " + tmp +" немає!Спробуйте ще раз.");
                    }
                    break;
                case "3":
                    System.out.println("===ПриватБанк===");
                    System.out.println("Яка валюта вас цікавить?");
                    System.out.println("Вибір:USD/EUR\n" +
                            ">");
                    switch (tmp = scanner.nextLine().toUpperCase()) {
                        case "USD":
                            System.out.println(apiPRIVAT.getRates().get(1));
                            break;
                        case "EUR":
                            System.out.println(apiPRIVAT.getRates().get(0));
                            break;
                        default:
                            System.out.println("На жаль валюти " + tmp +" немає!Спробуйте ще раз.");
                    }
                    break;
                default:
                    System.out.println("Некоректні дані!Спробуйте ще раз.");
            }
        }
    }
}
