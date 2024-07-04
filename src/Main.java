import com.nawab.parkinglot.command.executors.CommandExecutorFactory;
import com.nawab.parkinglot.model.ParkingLot;
import com.nawab.parkinglot.modes.FileMode;
import com.nawab.parkinglot.modes.InteractionMode;
import com.nawab.parkinglot.modes.Mode;
import com.nawab.parkinglot.services.ParkingLotService;
import com.nawab.parkinglot.strategy.NaturalOrderStrategy;
import com.nawab.parkinglot.strategy.Strategy;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ParkingLot parkingLot = new ParkingLot();
        Strategy strategy = new NaturalOrderStrategy();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLot,strategy);
        CommandExecutorFactory commandExecutorFactory = new CommandExecutorFactory(parkingLotService);
        if(args.length == 0) {
            Mode interactiveMode = new InteractionMode(commandExecutorFactory);
            interactiveMode.process();
        }
        if(args.length == 1) {
            new FileMode(commandExecutorFactory,args[0]).process();
        }

    }
}