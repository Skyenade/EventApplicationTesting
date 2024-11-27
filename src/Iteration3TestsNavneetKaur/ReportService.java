package Iteration3TestsNavneetKaur;

import java.util.List;

public class ReportService {
	public List<Report> getReports() {
        return List.of(
        		new Report("", "", "", "", "", ""),
                new Report("", "", "", "r", "", "")
        );
    }

}
