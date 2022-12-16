package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.userInput.LineFunction;
import subway.domain.userInput.MainFunction;
import subway.domain.userInput.SectionFunction;
import subway.domain.userInput.StationFunction;
import subway.view.Input;
import subway.view.Output;

import java.util.Arrays;
import java.util.List;

public class MainController {
    private final Input input;
    private final Output output;

    public MainController(Input input, Output output) {
        this.input = input;
        this.output = output;
        initStation();
        initLine();
    }

    private void initStation() {
        List<String> stations = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String station : stations) {
            StationRepository.addStation(new Station(station));
        }
    }

    private void initLine() {
        List<String> lines = List.of("2호선", "3호선", "신분당선");
        List<List<String>> sections = Arrays.asList(List.of("교대역", "강남역", "역삼역"), List.of("교대역", "남부터미널역", "양재역", "매봉역"), List.of("강남역", "양재역", "양재시민의숲역"));
        for (int i = 0; i < lines.size(); i++) {
            Line line = new Line(lines.get(i));
            addSection(sections.get(i), line);
            LineRepository.addLine(line);
        }
    }

    private void addSection(List<String> sections, Line line) {
        for (String station : sections) {
            line.addSection(StationRepository.getStation(station));
        }
    }

    public void manageSubwayLines() {
        output.printFunctions(MainFunction.print());
        MainFunction mainFunction = input.getMainChoice();
        if (mainFunction == MainFunction.STATION) manageStation();
        if (mainFunction == MainFunction.LINE) manageLine();
        if (mainFunction == MainFunction.SECTION) manageSection();
        if (mainFunction == MainFunction.PRINT_LINES) output.printAllLinesAndStation(LineRepository.lines());
        if (mainFunction != MainFunction.QUIT) manageSubwayLines();
    }

    public void manageStation() {
        output.printFunctions(StationFunction.print());
        StationFunction stationFunction = input.getStationFunctionChoice();
        if (stationFunction == StationFunction.REGISTER) stationFunction = input.registerStation();
        if (stationFunction == StationFunction.DELETE) stationFunction = input.deleteStation();
        if (stationFunction == StationFunction.INQUIRY) stationFunction = output.printAllStations();
        if (stationFunction != StationFunction.BACK) manageStation();
    }

    private void manageLine() {
        output.printFunctions(LineFunction.print());
        LineFunction lineFunction = input.getLineFunctionChoice();
        if (lineFunction == LineFunction.REGISTER) lineFunction = input.registerLine();
        if (lineFunction == LineFunction.DELETE) lineFunction = input.deleteLine();
        if (lineFunction == LineFunction.INQUIRY) lineFunction = output.printAllLines();
        if (lineFunction != LineFunction.BACK) manageLine();
    }

    private void manageSection() {
        output.printFunctions(SectionFunction.print());
        SectionFunction sectionFunction = input.getSectionFunctionChoice();
        if (sectionFunction == SectionFunction.REGISTER) sectionFunction = input.registerSection();
        if (sectionFunction != SectionFunction.BACK) manageSection();
    }
}
