public class ProcessObject {
    private String processNumber;
    private Integer entryTime;


    private Integer brustTime;
    private Integer process_priority;

    public ProcessObject(String processNumber, Integer entryTime, Integer brustTime, Integer process_priority) {
        this.processNumber = processNumber;
        this.entryTime = entryTime;
        this.brustTime = brustTime;
        this.process_priority = process_priority;
    }

    public String getProcessNumber() {
        return processNumber;
    }

    public Integer getProcess_priority() {
        return process_priority;
    }

    public void setProcess_priority(Integer process_priority) {
        this.process_priority = process_priority;
    }

    public void setProcessNumber(String processNumber) {
        this.processNumber = processNumber;
    }

    public Integer getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Integer entryTime) {
        this.entryTime = entryTime;
    }

    public Integer getBrustTime() {
        return brustTime;
    }

    public void setBrustTime(Integer brustTime) {
        this.brustTime = brustTime;
    }
}
