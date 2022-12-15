package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.Input;
import subway.view.Output;

import java.util.Arrays;
import java.util.List;

public class subwayController {
    private final Input input;
    private final Output output;

    public subwayController(Input input, Output output) {
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
        for (Line line : LineRepository.lines()) {
            System.out.println(line.getName() + line.toString());
        }
    }
}