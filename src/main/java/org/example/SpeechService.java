package org.example;

public class SpeechService {

    public static void speak(String instruction) {

        if (instruction == null || instruction.isBlank()) {
            System.out.println("No instruction to speak.");
            return;
        }

        try {
            Process process = Runtime.getRuntime().exec(
                    new String[]{
                            "/usr/bin/say",
                            "-v",
                            "Samantha",
                            instruction
                    }
            );

            process.waitFor();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String ocrText =
                "welcome to xyz bank please select a transaction";

        String instruction = DecisionEngine.decide(ocrText);

        System.out.println("OCR Text: " + ocrText);
        System.out.println("Instruction: " + instruction);

        speak(instruction);
    }
}