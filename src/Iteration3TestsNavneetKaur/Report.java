package Iteration3TestsNavneetKaur;

public class Report {
	
	private String type;
    private String contentId;
    private String reason;
    private String reportedBy;
    private String status;
    private String reportedOn;

   
    public Report(String type, String contentId, String reason, String reportedBy, String status, String reportedOn) {
        this.type = type;
        this.contentId = contentId;
        this.reason = reason;
        this.reportedBy = reportedBy;
        this.status = status;
        this.reportedOn = reportedOn;
    }

    public String getType() {
        return type;
    }

    public String getContentId() {
        return contentId;
    }

    public String getReason() {
        return reason;
    }

    public String getReportedBy() {
        return reportedBy;
    }

    public String getStatus() {
        return status;
    }

    public String getReportedOn() {
        return reportedOn;
    }

}
