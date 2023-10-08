/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.Authentication;

import controller.sendMail.*;
import java.util.Random;

/**
 * ClassName: CodeRandom 
 * Descriptions: random 6 digits send email to reset password
 */
public class CodeRandom {

    public String randomCode() {
        Random random = new Random();
        int randomNumber = random.nextInt(900000) + 100000; // Generates a random number between 100000 and 999999
        return randomNumber + "";
    }
}
