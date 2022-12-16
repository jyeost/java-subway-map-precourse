package subway.view;

import subway.domain.userInput.LineFunction;
import subway.domain.userInput.MainFunction;
import subway.domain.userInput.StationFunction;

public interface Input {
    MainFunction getMainChoice();

    StationFunction getStationFunctionChoice();

    StationFunction registerStation();

    StationFunction deleteStation();

    LineFunction getLineFunctionChoice();

    LineFunction registerLine();
}
