package Iteration3TestsNavneetKaur;

import java.util.List;

public class ReportService {
	public List<Report> getReports() {
        // Imagine this returns a list of reports fetched from a database or API
        return List.of(
//                new Report("event", "1pnMkBymAhnFnlbUv9Sl", "report", "Unknown User (Unknown Email)", "pending", "2024-11-18 14:00:00"),
//                new Report("product", "kdsfjkl342klk34", "spam", "Admin User", "resolved", "2024-11-19 09:30:00")
        		new Report("", "", "", "", "", ""),
                new Report("", "", "", "r", "", "")
        );
    }

}
