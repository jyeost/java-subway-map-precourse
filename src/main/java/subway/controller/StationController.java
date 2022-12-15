package subway.controller;

import subway.domain.userInput.StationFunction;
import subway.view.Input;
import subway.view.Output;

public class StationController {
    private final Input input;
    private final Output output;

    public StationController(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void manageStation() {
        output.printFunctions(StationFunction.print());
        StationFunction stationFunction = input.getStationFunctionChoice();
        if (stationFunction == StationFunction.REGISTER) stationFunction = registerStation();
        if (stationFunction != StationFunction.BACK) manageStation();
    }

    private StationFunction registerStation() {
        return input.registerStation();
    }
}
