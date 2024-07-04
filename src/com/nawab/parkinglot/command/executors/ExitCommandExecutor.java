package com.nawab.parkinglot.command.executors;

import com.nawab.parkinglot.model.Command;
import com.nawab.parkinglot.services.ParkingLotService;

import java.io.IOException;
import java.lang.management.ManagementFactory;

public class ExitCommandExecutor extends CommandExecutor{
    public static String COMMAND_NAME = "exit";
    public ExitCommandExecutor(ParkingLotService parkingLotService) {
        super(parkingLotService);
    }

    @Override
    public boolean validate(Command command) {
        return command.getCommandName().equals(COMMAND_NAME) && command.getParams().isEmpty();
    }

    @Override
    public void executeCommand(Command command) {
        try {
            // Get the current process ID
            String pid = getCurrentPID();
            System.out.println("Current Process ID: " + pid);

            // Send SIGINT (equivalent to Ctrl+C) to the current process
            sendSigintToCurrentProcess(pid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private  String getCurrentPID() {
        // Get the PID of the current process
        String processName = ManagementFactory.getRuntimeMXBean().getName();
        return processName.split("@")[0];
    }

    private  void sendSigintToCurrentProcess(String pid) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        ProcessBuilder processBuilder;

        if (os.contains("mac") || os.contains("nix") || os.contains("nux")) {
            // Unix/Linux/MacOS command to send SIGINT (Ctrl+C)
            processBuilder = new ProcessBuilder("kill", "-2", pid);
        } else if (os.contains("win")) {
            // Windows does not have a direct equivalent to send SIGINT to a process
            throw new UnsupportedOperationException("Sending SIGINT is not directly supported on Windows.");
        } else {
            throw new UnsupportedOperationException("Unsupported operating system: " + os);
        }

        try {
            Process process = processBuilder.start();
            process.waitFor();
            System.out.println("Sent SIGINT (Ctrl+C) to process " + pid + " successfully.");
        } catch (IOException | InterruptedException e) {
            System.err.println("Failed to send SIGINT to process " + pid + ": " + e.getMessage());
            throw new IOException("Failed to send SIGINT to process " + pid, e);
        }
    }
}
