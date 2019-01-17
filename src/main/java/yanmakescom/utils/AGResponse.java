package yanmakescom.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import yanmakescom.exception.AGStatus;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class AGResponse<T> {

    private String statusCode;
    private String statusDescription;
    private T content;

    public AGResponse(){
        this.statusCode= AGStatus.ERROR.getStatusCode();
        this.statusDescription=AGStatus.ERROR.getStatusDescription();

    }

    public AGResponse(String statusCode,String statusDescription){
        this.statusCode=statusCode;
        this.statusDescription=statusDescription;

    }

    public AGResponse(AGStatus agStatus) {
        this.statusCode = agStatus.getStatusCode();
        this.statusDescription = agStatus.getStatusDescription();
    }

    public AGResponse(T content) {
        this.statusCode = AGStatus.SUCCESS.getStatusCode();
        this.statusDescription = AGStatus.SUCCESS.getStatusDescription();
        this.content=content;
    }

    public AGResponse(String s) {
        this.statusCode = AGStatus.SUCCESS.getStatusCode();
        this.statusDescription = AGStatus.SUCCESS.getStatusDescription();
        this.content=null;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean hasContent(){
        return this.content!=null;
    }
}
